--문자형함수
--길이:LENGTH()
--더미테이블인 DUAL로 실험하기 , 한 행을 반환한다. 
SELECT LENGTH('오라클'), LENGTHB('오라클')
FROM DUAL; 

SELECT EMPLOYEE_ID, FIRST_NAME, LENGTH(FIRST_NAME)
FROM EMPLOYEES;
--이름이 8자리이상인 사원들의 사번, 이름을 출력하시오. 
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE LENGTH(FIRST_NAME)>=8; 

-- 대문자로 변환 : UPPER() 
-- 소문자로 변환: LOWER()
-- 첫글자만 대문자로 변환: INITCAP()
SELECT UPPER('heLLo'), LOWER('heLLo'), INITCAP('heLLO')
FROM DUAL;
-- 특정문자의 위치반환: INSTR()
SELECT INSTR('hellojava','a')
FROM DUAL; 

SELECT INSTR('hellojava','a')
        ,INSTR('hellojava', 'a', 8)  --8번위치부터 찾아라 
FROM DUAL; 


SELECT INSTR('hellojava','a')
        ,INSTR('hellojava', 'a', 8)  --8번위치부터 찾아라 
        ,INSTR('hellojava', 'b')   --0 해당 위치 못찾으면0을 반환 
        ,INSTR('hellojava','a', -1)  --9번 반환하는데 퍼포먼트는 얘가 빠름 , 뒤에서부터 찾기 
        ,INSTR('hellojava','a', -1, 2) --오른쪽에서 두번째 찾아라         
FROM DUAL; 

--부분문자열 반환: SUBSTR()
SELECT SUBSTR('hellojava', 2, 6) FROM DUAL; 
-- db는 1번 인덱스부터 시작한다. 
-- 2번 인덱스부터 6개의 문자를 찾아서 반환해라 
-- 6은 갯수이다. 
SELECT SUBSTR('hellojava', 2, 6) 
        ,SUBSTR('hellojava', 2) --ellojava    
FROM DUAL; 
-- 문자열 제거 : TRIM()
SELECT TRIM(LEADING'a' FROM 'aABCaDEFaHa')--왼쪽 문자 'a'제거 
        ,TRIM(TRAILING 'a' FROM 'aABCaDEFaHa')--오른쪽 문자 'a'제거 
        ,TRIM(BOTH 'a' FROM 'aABCaDEFaHa')--왼쪽오른쪽 문자 'a'제거 
        ,TRIM(BOTH'a' FROM 'aaaABCaDEFaHaaa')
FROM DUAL;

--문자열 늘리기 : LPAD, RPAD 
SELECT LPAD('abc', 5, '*')
       ,RPAD('abc', 5, '*')
       ,RPAD(LPAD('abc', 5, '*'),7,'*')
FROM DUAL;

--문자열 치환함수 : REPLACE() TRANSLATE()
SELECT REPLACE('JACK AND JUE', 'J','BL') --J를 BL로 변환
        ,TRANSLATE('JACK AND JUE', 'J', 'BL') --J는 B로 변환. 한글자만 바꿔줌. 
        ,TRANSLATE('BCCARD', 'BC','KB')
FROM DUAL;



--숫자형함수
--나머지값 반환: MOD()
SELECT 3+4, 3-4, 3*4, 3/4, MOD(3,4)--3을 4로 나눈 나머지값
FROM DUAL;

--반올림된 값 반환: ROUND(), 
SELECT ROUND(45.923)
        ,ROUND(45.923,2)-- 소수점이하 둘쨰짜리까지 표현한다. 
         ,ROUND(45.923,0)--일의 자릿수까지 표현
         ,ROUND(45.923,-1) -- 십의 자릿수까지 표현
FROM DUAL;
--버림된 값 반환: TRUNC()
SELECT TRUNC(45.923)
        ,TRUNC(45.923,2)-- 소수점이하 둘쨰짜리까지 표현한다. 
         ,TRUNC(45.923,0)--일의 자릿수까지 표현
         ,TRUNC(45.923,-1)-- 십의 자릿수까지 표현
FROM DUAL; 
-- 이름에 대소문자 구분없이 'e'를 포함한 사원들의 사번, 이름을 출력하시오


SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE UPPER(FIRST_NAME)LIKE '%E%'; --나 

SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE LOWER(FIRST_NAME)LIKE '%e%'; 

SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE INSTR(LOWER(FIRST_NAME),'e')<>0; 

-- 실급여(급여+급여*수당률)가 10000보다 많은 실급여를 받는 사원들의 사번, 급여, 수당률, 실급여를 출력하시오
-- 단, 실급여는 일의 자리에서 반올림하고 실급여를 많이 받는 사람들로부터 출력한다. 
SELECT EMPLOYEE_ID, salary, COMMISSION_PCT, ROUND(SALARY+(SALARY*NVL(COMMISSION_PCT,0)),-1) AS "실급여"  
FROM EMPLOYEES
WHERE ROUND(SALARY+(SALARY*NVL(COMMISSION_PCT,0)),-1) > 10000
ORDER BY "실급여" DESC;--나 


SELECT EMPLOYEE_ID, salary, COMMISSION_PCT, ROUND(SALARY+(SALARY*NVL(COMMISSION_PCT,0)),-1) 
FROM EMPLOYEES
WHERE ROUND(SALARY+(SALARY*NVL(COMMISSION_PCT,0)),-1) > 10000
ORDER BY 4 DESC;

SELECT EMPLOYEE_ID, salary, COMMISSION_PCT, ROUND(SALARY+(SALARY*NVL(COMMISSION_PCT,0)),-1) 실급여
FROM EMPLOYEES
WHERE ROUND(SALARY+(SALARY*NVL(COMMISSION_PCT,0)),-1) > 10000
ORDER BY 실급여 DESC;


--날짜형함수
--현재시간값 반환: SYSDATE 
-- 인자가 없기 때문에 괄호 열고닫고 사용 안함
SELECT SYSDATE
FROM DUAL;

--날짜 + 숫자 는 날짜를 반환 
-- SYSDATE + 1는 내일날짜를 반환 
-- SYSDATE +2 모레날짜를 반환

--날짜 + 숫자 는 날짜를 반환 
-- SYSDATE - 1는 어제날짜를 반환 
-- SYSDATE -2 그제날짜를 반환
SELECT SYSDATE, SYSDATE+1, SYSDATE-1
FROM DUAL;

--날짜 - 날짜 는 일수를 반환 
SELECT (SYSDATE+3)-SYSDATE
FROM DUAL;
--개월을 더한다 : ADD_MONTHS() 
SELECT SYSDATE, ADD_MONTHS(SYSDATE,5)
FROM DUAL;

SELECT SYSDATE, ADD_MONTHS(SYSDATE,-1)
FROM DUAL;

-- 개월수를 반환한다 : MONTHS_BETWEEN()
-- 개월수는 날짜-날짜가 아닌 위의 함수를 사용해야 한다. 
SELECT SYSDATE, MONTHS_BETWEEN('22/03/04',SYSDATE)
                ,MONTHS_BETWEEN('20220304',SYSDATE)
                       
FROM DUAL;
-- 사원의 근무일수, 근무 개월수, 근무년수를 출력하시오
--근무일수란 현재일자부터 입사일자까지의 일수 
-- 근무개월수는 소숫점이하자리는 버린다. 
-- 근무년수는 소숫점이하2자리에서 반올림한다 
--근무일수가 많은 사원부터 출력하시오 
SELECT EMPLOYEE_ID, HIRE_DATE, TRUNC((SYSDATE-HIRE_DATE)) 근무일수, TRUNC(MONTHS_BETWEEN(SYSDATE,HIRE_DATE)) 근무개월수,  TRUNC((MONTHS_BETWEEN(SYSDATE,HIRE_DATE)/12),1) 근무년수
FROM EMPLOYEES
ORDER BY 근무일수 DESC;

--일자기준으로 다음 요일에 해당 날짜를 반환한다 : NEXT_DAY()
--현재일자기준으로 다음 토요일에 해당하는 날짜를 출력하시오 
SELECT SYSDATE, NEXT_DAY(SYSDATE, '토') FROM DUAL;


-- 22/01/01기준으로 다음 월요일에 해당하는 날짜를 출력하시오 
SELECT NEXT_DAY('22/01/01', '월') FROM DUAL;
----------------------------------------
--형변환함수
-- 문자형 <- 숫자형  : TO_NUMBER()
-- 문자형 --> 날짜형 : TO_DATE()

--숫자형 --> 문자형 : TO_CHAR() 
-- 날짜형--> 문자형 : TO_chAR()

--자동형변환
SELECT '1' || 2 FROM DUAL; -- '12' 숫자형2가 문자형으로 자동형변환됨 
-- 문자하고 숫자 결합하려고 하면 자동 문자타입으로 변환이 된다. 
SELECT '1' + 2 FROM DUAL; --3 문자형 '1'이 숫자형으로 자동형변환됨 
-- 문자 + 숫자 는 1이 자동으로 숫자로 변환된다


SELECT '21/12/25', MONTHS_BETWEEN('21/12/25', SYSDATE) FROM DUAL; -- '21/12/25'문자형이 날짜형으로 자동형변환됨 
SELECT EMPLOYEE_ID, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE >= '08/01/01'; -- 날짜형 >= 문자형 -> 문자형이 날짜형으로 자동형변환됨. 
-- 자동형변환을 너무 많이 믿지 말라 
SELECT '입사일자-' || HIRE_DATE FROM EMPLOYEES; --날짜형이 문자형으로 자동형변환됨. 
-- ||면 문자타입이 우선이다.
-- 너무 의존하지 말고 개발자가 명시적으로 개발을 해보자. 


--강제형변환 
SELECT '1'||2, '1' || TO_CHAR(2) FROM DUAL;  

SELECT '1' + 2, TO_NUMBER('1') + 2 FROM DUAL; 


SELECT '21/12/25', MONTHS_BETWEEN('21/12/25', SYSDATE) FROM DUAL; -- '21/12/25'문자형이 날짜형으로 자동형변환됨 

SELECT EMPLOYEE_ID, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE >= TO_DATE('08/01/01'); -- 날짜형 >= 문자형 -> 문자형이 날짜형으로 자동형변환됨. 
-- 자동형변환을 너무 많이 믿지 말라 

SELECT '입사일자-' || TO_CHAR(HIRE_DATE) FROM EMPLOYEES; --날짜형이 문자형으로 자동형변환됨. 
-- ||면 문자타입이 우선이다.
-- 너무 의존하지 말고 개발자가 명시적으로 개발을 해보자. 


-- TO_CHAR(): 숫자->문자 
--숫자->문자 : TO_CHAR()-9 0, .L
SELECT 24000, TO_CHAR(24000, '9,999,999'), TO_CHAR(24000, '9,999')
            ,TO_CHAR(24000, '0000000.00'),TO_CHAR(24000,'L9,999,999')
            -- L하면 원짜표시
FROM DUAL; 



-- 사원의 사번, 급여를 출력하시오 
SELECT EMPLOYEE_ID, SALARY
FROM EMPLOYEES;

SELECT EMPLOYEE_ID, TO_CHAR(SALARY, '9,999,999')
FROM EMPLOYEES;
-- 날짜-> 문자 : TO_CHAR()형식 -Y(년) M(월) D(일) HH(시간) MI(분) SS(초) DAY(요일)
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYYMMDD HH:MI:SS'),TO_CHAR(SYSDATE, 'YYYYMMDD HH24:MI:SS')
                ,TO_CHAR(SYSDATE, 'YY-MM-DD HH24:MI:SS DAY')
FROM DUAL;


-- 문자 -> 숫자 : TO_NUMBER()
SELECT 12345,'1.234.5', TO_NUMBER('1,234.5', '9,999.0')
FROM DUAL;

--문자-> 날짜: TO_DATE()
SELECT TO_DATE('21/2/28')+1,TO_DATE('21/10/06 오전 09:28', 'YY-MM-DD am HH:MI') 
-- 한글 OS면 오전/오후, 영어OS면 AM,PM으로 된다. 
FROM DUAL;

SELECT TO_DATE('21/2/28')+1,TO_DATE('21/10/06 오전 09:28', 'YY-MM-DD am HH:MI'),
                            SYSDATE-TO_DATE('21/10/06 오전 09:28', 'YY-MM-DD am HH:MI')
FROM DUAL;
-- 날짜형 주의점 : 시분초정보 포함
SELECT HIRE_DATE
FROM EMPLOYEES;
WHERE HIRE_DATE > '08/07/01';  --2008년 7월 1일 보다 큰 날짜7월 2일부터 (X) 
                            -- 2008년 7월 1일 0시 0분 0초보다 큰 시간(O)
                            
SELECT HIRE_DATE
FROM EMPLOYEES
WHERE TO_DATE(HIRE_DATE, 'YY/MM/DD') > TO_DATE('08/07/01', 'YY/MM/DD'); --2008년 7월 1일 보다 큰 날짜 7월 2일부터(O)
--년월일로만 비교해야 한다. 


--NULL관련함수 
--NVL()
-- NVL2() : 첫번쨰 인자값이 널이 아니면 두번째인자 첫번쨰 인자가 NULL이면 

-- 관리자(MANAGER_ID)가 없는 사원을 출력하시오. 
SELECT *
FROM EMPLOYEES
WHERE MANAGER_ID IS NULL;

--관리자없는 사원은 관리자번호를 0으로 출력하고, 관리자 있는 사원은 관리자번호를 그대로 출력하시오
SELECT EMPLOYEE_ID, NVL(MANAGER_ID, 0)
FROM EMPLOYEES;
-- 출력할 떄 하는 것은 SELECT이고 행을 추출할 때의 조건은 WHERE을 사용한다. 



--관리자없는 사원은 관리자번호를 0으로 출력하고, 관리자 있는 사원은 관리자번호를 그대로 출력하시오
--SET NULL '관리자 없음'

SELECT EMPLOYEE_ID,NVL(TO_CHAR(manager_id),'관리자없음')
FROM EMPLOYEES;

----관리자없는 사원은 관리자번호를 0으로 출력하고, 관리자 있는 사원은 '관리자있음'으로 출력하시오
SELECT EMPLOYEE_ID,NVL2(manager_id,'관리자있음','관리자없음')
-- NULL이면 3번째 인자를 반환, NULL아니면 2번쨰 인자를 출력 
FROM EMPLOYEES;

--SELECT EMPLOYEE_ID,NVL2(manager_id,111,'관리자없음')-- 출력값이 달라 에러가 난다. 
--FROM EMPLOYEES;

--NULLIF는 인자1값과 인자2값이 같으면 NULL반환, 다르면 인자1값을 반환 
SELECT EMPLOYEE_ID, NULLIF(SALARY,24000)
FROM EMPLOYEES;

-------------------------------------
-- SQL은 변수선언, 조건문처리, 반복문처리 못함. 
-- 그래서 이것을 대체해주는 것이 함수이다. 
-- DECODE()
SELECT EMPLOYEE_ID, DECODE(MANAGER_ID,NULL,'관리자없음','관리자있음')
--NULL인가 NULL이라면 관리자없음, NULL이 아니면 관리자있음. 
FROM EMPLOYEES;

--부서번호가 80이면 '영업부', 60이면 'IT부', 그외의 값이면 '그외의 부서'를 출력하시오 
SELECT EMPLOYEE_ID,DECODE(DEPARTMENT_ID,80,'영업부',60,'IT부','그외의 부서')
FROM EMPLOYEES;

--조건절 : CASE 
--CASE WHEN THEN
--      WHEN THEN
--      ELSE
--END 

SELECT EMPLOYEE_ID,CASE WHEN MANAGER_ID IS NULL  THEN ,'관리자없음'
                                    ELSE '관리자있음'
                  END -- ELSE 생략해도 된다. WHEN 
FROM EMPLOYEES;
        --IS NULL 해야해서 WHEN절로 가져와야 함 
--부서번호가 80이면 '영업부', 60이면 'IT부', 그외의 값이면 '그외의 부서'를 출력하시오         
SELECT EMPLOYEE_ID, CASE DEPARTMENT_ID WHEN 80 THEN '영업부'
                                    WHEN 60 THEN 'IT부'
                                    ELSE '그외의 부서'
                    END
FROM EMPLOYEES;

-- 사원의 사번, 급여, 급여등급을 출력하시오 
-- 등급은 급여가 10000이상인 경우 'A', 5000이상이면 'B', 5000미만이면 'C'등급이다. 
SELECT employee_id, salary, CASE WHEN salary >= 10000 THEN 'A'
                                 WHEN salary >= 5000 THEN 'B'
                                 ELSE 'C'
                            END  AS 급여등급 
FROM employees;
