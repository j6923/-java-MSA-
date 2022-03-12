SET SERVEROUTPUT ON 

CREATE OR REPLACE PROCEDURE pro1(score number)
IS 
  msg VARCHAR2(100);
BEGIN
  msg := '점수는 ' || score || '입니다';
  DBMS_OUTPUT.PUT_LINE(msg); 
  
  IF score > 70 THEN 
 
    DBMS_OUTPUT.PUT_LINE('합격');
  ELSE
    DBMS_OUTPUT.PUT_LINE('불합격');      
  END IF;
  
END;
/


-- 
EXECUTE pro1(100); -- 합격 
EXECUTE pro1(50);  -- 불합격 

------




-- 국어점수, 영어점수, 수학점수의 총점과 평균을 계산하여 출력한다. 
-- 평균이 90점수이상이면 'A', 80점이상이면 'B', 70점 이상이면 'C', 60점 이상이면 'D', 60점 미만이면 'F'를 출력하는 프로시져 
-- HINT  : IF THEN 
      --   ELSIF THEN 
      --  ELSE 
      --  END IF 
CREATE OR REPLACE PROCEDURE pro2(ko NUMBER, en NUMBER, math NUMBER)
IS  
    TOTAL_SCORE NUMBER;
    AVG_SCORE NUMBER;
BEGIN
    TOTAL_SCORE:= ko+en+math;
    AVG_SCORE := TOTAL_SCORE/3;
    
    
    DBMS_OUTPUT.PUT_LINE('총점은' || TOTAL_SCORE || ',평균은'|| AVG_SCORE);
    IF AVG_SCORE >= 90 THEN DBMS_OUTPUT.PUT_LINE('A');
    ELSIF AVG_SCORE >= 80 THEN DBMS_OUTPUT.PUT_LINE('B');
    ELSIF AVG_SCORE >= 70 THEN DBMS_OUTPUT.PUT_LINE('C');
    ELSIF AVG_SCORE >= 60 THEN DBMS_OUTPUT.PUT_LINE('D');
    
    ELSE 
        DBMS_OUTPUT.PUT_LINE('F');
    END IF;
END;
/
---f  
EXECUTE pro2(10,20,30);
--c
EXECUTE pro2(60, 70, 100);
----- 
-- 반복문 : LOOP, WHILE, FOR 
CREATE OR REPLACE PROCEDURE pro3(start_num number, end_num number)
IS
  total_num number := 0;
  i number;
BEGIN
  i := start_num;
  LOOP
--     IF i>end_num THEN
--       EXIT;
--     END IF;
--exit when 은 언제 빠져나가라.
-- db에 저장시킨다는것이 프로시져이다. 
    EXIT WHEN i>end_num; 
     total_num := total_num+i;
     i := i+1;    
  END LOOP;  
  DBMS_OUTPUT.PUT_LINE(total_num);
END;
/

-- 오라클에 ++ -- 연산자 없음 
-- 반드시 반복문 빠져나와야 함. 
------
EXECUTE pro3(1,10);
/
EXECUTE pro3(11,20);
/

---- 
CREATE OR REPLACE PROCEDURE pro4(start_num number, end_num number)
IS
  total_num number := 0;
  i number;
BEGIN
    
    i := start_num;
    WHILE i<= end_num LOOP 
    -- 반복을 수행할 조건을 적어줘라. 
--    EXIT WHEN i>end_num; 
     total_num := total_num+i;
     i := i+1;    
  END LOOP;  
  DBMS_OUTPUT.PUT_LINE(total_num);
END;
/
-- 
EXECUTE pro4(1,10);
/
---
CREATE OR REPLACE PROCEDURE pro5(start_num number, end_num number)
IS
    
BEGIN
    FOR i IN start_num..end_num LOOP
    -- 1씩 자동 증가해서 num까지 
        DBMS_OUTPUT.PUT_LINE(i);
    END LOOP; 
END;
/
-- 
EXECUTE pro5(1,5);
/
--- 
CREATE OR REPLACE PROCEDURE pro6(EMP_ID employees.employee_id%TYPE)
IS
    FULL_NAME VARCHAR2(100);
    EMP EMPLOYEES%ROWTYPE;

    -- 한 행 자료 
BEGIN
--    SELECT first_name||' '||last_name INTO FULL_NAME
    SELECT * INTO EMP 
    -- 컬럼 가져와서 대입해라 
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID= EMP_ID;
    DBMS_OUTPUT.PUT_LINE('이름은' || FULL_NAME);
    DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || ', ' || EMP.FIRST_NAME || ', ' || EMP.SALARY || ', ' ||EMP.DEPARTMENT_ID);
END;
/
EXECUTE pro6(100);
/
-- 
--자료형 EMP_ID NUMBER 
--      EMP_ID EMPLOYEE 테이블의 EMPLOYEE_ID컬럼 자료형 
-- 숫자 타입으로 문자타입으로 바뀌었다고 해도 WHERE절에서 EMPLOYEE와 비교할 변수가 자료형이 일치할 수 있다, 
--employees.emplyee_id%TYPE
--EMP_ID employees.emplyee_id%TYPE
-- 사번 테이블의 동일한 자료형이 되게 해라 
--EMP_ID EMPLOYEES테이블의 EMPLOYEE_ID컬럼자료형 : EMP_ID employees.emplyee_id%ROWTYPE
-- EMP EMPLOYEES 테이블의 한행자료형 : EMP EMPLOYEES%ROWTYPE 
-- EMPLOYEES 한 행 자료형과 같은 자료형이다. 

--
CREATE OR REPLACE PROCEDURE pro7(dept_id departments.department_id%type)
IS 
    DEPT_NAME DEPARTMENTS.DEPARTMENT_NAME%TYPE;
    EMP EMPLOYEES%ROWTYPE;
    CURSOR c1
    --커서의 이름을 c1로 지정 
    IS 
    -- CURSOR가 한 일적기 
    SELECT * 
    FROM EMPLOYEES 
    WHERE DEPARTMENT_ID = DEPT_ID; 
    -- 커서 만든다. 
BEGIN 
    SELECT DEPARTMENT_NAME INTO DEPT_NAME
    FROM DEPARTMENTS
    WHERE DEPARTMENT_ID = DEPT_ID;
    DBMS_OUTPUT.PUT_LINE('부서명:' || DEPT_NAME);
--    SELECT * INTO EMP 
--    FROM EMPLOYEES
--    WHERE DEPARTMENT_ID = DEPT_ID;
    FOR EMP IN C1 LOOP
    -- 커서이름 적고 커서이름의 결과값을 변수로 선언해놓은 EMP에 반환해서 보기 
    DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || ', ' || EMP.FIRST_NAME || ', ' || EMP.SALARY || ', ' ||EMP.DEPARTMENT_ID);
    END LOOP; 
    -- 커서 내용 결과를 이동시켜서 패치해라 
--    DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || ', ' || EMP.FIRST_NAME || ', ' || EMP.SALARY || ', ' ||EMP.DEPARTMENT_ID);
-- 여러개의 행을 반환해서 여러행의 정보를 EMP라는 변수에 저장할 수 있겠니 
end;
/
 -- 부서번호에 해당하는 ㅅ원들의 정보를 출력한다. 
 
 EXECUTE pro7(90);
 /
-------
-- 함수 
CREATE OR REPLACE FUNCTION CAL_SAL(EMP_ID EMPLOYEES.EMPLOYEE_ID%TYPE)
-- EMPLOYEES의 EMPLOYEE_ID의 타입으로 매개변수를 준다. 
-- FUNCTION의 이름 적기 
-- 반환할 자료형을 적어준다. 
RETURN NUMBER
IS
    real_sal NUMBER;
BEGIN
    SELECT SALARY + (SALARY*NVL(COMMISSION_PCT,0)) INTO real_sal
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID = EMP_ID; 
    -- 위의 조건을 만족하는 
    RETURN REAL_SAL;
END; 
/
--- 
-- 소문자로 쓰던 대문자로 쓰던 다 알아보기 
SELECT CAL_SAL(100), CAL_SAL(178) FROM DUAL; 


-- 실습 
CREATE OR REPLACE FUNCTION START_ROW(CURR_PAGE NUMBER, CNT_PER_PAGE NUMBER)
RETURN NUMBER 
IS
    START_ROW NUMBER; 
    
   
BEGIN
    START_ROW:=(CURR_PAGE -1)*CNT_PER_PAGE+1;
-- TODO CURR_PAGE현재페이지와 CNT_PER_PAGE 페이지별 보여줄 목록 수를 이용하여 START_ROW를 계산한다.
    
    RETURN START_ROW;
END;
/


CREATE OR REPLACE FUNCTION END_ROW(CURR_PAGE NUMBER, CNT_PER_PAGE NUMBER)
RETURN NUMBER
IS
BEGIN
    RETURN CURR_PAGE * CNT_PER_PAGE;
END; 
/
-- 
--페이지별 10행씩 보여주면서 1페이지의 시작행을 반환한다 : 1 --(1-1)*10+1 
SELECT START_ROW(1,10), END_ROW(1,10) FROM DUAL; 
/

--페이지별 10행씩 보여주면서 1페이지의 시작행을 반환한다 : 11--(2-1)*10+1 /

SELECT START_ROW(2,10), END_ROW(2,10) FROM DUAL;
--  START_ROW가 한 것 전달되고 END_ROW전달되서 됨.
/
--페이지별 10행씩 보여주면서 3페이지의 시작행을 반환한다 : 21-- (3-1)*10+1
SELECT START_ROW(3,10),END_ROW(1,10) FROM DUAL;
/
--페이지별 5행씩 보여주면서 2페이지의 시작행을 반환한다 : 6 --(2-1)*5+1 
SELECT START_ROW(2,5), END_ROW(2,5) FROM DUAL;
/
--
