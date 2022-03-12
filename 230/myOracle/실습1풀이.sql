--1. 급여가 10000 이거나 14000 인 사원들의 사번, 이름(first_name), 급여를 검색하시오.
SELECT EMPLOYEE_ID 사번, FIRST_NAME 이름, SALARY 급여 
FROM EMPLOYEES
WHERE SALARY IN (1000,14000);
--2. first_name 에 대소문자구별없이('e', 'E')를 포함하는 모든 사원을 검색하시오
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLYEES
WHERE UPPER(FIRST_NAME ;
--3. first_name 이 'J’로 시작하고 n 문자를 포함하는 사원의 사번, 이름을 검색하시오.
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
SELECT EMPLOYEE_ID 사번, DEPARTMENT_ID 부서번호, first_name||' '|| LAST_NAME "사원 성명", SALARY 월급, SALARY+(SALARY*NVL(COMMISSION_PCT,0)) 수당
FROM EMPLOYEES
WHERE SALARY >= 10000 AND DEPARTMENT_ID NOT IN (30,60,90);
--5. 급여가 4000 보다 많은 사원들의 부서별 급여평균를 출력하시오. 단 급여평균은
--소숫점이하 2 자리에서 반올림합니다.
SELECT 
--6. 부서배치를 받지 않은 사원은 제외하고 부서별 급여평균을 출력하시오.단 급여평균은
--소숫점이하 2 자리에서 반올림합니다.
--7. 부서배치를 받지 않은 사원은 제외하고 급여평균이 10000 이상인 부서별 급여평균을
--출력하시오.단 급여평균은 소숫점이하 2 자리에서 반올림합니다.
--8. 직책(job_title)이 'President'인 사원의 사번, 이름을 출력하시오: (NaturalJOIN 으로 표현)
--8. 직책(job_title)이 'President'인 사원의 사번, 이름을 출력하시오: (NaturalJOIN 으로 표현)
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES NATURAL JOIN JOBS
WHERE JOB_TITLE = 'President';
--9. 직책(job_title)이 'President'가 아닌 사원의 사번, 이름을 출력하시오(JOIN USING 으로 표현)
SELECT E.EMPLOYEE_ID, E.FIRST_NAME
FROM EMPLOYEES E JOIN JOBS J USING (JOB_ID)
WHERE J.job_title <> 'President';

--10. 부서번호, 부서명, 부서별 급여총액과 평균급여를 출력하시오.
--단, 급여총액이 낮은 순으로 정렬하고,
--평균급여는 소수점 이하 1 자리까지 나타나도록 반올림해야 한다.
SELECT D.DEPARTMENT_ID, D.DEPARTMENT_NAME, SUM(E.SALARY)급여총액, ROUND(AVG(E.SALARY),1)
FROM EMPLOYEES E JOIN DEPARTMENTS D ON E.DEPARTMENT_ID=D.DEPARTMENT_ID
GROUP BY D.DEPARTMENT_ID, D.DEPARTMENT_NAME
--그룹함수하고 같이 사용할 수 있는 그룹함수와 같이 사용할 수 있다
-- 부서명도 출력하려면 GROUP BY에 DEPARTMENT_NAME 도 해야 한다. 
ORDER BY 급여총액;
--11. 'Seattle', 'Toronto'도시에 근무하는
--사원들의 도시명,사번, 이름, 부서 ID, 부서명 을 출력하시오
SELECT L.CITY, E.FIRST_NAME, E.DEPARTMENT_ID, D.DEPARTMENT_NAME
FROM EMPLOYEES E JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
                JOIN LOCATIONS L ON D.LOCATION_ID = L.LOCATION_ID 
WHERE CITY IN ('Seattle', 'Toronto');

--12. 'Seattle'을 제외한 도시의 부서별 사원수가 5 명미만인 도시명, 부서 ID, 부서명, 사원수를
--출력하시오
SELECT CITY, D.DEPARTMENT_ID, DEPARTMENT_NAME, COUNT(*)  
FROM EMPLYEES E
JOIN DEPARTMENTS D  ON (E.DEPARTMENT_ID=D.DEPARTMENT_ID)
JOIN LOCATIONS L ON (D.LOCATION_ID = L.LOCATION_ID)
WHERE L.CITY <> 'Seattle'
GROUP BY CITY, D.EPARTMENT_ID, DEPARTMENT_NAME
-- 그룹BY에서 사용한 컬럼만 설렉트 절에서 사용가능 
HAVING COUNT(*) <5;

--13. 부서 ID 가 50 이거나 80 인 부서에 근무하는 사원들의 직무 ID 와 직책(job_title)을 출력하시오.
--결과에서 직종(job_id)의 중복은 제거하시오 --5 건
SELECT DISTINCT E.JOB_ID, JOB_TITLE
FROM EMPLOYEES E JOIN JOBS J ON (E.JOB_ID = J.JOB_ID)
WHERE E.DEPARTMENT_ID IN (50,80);

--14. 사원의 사번, 관리자번호, 부서 ID, 부서명, 부서장 ID 를 출력하시오
SELECT EMPLOYEE_ID 사번, E.MANAGER_ID 관리자번호, DEPARTMENT_ID "부서", DEPARTMENT_NAME "부서명", D.MANAGER_ID"부서장"
FROM EMPLOYEES E JOIN DEPARTMENTS D USING (DEPARTMENT_ID);
-- 200은 부서장이면서 부서장의 윗사람 
--201은 자기가 부서장 --202번 사원은 
--15. 성이 'Davies'인 사원의 부서 ID 와 급여를 출력하시오.
SELECT DEPARTMENT_ID, SALARY
FROM EMPLOYEES
WHERE LAST_NAME = 'Davies';
--16. 성이 'Davies'인 사원과 같은 부서에 근무하는 사원들의 사번, 성, 이름을 출력하시오--44 건
SELECT e.employee_id, e.last_name, e.first_name, e.department_id
FROM employees E JOIN employees Davies
ON e.department_id = davies.department_id
WHERE davies.last_name = 'Davies'
AND e.last_name <> 'Davies';
