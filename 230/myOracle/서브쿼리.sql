-- 서브쿼리
-- 서브쿼리의 위치상 종류 
--스칼라 쿼리 : SELECT(SELECT~~)
--인라인뷰: FROM(SELECT~~) 
--서브쿼리 WHERE 컬럼 비교연산(SELECT~~)

--서브쿼리의 반환행수별 종류
-- 단일행 서브쿼리 : 비교연산자 사용가능(=, <>, >, >=, <, <=) 
--메인쿼리와 비교할 떄 사용되는 연산자로는 일반비교연산자 쓰면 된다. 
-- 여러행 서브쿼리 : IN, ANY, ALL 연산자만 가능 
-- ANY보다 크다, 작다, ALL보다 크다, 작다 등 특수 연산자를 사용해야 한다. 

-- 최대급여를 받는 사원의 급여를 출력하시오 
SELECT MAX(SALARY) FROM EMPLOYEES;

-- 최대급여를 받는 사원의 사번, 이름, 급여를 출력하시오 
--1) 최대급여를 검색(계산)한다.->SELECT MAX(SALARY) FROM EMPLOYEES;
--2) 1)과 같은 급여를 받는 사원의 사번, 이름, 급여를 출력한다. 
-- FROM EMPLOYEES
--WHERE SALARY= 24000; 
--24000을 대신할 절차가 1)절차이게 된다. 
-- 그래서 WHERE SALARY=(SELECT MAX(SALARY) FROM EMPLOYEES);
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY 
FROM EMPLOYEES
WHERE SALARY = (SELECT MAX(SALARY) FROM EMPLOYEES);

-- 평균급여보다 많은 급여를 받는 사원의 사번, 이름, 급여를 출력하시오 
--1) 평균급여를 검색한다. 
--2) 1)보다 많은 급여를 받는 사원의 사번, 이름, 급여를 출력하시오 
SELECT employee_id, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEES);

-- 검산하지 않고 바로 나오도록 하기 
-- 최대급여를 받는 사원과 같은 부서에서 근무하는 사원들의 사번, 이름, 급여, 부서번호를 출력하시오 
--1) 최대급여를 검색한다. -- SELECT MAX(SALARY) FROM EMPLOYEES; 
--2) 1)과 같은 급여를 받는 사원의 부서번호를 검색한다. 
--3) 2)과 같은 부서번호를 갖는 사원을 출력한다. 
--SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID
--FROM EMPLOYEES
--WHERE SALARY=(SELECT MAX(SALARY) FROM EMPLOYEES);  2번 
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID 
                        FROM EMPLOYEES WHERE salary= (SELECT MAX(SALARY)FROM EMPLOYEES)); 

-- 여러행 서브쿼리 
-- 부서별 평균급여를 출력하시오 
SELECT DEPARTMENT_ID, AVG(SALARY)
FROM EMPLOYEES 
GROUP BY DEPARTMENT_ID;

--부서별 평균급여보다 많은 급여를 받는 사원의 부서사번, 이름, 급여를 출력하시오 
-- 1) 부서별 평균급여를 계산한다. 
-- 2) 1)보다 많은 급여를 받는 사원을 출력 
SELECT DEPARTMENT_ID, EMPLOYEE_ID, FIRST_NAME, SALARY 
FROM EMPLOYEES
WHERE SALARY >(SELECT AVG(SALARY)
FROM EMPLOYEES 
GROUP BY DEPARTMENT_ID);

SELECT DEPARTMENT_ID, EMPLOYEE_ID, FIRST_NAME, SALARY 
FROM EMPLOYEES
WHERE SALARY IN (SELECT AVG(SALARY)
FROM EMPLOYEES 
GROUP BY DEPARTMENT_ID);
-- 문제가 어려운 것 같아 변경 
--부서별 최대급여보다 많은 급여를 받는 사원의 부서사번, 이름, 급여를 출력하시오 
-- 1) 부서별 평균급여를 계산한다. 
-- 2) 1)과 같은 많은 급여를 받는 사원을 출력 
SELECT DEPARTMENT_ID, MAX(SALARY)
FROM EMPLOYEES 
GROUP BY DEPARTMENT_ID;

SELECT DEPARTMENT_ID, EMPLOYEE_ID, FIRST_NAME, SALARY 
FROM EMPLOYEES
WHERE SALARY =(SELECT AVG(SALARY)
FROM EMPLOYEES 
GROUP BY DEPARTMENT_ID);  -- 일반 비교연산자 사용 불가 

SELECT DEPARTMENT_ID, EMPLOYEE_ID, FIRST_NAME, SALARY 
FROM EMPLOYEES
WHERE SALARY IN (SELECT MAX(SALARY)
FROM EMPLOYEES 
GROUP BY DEPARTMENT_ID);-- (X: 결과가 틀림) 


SELECT DEPARTMENT_ID, EMPLOYEE_ID, FIRST_NAME, SALARY 
FROM EMPLOYEES
WHERE (DEPARTMENT_ID,SALARY)  IN (SELECT DEPARTMENT_ID,MAX(SALARY)
FROM EMPLOYEES 
GROUP BY DEPARTMENT_ID);-- 11건 NULL 부서제외 


SELECT DEPARTMENT_ID, EMPLOYEE_ID, FIRST_NAME, SALARY 
FROM EMPLOYEES
WHERE (NVL(DEPARTMENT_ID,0),SALARY)  IN (SELECT NVL(DEPARTMENT_ID,0),MAX(SALARY)
FROM EMPLOYEES 
GROUP BY DEPARTMENT_ID);-- 12건 NULL부서 포함 

-- =ANY는 IN과 같음 
SELECT DEPARTMENT_ID, EMPLOYEE_ID, FIRST_NAME, SALARY 
FROM EMPLOYEES
WHERE (NVL(DEPARTMENT_ID,0),SALARY) = ANY (SELECT NVL(DEPARTMENT_ID,0),MAX(SALARY)
FROM EMPLOYEES 
GROUP BY DEPARTMENT_ID);

--문제 
-- 직무가 IT_PROG인 사원들의 최대급여보다 작은 급여를 받는 사원의 사번, 이름, 급여, 직무번호를 출력하시오 
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY
FROM EMPLOYEES
WHERE SALARY
<(SELECT MAX(SALARY)
FROM EMPLOYEES 
WHERE JOB_ID = 'IT_PROG');  --80건 

--위의 문제를 ANY로 풀기 
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY
FROM EMPLOYEES
WHERE SALARY< ANY(SELECT SALARY 
FROM EMPLOYEES
    WHERE JOB_ID= 'IT_PROG');-- 80건 
-- 최대값보다 작은 이어서 ANY 

-- 직책(JOB_TILLE)이 'PRESIDENT'인 사원의 사번, 이름을 출력하시오 
SELECT EMPLOYEE_ID, FIRST_NAME 
FROM EMPLOYEES E NATURAL JOIN JOBS  
WHERE JOB_TITLE = 'President';

-- 위의 문제를 서브쿼리로 해결해보자. 
--1) 직책이 'President'인 job_id검색한다. 
--2) 1)과 같은 job_id갖는 사원을 추출한다. 
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE JOB_ID=(SELECT JOB_ID
FROM JOBS
WHERE JOB_TITLE = 'President');
-- 스칼라 쿼리 
-- SELECT절에서 서브쿼리를 사용하는 것을 의미한다. 
-- 부서번호, 부서명, 부서별 급여 총액 
-- 출력에 필요
SELECT DEPARTMENT_ID, DEPARTMENT_NAME, SUM(SALARY)
FROM EMPLOYEES E JOIN DEPARTMENTS D USING (DEPARTMENT_ID)
GROUP BY DEPARTMENT_ID, DEPARTMENT_NAME;--부서명과 부서 명도 출력해야 해서 같이함.


-- 성이 'Davies'인 사원과 같은 부서에 근무하는 사원들의 사번, 성, 이름을 출력하시오 
-- 출력할 정보가 굳이 조인으로 안 하고 서브쿼리로 해결할 수 있다. 
-- 1) 성이 'Davies'인 사원의 부서번호를 검색한다. 
-- 2) 1)와 같은 부서에 근무하는 사원들의 사번, 성, 이름을 출력 
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID
FROM employees 
WHERE department_id=
(SELECT department_id FROM employees WHERE last_name = 'Davies')
AND last_name <> 'Davies';


-- 스칼라 쿼리로 변환
SELECT DEPARTMENT_ID, (SELECT DEPARTMENT_NAME FROM DEPARTMENTS WHERE DEPARTMENT_ID = EMPLOYEES.DEPARTMENT_ID ), SUM(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID;
-- 부서명은 DEPARTMENTS에 있는 것이다.

------
--'Sales'부서의 평균급여보다 많은 급여를 받는 사원들의 부서번호, 사번, 급여를 출력하시오 
SELECT DEPARTMENT_ID, EMPLOYEE_ID, SALARY
FROM EMPLOYEES
WHERE SALARY  >  (SELECT AVG(SALARY) FROM DEPARTMENTS D, EMPLOYEES E WHERE D.DEPARTMENT_ID = E.DEPARTMENT_ID 
                AND DEPARTMENT_NAME = 'Sales'); 
                
        

SELECT AVG(SALARY)
FROM EMPLOYEES
WHERE DEPARTMENT_ID=80;



SELECT department_id, employee_id, salary
FROM employees 
WHERE salary >(SELECT AVG(salary) 
               FROM employees
               WHERE department_id = 
                   (SELECT department_id 
                    FROM departments 
                    WHERE department_name='Sales')
                    );


--'Sales'부서의 평균급여보다 많은 급여를 받는 'Sales' 사원들의 부서번호, 사번, 급여를 출력하시오 
-- sales부서의 사원들만 추출 
SELECT department_id, employee_id, salary
FROM employees 
WHERE salary >(SELECT AVG(salary) 
               FROM employees
               WHERE department_id = 
                   (SELECT department_id 
                    FROM departments 
                    WHERE department_name='Sales')
                    )
AND DEPARTMENT_ID=(SELECT department_id 
                    FROM departments 
                    WHERE department_name='Sales');
                    
--상호연관서브쿼리로 해결 
SELECT department_id, employee_id, salary
FROM employees MAINE
WHERE salary >(SELECT AVG(salary) 
               FROM employees 
               WHERE department_id = MAINE.DEPARTMENT_ID
                   )
AND DEPARTMENT_ID=(SELECT department_id 
                    FROM departments 
                    WHERE department_name='Sales');
-- INLINE VIEW 
-- ROWNUM : 행번호 의사컬럼 
SELECT ROWNUM, EMPLOYEE_ID, SALARY 
FROM EMPLOYEES;-- 행번호를 알 수 있다. 
-- 정렬을 해보자 
SELECT ROWNUM, EMPLOYEE_ID, SALARY 
FROM EMPLOYEES
ORDER BY SALARY;-- SELECT 순서로 인해 ROWNUM이 뒤죽박죽된다. 

-- 적은 급여를 받는 사원의 행번호가 1번부터 시작되도록 출력하시오 
SELECT ROWNUM, EMPLOYEE_ID, SALARY 
FROM (SELECT EMPLOYEE_ID, SALARY 
    FROM EMPLOYEES
    ORDER BY SALARY);  --FROM 절에서 사용하는 서브쿼리를 인라인뷰라고 한다.
-- 적은급여를 받는 사원의 행번호가 1번부터 시작되도록 출력하시오 
-- 행번호가 1~5행만 출력한다. 
SELECT ROWNUM, EMPLOYEE_ID, SALARY 
FROM (SELECT EMPLOYEE_ID, SALARY 
    FROM EMPLOYEES
    ORDER BY SALARY)
WHERE ROWNUM BETWEEN 1 AND 5; 


SELECT ROWNUM, EMPLOYEE_ID, SALARY 
FROM (SELECT EMPLOYEE_ID, SALARY 
    FROM EMPLOYEES
    ORDER BY SALARY)
WHERE ROWNUM BETWEEN 6 AND 10; 
-- 결과가 나오지 않아 인라인 뷰 한번 더 적용 
SELECT *
FROM(SELECT ROWNUM  R, EMPLOYEE_ID, SALARY -- 여기서 ROWNUM이 만들어져서, R과 비교 
    FROM (SELECT EMPLOYEE_ID, SALARY 
            FROM EMPLOYEES
             ORDER BY SALARY)
WHERE R BETWEEN 6 AND 10; 


