-- Data Definition Language --
-- 데이터 정의를 위한 SQL --
-- 테이블 생성, 수정, 삭제 --
-- 테이블 만들기 --

-- 학생 정보 테이블 생성
CREATE TABLE student (
    id INTEGER,
    first_name VARCHAR(64),
    last_name VARCHAR(64),
    email VARCHAR(64),
    admitted INTEGER
);

-- DROP TABE - 테이블을 제거할때
DROP TABLE student;

-- 강의 정보를 담기 위한 테이블 생성
CREATE TABLE lecture (
  name VARCHAR(64),
  major VARCHAR(64),
  professor VARCHAR(64),
  max_student INTEGER
);

-- 강사 정보를 담기 위한 테이블
CREATE TABLE lecturer (
    name VARCHAR(64),
    major VARCHAR(64),
    grade VARCHAR(64),
    articles INTEGER
);