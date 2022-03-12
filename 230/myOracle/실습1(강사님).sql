-- 1. 급여가 10000 이거나 14000 인 사원들의 사번, 이름(first_name), 급여를 검색하시오.
SELECT employee_id 사번, first_name 이름, salary 급여
FROM employees
WHERE  salary IN (10000 ,14000);

-- 2. first_name 에 대소문자구별없이('e', 'E')를 포함하는 모든 사원을 검색하시오
SELECT employee_id, first_name
FROM employees
WHERE upper(first_name) LIKE '%E%';

-- 3. first_name 이 'J’로 시작하고 n 문자를 포함하는 사원의 사번, 이름을 검색하시오.
SELECT employee_id, first_name
FROM employees
WHERE  first_name LIKE 'J%n%';

--4 급여가 10000 이상인 사원의 사번, 부서번호, 이름, 급여, 수당을 출력하시오.단, 부서번호가
--  30 번,60 번, 90 번인 부서는 제외하고 사원을 검색한다.
SELECT employee_id 사번, department_id 부서번호, 
first_name ||' '|| last_name "사원 성명", salary 월급 , salary+(salary*NVL(commission_pct, 0)) 수당
FROM employees
WHERE  salary >= 10000 AND department_id NOT IN (30, 60, 90);

--5. 급여가 4000 보다 많은 사원들의 부서별 급여평균를 출력하시오. 단 급여평균은
--   소숫점이하 2 자리에서 반올림합니다.
SELECT department_id 부서번호 ,ROUND(AVG(salary),1) 평균급여
FROM employees
WHERE salary > 4000
GROUP BY department_id;

--6. 부서배치를 받지 않은 사원은 제외하고 부서별 급여평균을 출력하시오.단 급여평균은
--   소숫점이하 2 자리에서 반올림합니다.
SELECT department_id 부서번호 ,ROUND(AVG(salary),1) 평균급여
FROM employees
WHERE department_id is not null
GROUP BY department_id;

--7. 부서배치를 받지 않은 사원은 제외하고 급여평균이 10000 이상인 부서별 급여평균을
--   출력하시오.단 급여평균은 소숫점이하 2 자리에서 반올림합니다
SELECT department_id 부서번호 ,ROUND(AVG(salary),1) 평균급여
FROM employees
WHERE department_id is not null
GROUP BY department_id
HAVING avg(salary) >= 10000;

--8 직책(job_title)이 'President'인 사원의 사번, 이름을 출력하시오: (NaturalJOIN 으로 표현)
SELECT employee_id, first_name 
FROM employees 
NATURAL JOIN jobs 
WHERE job_title = 'President';

--9. 직책(job_title)이 'President'가 아닌 사원의 사번, 이름을 출력하시오(JOIN USING 으로 표현)
SELECT employee_id, first_name
FROM employees JOIN jobs USING(job_id) 
WHERE job_title <> 'President';

--10. 부서번호, 부서명, 부서별 급여총액과 평균급여를 출력하시오.
--    단, 급여총액이 낮은 순으로 정렬하고,
--    평균급여는 소수점 이하 1 자리까지 나타나도록 반올림해야 한다
SELECT e.department_id 부서번호, d.department_name 부서명 ,SUM(e.salary)급여총액 , ROUND(AVG(e.salary),1)평균급여
FROM employees e JOIN departments d ON e.department_id = d.department_id
GROUP BY e.department_id , d.department_name
ORDER BY  3;


-- 11. 'Seattle', 'Toronto'도시에 근무하는
--      사원들의 도시명,사번, 이름, 부서 ID, 부서명 을 출력하시오
-- join on
SELECT l.CITY 도시명,  e.employee_id 사번, e.first_name 이름, d.department_id 부서ID, d.department_name 부서명
FROM employees e 
     JOIN departments d ON e.department_id = d.department_id 
     JOIN locations l ON d.location_ID = l.location_id 
WHERE  L.CITY IN( 'Seattle', 'Toronto');

-- 12. 'Seattle'을 제외한 도시의 부서별 사원수가 5 명미만인 도시명, 부서 ID, 부서명, 사원수를 출력하시오.
SELECT city, d.department_id, department_name, COUNT(*)
FROM employees e 
JOIN departments d ON (e.department_id = d.department_id) 
JOIN locations l ON (d.location_id = l.location_id)
WHERE  l.city <> 'Seattle'
GROUP BY city, d.department_id, department_name
HAVING COUNT(*) < 5;

-- 13. 부서 ID 가 50 이거나 80 인 부서에 근무하는 사원들의 직무 ID 와 직책(job_title)을 출력하시오.
-- 결과에서 직종(job_id)의 중복은 제거하시오 --5 건
SELECT DISTINCT e.job_id, job_title
FROM employees e JOIN jobs j ON (e.job_id = j.job_id)
WHERE e.department_id IN (50, 80);

-- 14. 사원의 사번, 관리자번호, 부서 ID, 부서명, 부서장 ID 를 출력하시오  
SELECT employee_id 사번, e.manager_id 관리자번호, department_id "부서 ID", department_name 부서명, d.MANAGER_ID "부서장 ID"
FROM employees e JOIN departments d USING(department_id);

-- 15. 성이 'Davies'인 사원의 부서 ID 와 급여를 출력하시오. 
SELECT department_id, salary --50, 3100
FROM employees
WHERE last_name = 'Davies';

-- 16.성이 'Davies'인 사원과 같은 부서에 근무하는 사원들의 사번, 성, 이름을 출력하시오--44 건
--<<16번 힌트>>
--사원테이블은 물리적으로 1개이지만 논리적으로 2개이상으로 처리할 수 있습니다 
SELECT e.employee_id, e.last_name, e.first_name, e.department_id
FROM employees E JOIN employees Davies
ON e.department_id = davies.department_id
WHERE davies.last_name = 'Davies'
AND e.last_name <> 'Davies';
