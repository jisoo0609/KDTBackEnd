--P1
-- 다음 정보를 포함하여
-- 사원 정보를 담기 위한 테이블을 만드는 SQL을 작성하시오.

-- 사원 이름(name)
-- 입사 연도(year)
-- 직급(grade)
-- 현재 연봉(salary)

CREATE TABLE employee (
    name VARCHAR(64),
    year INTEGER,
    grade VARCHAR(64),
    salary INTEGER
);