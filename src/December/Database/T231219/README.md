# Aggregate Function

- 여러 열의 데이터를 모아, 특정 칼럼에 대해 데이터를 집계
- COUNT()

    ```sql
    -- 대한민국('South Korea') 국적을 가진 사람들이 몇명인지를 조회
    SELECT COUNT(*) FROM user WHERE country = 'South Korea';
    ```

- AVG()

    ```sql
    -- 대한민국('South Korea') 국적을 가진 사람들의 잔고의 평균 조회
    SELECT AVG(balance) FROM user WHERE country = 'South Korea';
    ```

- MAX(), MIN()

    ```sql
    -- 나이가 30 이상인 사람들의 잔고의 평균 조회
    SELECT AVG(balance), MAX(balance), MIN(balance) FROM user WHERE age >= 30;
    ```

- SUM()

### GROUP BY()

- 어떤 칼럼의 데이터를 기준으로 같은 열들을 묶을 수 있음

    ```sql
    -- GROUP BY
    -- 컬럼을 특정하여 동일한 값을 가진 행들을 그룹 단위로 모은다
    SELECT country, AVG(balance) 
    FROM user 
    GROUP BY country
    ORDER BY AVG(balance);
    ```

    ```sql
    -- 동명이인 찾기 (first_name이 동일한 사람들)
    SELECT first_name, COUNT(*) 
    FROM user 
    GROUP BY first_name 
    ORDER BY COUNT(*) DESC;
    ```

    ```sql
    -- 나라별 나이의 평균을 나이의 역순으로 정렬하여 출력
    SELECT AVG(age)
    FROM user
    GROUP BY country
    ORDER BY AVG(age) DESC;
    ```


---

# Normalization

- 관계형 데이터 모델에서 데이터의 중복성을 제거하여 이상 현상을 방지
- 데이터 일관성과 정확성 유지하기 위한 무손실 분해 과정

### 제 1 정규형

- 하나의 컬럼이 복수의 데이터를 가지고 있지 않아야 함

### 제 2 정규형

- 기본키에 종속되지 않은 컬럼은 테이블에서 분리되어야 함

### 제 3 정규형

- 기본키가 아닌 다른 속성에 종속성을 갖는 컬럼은 별도로 분리해야 함

---

# JOIN

## RDB에서의 관계

- 일반적으로 데이터베이스 테이블에서 관계는 외래키 사용해 표현

### 1 : 1 관계

- 한 테이블의 레코드 하나가 다른 테이블의 레코드 하나와 연관된 관계
- 특정 데이터를 성능 또는 보안적 측면에서 나눌 때 사용

### N : 1 관계

- 한 테이블의 레코드 0개 이상이 다른 테이블의 레코드 하나와 연관된 관계
- 일반적인 데이터베이스의 가장 흔한 관계

### M : N 관계

- 한 테이블의 레코드 0개 이상이 다른 테이블의 레코드 0개 이상과 연관된 관계
- 양쪽 테이블 PK를 Foreign Key로 가진 Join Table, Associative Table

## JOIN 사용

### CROSS JOIN

- 연관관계와 상관 없이 양쪽 테이블의 레코드를 각각 짝지은 결과

    ```sql
    -- CROSS JOIN
    SELECT *
    FROM lecture, instructor
    -- lecture가 가진 instructor_id
    -- instructor의 id가 일치한다
    WHERE lecture.instructor_id = instructor.id;
    ```


### INNER JOIN

- 양 쪽 테이블 모두 존재하는 데이터에 대해
- ON 절의 조건을 기준으로 조인

    ```sql
    --INNER JOIN
    SELECT *
    FROM lecture
    INNER JOIN instructor
    ON lecture.instructor_id = instructor.id;
    ```

    ```sql
    -- INNER JOIN은 연관짓고 싶은 칼럼이 존재해야 한다
    SELECT *
    FROM student INNER JOIN instructor
    ON student.advisor_id = instructor.ID;
    ```

- JOIN만 쓰면 INNER JOIN이 기본

    ```sql
    SELECT *
    FROM lecture JOIN instructor
    ON lecture.instructor_id = instructor.id;
    ```


### OUTER JOIN

- 삭제, 누락된 데이터를 함께 보려고 할 때 사용
- 존재하지 않는 쪽은 NULL
- RIGHT / LEFT에 따라 어떤 테이블 데이터가 누락되지 않을 지 결정

    ```sql
    -- 각 교수별 강의
    SELECT *
    FROM instructor LEFT OUTER JOIN lecture
    ON instructor.id = lecture.instructor_id;
    ```

    ```sql
    -- 학생별 지도교수, 지도교수가 학생을 맡지 않을 수 있음
    SELECT *
    FROM student RIGHT OUTER JOIN instructor
    ON student.advisor_id = instructor.id;
    ```

- OUTER 생략하고 방향만 지정 가능