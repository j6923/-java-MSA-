SET SERVEROUTPUT ON 

CREATE OR REPLACE PROCEDURE pro1(score number)
IS 
  msg VARCHAR2(100);
BEGIN
  msg := '������ ' || score || '�Դϴ�';
  DBMS_OUTPUT.PUT_LINE(msg); 
  
  IF score > 70 THEN 
 
    DBMS_OUTPUT.PUT_LINE('�հ�');
  ELSE
    DBMS_OUTPUT.PUT_LINE('���հ�');      
  END IF;
  
END;
/


-- 
EXECUTE pro1(100); -- �հ� 
EXECUTE pro1(50);  -- ���հ� 

------




-- ��������, ��������, ���������� ������ ����� ����Ͽ� ����Ѵ�. 
-- ����� 90�����̻��̸� 'A', 80���̻��̸� 'B', 70�� �̻��̸� 'C', 60�� �̻��̸� 'D', 60�� �̸��̸� 'F'�� ����ϴ� ���ν��� 
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
    
    
    DBMS_OUTPUT.PUT_LINE('������' || TOTAL_SCORE || ',�����'|| AVG_SCORE);
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
-- �ݺ��� : LOOP, WHILE, FOR 
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
--exit when �� ���� ����������.
-- db�� �����Ų�ٴ°��� ���ν����̴�. 
    EXIT WHEN i>end_num; 
     total_num := total_num+i;
     i := i+1;    
  END LOOP;  
  DBMS_OUTPUT.PUT_LINE(total_num);
END;
/

-- ����Ŭ�� ++ -- ������ ���� 
-- �ݵ�� �ݺ��� �������;� ��. 
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
    -- �ݺ��� ������ ������ �������. 
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
    -- 1�� �ڵ� �����ؼ� num���� 
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

    -- �� �� �ڷ� 
BEGIN
--    SELECT first_name||' '||last_name INTO FULL_NAME
    SELECT * INTO EMP 
    -- �÷� �����ͼ� �����ض� 
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID= EMP_ID;
    DBMS_OUTPUT.PUT_LINE('�̸���' || FULL_NAME);
    DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || ', ' || EMP.FIRST_NAME || ', ' || EMP.SALARY || ', ' ||EMP.DEPARTMENT_ID);
END;
/
EXECUTE pro6(100);
/
-- 
--�ڷ��� EMP_ID NUMBER 
--      EMP_ID EMPLOYEE ���̺��� EMPLOYEE_ID�÷� �ڷ��� 
-- ���� Ÿ������ ����Ÿ������ �ٲ���ٰ� �ص� WHERE������ EMPLOYEE�� ���� ������ �ڷ����� ��ġ�� �� �ִ�, 
--employees.emplyee_id%TYPE
--EMP_ID employees.emplyee_id%TYPE
-- ��� ���̺��� ������ �ڷ����� �ǰ� �ض� 
--EMP_ID EMPLOYEES���̺��� EMPLOYEE_ID�÷��ڷ��� : EMP_ID employees.emplyee_id%ROWTYPE
-- EMP EMPLOYEES ���̺��� �����ڷ��� : EMP EMPLOYEES%ROWTYPE 
-- EMPLOYEES �� �� �ڷ����� ���� �ڷ����̴�. 

--
CREATE OR REPLACE PROCEDURE pro7(dept_id departments.department_id%type)
IS 
    DEPT_NAME DEPARTMENTS.DEPARTMENT_NAME%TYPE;
    EMP EMPLOYEES%ROWTYPE;
    CURSOR c1
    --Ŀ���� �̸��� c1�� ���� 
    IS 
    -- CURSOR�� �� ������ 
    SELECT * 
    FROM EMPLOYEES 
    WHERE DEPARTMENT_ID = DEPT_ID; 
    -- Ŀ�� �����. 
BEGIN 
    SELECT DEPARTMENT_NAME INTO DEPT_NAME
    FROM DEPARTMENTS
    WHERE DEPARTMENT_ID = DEPT_ID;
    DBMS_OUTPUT.PUT_LINE('�μ���:' || DEPT_NAME);
--    SELECT * INTO EMP 
--    FROM EMPLOYEES
--    WHERE DEPARTMENT_ID = DEPT_ID;
    FOR EMP IN C1 LOOP
    -- Ŀ���̸� ���� Ŀ���̸��� ������� ������ �����س��� EMP�� ��ȯ�ؼ� ���� 
    DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || ', ' || EMP.FIRST_NAME || ', ' || EMP.SALARY || ', ' ||EMP.DEPARTMENT_ID);
    END LOOP; 
    -- Ŀ�� ���� ����� �̵����Ѽ� ��ġ�ض� 
--    DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || ', ' || EMP.FIRST_NAME || ', ' || EMP.SALARY || ', ' ||EMP.DEPARTMENT_ID);
-- �������� ���� ��ȯ�ؼ� �������� ������ EMP��� ������ ������ �� �ְڴ� 
end;
/
 -- �μ���ȣ�� �ش��ϴ� �������� ������ ����Ѵ�. 
 
 EXECUTE pro7(90);
 /
-------
-- �Լ� 
CREATE OR REPLACE FUNCTION CAL_SAL(EMP_ID EMPLOYEES.EMPLOYEE_ID%TYPE)
-- EMPLOYEES�� EMPLOYEE_ID�� Ÿ������ �Ű������� �ش�. 
-- FUNCTION�� �̸� ���� 
-- ��ȯ�� �ڷ����� �����ش�. 
RETURN NUMBER
IS
    real_sal NUMBER;
BEGIN
    SELECT SALARY + (SALARY*NVL(COMMISSION_PCT,0)) INTO real_sal
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID = EMP_ID; 
    -- ���� ������ �����ϴ� 
    RETURN REAL_SAL;
END; 
/
--- 
-- �ҹ��ڷ� ���� �빮�ڷ� ���� �� �˾ƺ��� 
SELECT CAL_SAL(100), CAL_SAL(178) FROM DUAL; 


-- �ǽ� 
CREATE OR REPLACE FUNCTION START_ROW(CURR_PAGE NUMBER, CNT_PER_PAGE NUMBER)
RETURN NUMBER 
IS
    START_ROW NUMBER; 
    
   
BEGIN
    START_ROW:=(CURR_PAGE -1)*CNT_PER_PAGE+1;
-- TODO CURR_PAGE������������ CNT_PER_PAGE �������� ������ ��� ���� �̿��Ͽ� START_ROW�� ����Ѵ�.
    
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
--�������� 10�྿ �����ָ鼭 1�������� �������� ��ȯ�Ѵ� : 1 --(1-1)*10+1 
SELECT START_ROW(1,10), END_ROW(1,10) FROM DUAL; 
/

--�������� 10�྿ �����ָ鼭 1�������� �������� ��ȯ�Ѵ� : 11--(2-1)*10+1 /

SELECT START_ROW(2,10), END_ROW(2,10) FROM DUAL;
--  START_ROW�� �� �� ���޵ǰ� END_ROW���޵Ǽ� ��.
/
--�������� 10�྿ �����ָ鼭 3�������� �������� ��ȯ�Ѵ� : 21-- (3-1)*10+1
SELECT START_ROW(3,10),END_ROW(1,10) FROM DUAL;
/
--�������� 5�྿ �����ָ鼭 2�������� �������� ��ȯ�Ѵ� : 6 --(2-1)*5+1 
SELECT START_ROW(2,5), END_ROW(2,5) FROM DUAL;
/
--
