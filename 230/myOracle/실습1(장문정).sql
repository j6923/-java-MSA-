--1. 급여가 10000 이거나 14000 인 사원들의 사번, 이름(first_name), 급여를 검색하시오.
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY BETWEEN 10000 AND 14000;
--2. first_name 에 대소문자구별없이('e', 'E')를 포함하는 모든 사원을 검색하시오
SELECT FIRST_NAME
FROM EMPLOYEES 
WHERE UPPER(FIRST_NAME) LIKE '%E%';
--3. first_name 이 'J’로 시작하고 n 문자를 포함하는 사원의 사번, 이름을 검색하시오.
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE LOWER(FIRST_NAME) LIKE 'j%n%'
ORDER BY FIRST_NAME DESC;
--예)
--사번 이름
-----------------------
--110 John
--139 John
--145 John
--181 Jean
--189 Jennifer
--200 Jennifer
-----------------------
--4. 급여가 10000 이상인 사원의 사번, 부서번호, 이름, 급여, 수당을 출력하시오.단, 부서번호가
--30 번,60 번, 90 번인 부서는 제외하고 사원을 검색한다.
SELECT EMPLOYEE_ID "사번", DEPARTMENT_ID "부서번호", FIRST_NAME "이름", SALARY "급여", COMMISSION_PCT "수당"
FROM EMPLOYEES 
WHERE DEPARTMENT_ID NOT IN(30,60,90)
AND SALARY >= 10000
ORDER BY SALARY, EMPLOYEE_ID;
--5. 급여가 4000 보다 많은 사원들의 부서별 급여평균를 출력하시오. 단 급여평균은
--소숫점이하 2 자리에서 반올림합니다.
SELECT DEPARTMENT_ID AS 부서번호, ROUND(AVG(SALARY),1) AS 급여평균
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING AVG(SALARY)>4000;

--6. 부서배치를 받지 않은 사원은 제외하고 부서별 급여평균을 출력하시오.단 급여평균은
--소숫점이하 2 자리에서 반올림합니다.
SELECT DEPARTMENT_ID AS 부서번호, ROUND(AVG(SALARY),1) AS 급여평균
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY DEPARTMENT_ID
ORDER BY DEPARTMENT_ID;

--7. 부서배치를 받지 않은 사원은 제외하고 급여평균이 10000 이상인 부서별 급여평균을
--출력하시오.단 급여평균은 소숫점이하 2 자리에서 반올림합니다.
SELECT DEPARTMENT_ID AS 부서번호, ROUND(AVG(SALARY),1) AS 급여평균
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL 
GROUP BY DEPARTMENT_ID
HAVING AVG(SALARY) >= 10000
ORDER BY DEPARTMENT_ID;

--8. 직책(job_title)이 'President'인 사원의 사번, 이름을 출력하시오: (NaturalJOIN 으로 표현)
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES NATURAL JOIN JOBS
WHERE JOB_TITLE = 'President';

--9. 직책(job_title)이 'President'가 아닌 사원의 사번, 이름을 출력하시오(JOIN USING 으로 표현)
SELECT E.EMPLOYEE_ID, E.FIRST_NAME
FROM EMPLOYEES E JOIN JOBS J USING (JOB_ID)
WHERE J.job_title <> 'President'
ORDER BY EMPLOYEE_ID;
--10. 부서번호, 부서명, 부서별 급여총액과 평균급여를 출력하시오.
--단, 급여총액이 낮은 순으로 정렬하고,
--평균급여는 소수점 이하 1 자리까지 나타나도록 반올림해야 한다.

SELECT D.DEPARTMENT_ID, D.DEPARTMENT_NAME, SUM(E.SALARY), ROUND(AVG(E.SALARY),1)
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
GROUP BY E.SALARY, D.DEPARTMENT_ID, D.DEPARTMENT_NAME;

--11. 'Seattle', 'Toronto'도시에 근무하는
--사원들의 도시명,사번, 이름, 부서 ID, 부서명 을 출력하시오
SELECT L.CITY, E.FIRST_NAME, E.DEPARTMENT_ID, D.DEPARTMENT_NAME
FROM EMPLOYEES E JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
                JOIN LOCATIONS L ON D.LOCATION_ID = L.LOCATION_ID 
WHERE CITY IN ('Seattle', 'Toronto')
ORDER BY CITY;

--12. 'Seattle'을 제외한 도시의 부서별 사원수가 5 명미만인 도시명, 부서 ID, 부서명, 사원수를
--출력하시오 
SELECT L.CITY, E.DEPARTMENT_ID, D.DEPARTMENT_NAME, COUNT(D.DEPARTMENT_ID)
FROM EMPLOYEES E JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
                JOIN LOCATIONS L ON D.LOCATION_ID = L.LOCATION_ID
GROUP BY E.DEPARTMENT_ID,L.CITY, D.DEPARTMENT_NAME
HAVING COUNT(E.DEPARTMENT_ID)<5;

--13. 부서 ID 가 50 이거나 80 인 부서에 근무하는 사원들의 직무 ID 와 직책(job_title)을 출력하시오.
--결과에서 직종(job_id)의 중복은 제거하시오 --5 건
SELECT DISTINCT J.JOB_ID, JOB_TITLE 
FROM EMPLOYEES E JOIN JOBS J ON E.JOB_ID = J.JOB_ID
WHERE department_id IN (50,80);

--14. 사원의 사번, 관리자번호, 부서 ID, 부서명, 부서장 ID 를 출력하시오
SELECT E.EMPLOYEE_ID, D.MANAGER_ID, DEPARTMENT_ID, D.DEPARTMENT_NAME
FROM employees E JOIN DEPARTMENTS D USING (DEPARTMENT_ID);
--15. 성이 'Davies'인 사원의 부서 ID 와 급여를 출력하시오.
SELECT LAST_NAME, DEPARTMENT_ID, SALARY 
FROM EMPLOYEES 
WHERE LAST_NAME = 'Davies';
--16. 성이 'Davies'인 사원과 같은 부서에 근무하는 사원들의 사번, 성, 이름을 출력하시오--44 건
SELECT EMPLOYEE_ID, LAST_NAME, FIRST_NAME
FROM EMPLOYEES  JOIN DEPARTMENTS  USING (DEPARTMENT_ID)
WHERE DEPARTMENT_ID=(SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE LAST_NAME='Davies');

SELECT e.EMPLOYEE_ID, LAST_NAME, e.FIRST_NAME
FROM employees E JOIN employees davisE using (last_name)
order by employee_id;
