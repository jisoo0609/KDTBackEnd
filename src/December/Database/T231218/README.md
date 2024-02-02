# Database

- 데이터를 액세스하기 위한 프로그램의 집합
- 특정 분야 관련 정보를 저장 / 관리

## RDBMS (Relational DataBase Management System)

- 관계형 데이터베이스를 다루기 위한 프로그램의 일종
- 프로그램과 소통하여 데이터베이스를 조작할 수 있게 함

## 관계형 데이터베이스

- 데이터를 관계(Relation)로 표현한 데이터베이스
- 데이터를 테이블, 행, 열 등으로 나눠서 구조화 해 체계적으로 관리
- 자료를 여러 테이블에 나눠서 관리하고, 테이블 간 관계를 설정
- 데이터 무결성 유지의 장점
- SQL을 이용해 데이터를 조회하고 조작

## 특징

### 스키마

- DB의 논리 구조
    - 물리적 스키마: 물리적 단계의 데이터베이스 설계
    - 논리적 스키마: 논리적 단계의 데이터베이스 설
- 관계형 데이터베이스가 가진 데이터의 구조를 표현
- 기본적인 데이터베이스 자료의 구조와 표현 방법 명세

### 테이블

- 필드와 레코드를 사용해 조직된 데이터 요소들의 집합
    - 필드
        - Attribute (Column)
        - 각 필드에는 고유의 데이터 형식이 지정됨
    - 레코드
        - Tuple (Row)
        - 레코드 하나는 테이블 하나의 데이터

### Primary Key

- 기본키
- 후보 키 중 하나
- 레코드의 고유한 값
- 기술적으로 다른 항목과 중복 불가
- 데이터베이스 관리와 테이블 간 관계 설정 시 중요하게 활용

### Foreign Key

- 다른 테이블의 PK

---

# SQL

- Structured Query Language

## DCL (Data Control Language)

- 데이터 제어어
- 데이터베이스에 접근하고 객체들을 사용하도록 권한을 설정하는 명령어
    - GRANT, REVOKE

## DDL (Data Definition Language)

- 데이터 정의어
- 테이블과 같은 데이터 구조를 정의하는데 사용되는 명령어
- 객체의 생성, 변경, 삭제
    - CREATE, ALTER, DROP

## DML (Data Manipulation Language)

- 데이터 조작어
- 데이터베이스에 들어있는 데이터를 조회 및 검색하는 명령어
    - SELECT
- 데이터베이스의 데이터에 변형을 가하는 명령어
    - INSERT, UPDATE, DELETE

## SQL 기본 문법

- SELECT, INSERT 등 키워드로 시작
- Statement (문)
    - 독립적으로 실행할 수 있는 완전한 코드조각
- Clause (절)
    - Statement를 이루는 작은 단위

---

# SQL DDL 적용

## CREATE

- Schema, Domain, Table, View, Index를 정의
- 정보를 저장하는 개체를 만드는 일

    ```sql
    CREATE TABLE student (
        id INTEGER
    );
    ```

- 컬럼의 타입 지정

    ```sql
    -- 학생 정보 테이블 생성
    CREATE TABLE student2 (
        id INTEGER,
        first_name VARCHAR(64),
        last_name VARCHAR(64),
        email VARCHAR(64),
        admitted INTEGER
    );
    ```


## ALTER

- 테이블에 대한 정의를 변경하는 데 사용
- RENAME TO
    - 테이블 이름 수정

    ```sql
    ALTER TABLE student RENAME TO student_backup;
    ```

- RENAME COLUMN
    - 테이블의 컬럼이름을 수정

    ```sql
    ALTER TABLE student RENAME COLUMN first_name TO given_name;
    ```

- ADD COLUMN
    - 테이블에 컬럼 추가

    ```sql
    ALTER TABLE student ADD COLUMN address VARCHAR(256);
    ```

    - 제약사항 넣어서 추가하기

    ```sql
    ALTER TABLE student ADD COLUMN phone VARCHAR(128) NOT NULL DEFAULT '';
    ```


## DROP

- Schema, Domain, Table, View, Index를 삭제

    ```sql
    -- DROP TABE - 테이블을 제거할때
    DROP TABLE student;
    DROP TABLE student2;
    ```

    ```sql
    ALTER TABLE student DROP COLUMN phone;
    ```


## 데이터 무결성

- Constraints
    - 데이터 무결성을 유지하기 위해 테이블의 컬럼에 들어올 수 있는 데이터를 제한시키는 제약 조건

```sql
CREATE TABLE student (
     id INTEGER PRIMARY KEY AUTOINCREMENT, -- implicit NOT NULL
     first_name VARCHAR(64) NOT NULL,
     last_name VARCHAR(64) NOT NULL ,
     email VARCHAR(64) UNIQUE ,
     admitted INTEGER
);
```

- 제약사항
    - NOT NULL
        - 컬럼에 NULL이 들어올 수 없음

        ```sql
        -- 컬럼을 만들면서 뒤에 제약사항을 넣어줌
        first_name VARCHAR(64) NOT NULL,
        ```

    - UNIQUE
        - 각 레코드의 해당 컬럼의 값 고유해야 함

        ```sql
        email VARCHAR(64) UNIQUE,
        ```

    - PRIMARY KEY
        - 해당 컬럼을 PK로 지정
        - 암시적으로 NOT NULL
    - AUTOINCREMENT
        - 자동으로 값 하나씩 증가

        ```sql
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        ```


---

# SQL DML

- 테이블 내 데이터를 조작하기 위한 언어
- INSERT, SELECT, UPDATE, DELETE

## INSERT

- 데이터를 추가할 때 사용

    ```sql
    INSERT INTO user (first_name, last_name, age, balance)
    VALUES ('Alex', 'Rod', 50, 1000000);
    ```


## SELECT

- 데이터 전체 조회

    ```sql
    SELECT * FROM user;
    ```

- 특정 컬럼의 데이터만 조회

    ```sql
    -- 특정 컬럼의 데이터만 조회하기
    SELECT first_name, last_name FROM user;
    ```


### ORDER BY

- 순서를 지정회서 조회
- 기본 오름차순, 내림차순 시 DESC 추가

    ```sql
    SELECT first_name FROM user ORDER BY age;
    ```

    ```sql
    SELECT first_name FROM user ORDER BY age DESC;
    ```


### SELECT DISTINCT

- 해당 컬럼을 중복없이 조회

    ```sql
    -- 중복 없이 나이를 조회
    SELECT DISTINCT age FROM user;
    ```

    ```sql
    -- 중복 없이 first_name 조회
    SELECT DISTINCT first_name FROM user;
    ```


### SELECT WHERE

- 조회 시 조건을 지정
- 기본적인 등호 / 부등호 연산

    ```sql
    -- 나이가 30 미만인 사람들의 first_name만 조회
    SELECT first_name FROM user WHERE age < 30;
    ```

    ```sql
    -- balance가 150인 사람들의 나이 조회
    SELECT * FROM user WHERE balance = 157;
    ```

- AND, OR 조합 가능

    ```sql
    -- balance가 150 이상이면서 나이가 30 미만인 사람들을 조회
    SELECT * FROM user WHERE balance >= 150 AND age < 30;
    ```

    ```sql
    -- balance가 150 이상이면서 나이가 30 미만인 사람들을 나이순, 이름순으로 조회
    SELECT * FROM user WHERE balance >= 150 AND age < 30 ORDER BY age, first_name;
    ```


### SEELCT WHERE LIKE

- 문자열 비교 조회, 일부분이 일치하는지 확인
- %: 0개 이상의 문자와 동일하게 취급

    ```sql
    -- first_name이 A로 시작하는 사람들만 조회
    SELECT * FROM user WHERE first_name LIKE 'A%';
    ```

- _: 1개 이상의 문자와 동일하게 취급

    ```sql
    -- first_name이 A로 시작하는 사람들 중 이름이 4글자로 이루어진 사람들만 조회
    SELECT * FROM user WHERE first_name LIKE 'A___';
    ```


## UPDATE

- UPDATE (TABLE)

  SET (COLUMN) = VALUE

  WHERE (조건)

    ```sql
    -- 갱신할 테이블
    UPDATE user
    -- 갱신할 컬럼에 넣을 데이터
    SET age = 0
    -- 어떤 열들을 대상으로 하는지
    WHERE age IS NULL;
    ```

    ```sql
    -- Alex를 이름으로 가진 열의 나이를 60으로, balance를 0으로
    UPDATE user
    SET age = 60, balance = 0
    WHERE first_name = 'Alex';
    ```

    ```sql
    -- country가 NULL인 열들의 국적을 KOREA로
    UPDATE user
    SET country = 'Korea'
    WHERE country IS NULL;
    ```

    - WHERE 생략하는 경우 테이블 전체가 수정됨

## DELETE

- DELETE FROM (TABLE) WHERE (조건)

    ```sql
    -- first_name이 Alex인 열을 지운다
    DELETE FROM user
    WHERE first_name = 'Alex';
    ```