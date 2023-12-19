-- 테이블을 만든다
-- 학생이름, 입학 년도, 전공
CREATE TABLE student (
    -- id를 기본 키로 설정
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    -- name은 중복되면 안된다
    name VARCHAR(32) UNIQUE,
    year INTEGER,
    -- major는 비어있으면 안된다
    major VARCHAR(32) NOT NULL
);

-- 데이터 자체에 할 수 있는 4가지 작업
-- CREATE READ UPDATE DELETE
-- INSERT SELECT UPDATE DELETE
INSERT INTO student(name, year, major)
VALUES ('Alex', 1999, 'CSE');

SELECT * FROM student;
SELECT name, major FROM student;
SELECT name FROM student WHERE major = 'CSE';

UPDATE student
SET major = 'Computer Science Engineering'
WHERE major = 'CSE';

DELETE FROM student
WHERE name = 'Alex';
