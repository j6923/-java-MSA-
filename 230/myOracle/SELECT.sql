select * from employees;
-- ctrl + enter 
-- *은 모든 컬럼이고 from 다음은 테이블 이다. 
-- 테이블이 갖는 모든 컬럼 가져와 .
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, HIRE_DATE
FROM EMPLOYEES;

--COMMENT 

--컬럼 별칭 주기 : HEADING에 별칭값이 나타남, HEADING은 기본 대문자로 출력됨.  
SELECT EMPLOYEE_ID 사번, FIRST_NAME "사원 이름", salary, hire_date "hiredate"
FROM EMPLOYEES; 

-- 문자열 기호 ''
-- 문자열결합연산자 ||
SELECT employee_id, first_name, last_name, first_name||last_name, first_name ||'-'|| last_name "사원 성명"
FROM EMPLOYEES;

--연산자 
-- 산술연산자 : +, -, *, /
-- 비교연산자 : >, <, >=, <=, = , <>
-- 대입연산자 : = 


-- BETWEEN 연산자: <= AD ]

-- 특정 행 추출하기 : WHERE 

-- 급여가 5000이상인 사원들의 사번, 이름, 급여를 출력하시오. 
SELECT EMPLOYEE_ID, FIRST_NAME, salary 
FROM EMPLOYEES
WHERE salary >= 5000;

---급여를 12달 곱한 값이 100000이상인 사원들의 사번, 이름, 급여를 출력하시오. 
SELECT employee_id, first_name, salary, salary*12
from employees 
where salary * 12 >= 100000;

--급여가 5000이상 10000이하인 사원들의 사번, 이름, 급여를 출력하시오. 
SELECT employee_id, first_name, salary
FROM employees
where salary>=5000 and salary<=10000;


SELECT employee_id as 사번, first_name as 이름, salary as 급여
FROM employees
where salary between 5000 and 10000;

-- 사원들의 사번, 부서번호를 출력하시오 
SELECT employee_id, department_id
FROM employees;

-- 부서번호가 90이거나, 30이거나 20인 사원들의 사번, 부서번호를 출력하시오. 
SELECT employee_id, department_id
FROM employees
WHERE department_id=90 OR department_id =30 OR department_id = 20; 


SELECT employee_id as 사번, first_name as 이름, salary as 급여
FROM employees
where department_id in (90,30,20);
-- department_id에 90,30,20이 있는 것 

--부서번호가 90이거나, 30이거나 20이고 
--급여가 5000이상 10000이하인 사원들의 사번, 이름, 급여를 출력하시오.

SELECT employee_id as 사번, first_name as 이름, salary as 급여
FROM employees
WHERE (department_id=90 OR department_id =30 OR department_id = 20)
AND salary>=5000 and salary<=10000; 


SELECT employee_id as 사번, first_name as 이름, salary as 급여
FROM employees
WHERE department_id IN (90,30,20) AND salary BETWEEN 5000 AND 10000;
-- 

--부서번호가 90아니고 , 30아니고 20아닌 부서의 사번, 이름, 부서번호를 출력하시오. 
SELECT employee_id, first_name, department_id
FROM employees
WHERE department_id <> 90 AND department_id <>30 AND department_id<>20;

SELECT employee_id, first_name, department_id
FROM employees
WHERE department_id NOT IN(90, 30,20);



-- LIKE % _ 
-- 직무 테이블 
SELECT *FROM jobs;
-- Manager로 끝나는 직무명을 출력하시오. 
SELECT JOB_TITLE
FROM jobs
WHERE JOB_TITLE LIKE '%Manager';

--사원의 이름에 'e'를 포함한 사원들의 사번과 이름을 출력하시오. 
SELECT employee_id, first_name
FROM EMPLOYEES
WHERE first_name Like '%e%';

-- 사원의 입사일자 
SELECT hire_date From employees;
--입사년도가 07년도인 사원의 사번과 입사일자를 출력하시오 
SELECT employee_id, hire_date
FROM employees
WHERE hire_date Like '07%';

SELECT employee_id, hire_date
FROM employees
WHERE hire_date BETWEEN '07/01/01' AND '07/12/31';

-- 입사월이 11월인 사원의 사번, 입사일자를 출력하시오. 
-- 각 년도에 신입사원을 알고 싶을 떄 
SELECT employee_id, hire_date
FROM employees
WHERE hire_date LIKE '__/11/__';

----------ORDAET BY: 정렬 
-- 적은 급여를 받은 사원부터 사번, 이름, 급여를 출력하시오. 
SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary;

--내림차순 
-- 많은 급여를 받은 사원부터 사번, 이름, 급여를 출력하시오.
SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary DESC;

SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary DESC;
-- 많은 급여를 받은 사원부터 사번, 이름, 급여를 출력하시오. 단 급여같은 경우 이름을 사전순으로 출력하시오. 
SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary DESC, first_name ASC;

SELECT employee_id 사번, first_name 이름, salary 급여
FROM employees
ORDER BY 급여 DESC, first_name ASC;  -- 별칭사용

-- 컬럼 위치를 해서 사용해보자. 
SELECT employee_id 사번, first_name 이름, salary 급여
FROM employees
ORDER BY 3 DESC, first_name ASC;  -- 위치사용

-- 많은 급여를 받는 사원부터 사번, 이름을 출력하시오. 
SELECT employee_id, first_name
FROM employees
ORDER BY salary DESC;
-- ------
--distinct 
-- 사원의 부서번호를 출력하시오. 
SELECT department_id
FROM employees;

-- 사원이 속한 부서번호를 중복없이 출력하시오. 
SELECT DISTINCT department_id
FROM employees;

-- 사원이 속한 부서번호, 직무번호를 출력하시오 
SELECT department_id, job_id
FROM employees
ORDER BY department_id, job_id;

-- 사원이 속한 부서번호, 직무번호를 중복없이 출력하시오
SELECT DISTINCT department_id, job_id
FROM employees
ORDER BY department_id, job_id;

-----------------------------
--NULL : 아무것도 아니다 
SELECT employee_id, first_name, last_name, department_id, salary, commission_pct
FROM employees;

--부서배치 받지 않는 사원의 사번, 이름, 부서번호를 출력하시오. 
SELECT employee_id, first_name, department_id
FROM employees
WHERE department_id = null;  --아무 값이 안 나온다. 


SELECT employee_id, first_name, department_id
FROM employees
WHERE department_id is null;

--부서배치 받은 사원의 사번, 이름, 부서번호를 출력하시오. 
SELECT employee_id, first_name, department_id
FROM employees
WHERE department_id IS NOT null;

-- 모든 사원의 사번, 이름, 급여, 수당률, 금여*수당률을 출력하시오 
SELECT employee_id, first_name, commission_pct, (salary*commission_pct)+salary 실급여
FROM employees;

-- NULL관련 함수 : NVL(표현식, 반환값)표현식의 결과가 NULL이면 반환값을 반환하고, 표현식이 NULL이 아니면 표현식값을 반환한다. 
SELECT employee_id, first_name, commission_pct, (salary*NVL(commission_pct,0))+salary 실급여
FROM employees;
-- 작은 부서번호를 갖는 사원부터 출력하시오. 
SELECT employee_id, department_id
FROM employees
ORDER BY department_id; --오름차순하면 null이 가장 마지막에 출력됨, DBMS마다 다름. 

--------------
-- ROWNUM : 행번호값을 갖는 의사컬럼 
SELECT rownum, employee_id FROM employees;
SELECT rownum, employee_id, salary FROM employees ORDER BY salary DESC;

--급여를 많이 받는 사원순으로 5명만 출력하시오 
SELECT rownum,employee_id, salary
FROM employees
WHERE rownum<=5
ORDER BY salary DESC; --(X)

