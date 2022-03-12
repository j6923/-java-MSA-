--�������Լ�
--����:LENGTH()
--�������̺��� DUAL�� �����ϱ� , �� ���� ��ȯ�Ѵ�. 
SELECT LENGTH('����Ŭ'), LENGTHB('����Ŭ')
FROM DUAL; 

SELECT EMPLOYEE_ID, FIRST_NAME, LENGTH(FIRST_NAME)
FROM EMPLOYEES;
--�̸��� 8�ڸ��̻��� ������� ���, �̸��� ����Ͻÿ�. 
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE LENGTH(FIRST_NAME)>=8; 

-- �빮�ڷ� ��ȯ : UPPER() 
-- �ҹ��ڷ� ��ȯ: LOWER()
-- ù���ڸ� �빮�ڷ� ��ȯ: INITCAP()
SELECT UPPER('heLLo'), LOWER('heLLo'), INITCAP('heLLO')
FROM DUAL;
-- Ư�������� ��ġ��ȯ: INSTR()
SELECT INSTR('hellojava','a')
FROM DUAL; 

SELECT INSTR('hellojava','a')
        ,INSTR('hellojava', 'a', 8)  --8����ġ���� ã�ƶ� 
FROM DUAL; 


SELECT INSTR('hellojava','a')
        ,INSTR('hellojava', 'a', 8)  --8����ġ���� ã�ƶ� 
        ,INSTR('hellojava', 'b')   --0 �ش� ��ġ ��ã����0�� ��ȯ 
        ,INSTR('hellojava','a', -1)  --9�� ��ȯ�ϴµ� ������Ʈ�� �갡 ���� , �ڿ������� ã�� 
        ,INSTR('hellojava','a', -1, 2) --�����ʿ��� �ι�° ã�ƶ�         
FROM DUAL; 

--�κй��ڿ� ��ȯ: SUBSTR()
SELECT SUBSTR('hellojava', 2, 6) FROM DUAL; 
-- db�� 1�� �ε������� �����Ѵ�. 
-- 2�� �ε������� 6���� ���ڸ� ã�Ƽ� ��ȯ�ض� 
-- 6�� �����̴�. 
SELECT SUBSTR('hellojava', 2, 6) 
        ,SUBSTR('hellojava', 2) --ellojava    
FROM DUAL; 
-- ���ڿ� ���� : TRIM()
SELECT TRIM(LEADING'a' FROM 'aABCaDEFaHa')--���� ���� 'a'���� 
        ,TRIM(TRAILING 'a' FROM 'aABCaDEFaHa')--������ ���� 'a'���� 
        ,TRIM(BOTH 'a' FROM 'aABCaDEFaHa')--���ʿ����� ���� 'a'���� 
        ,TRIM(BOTH'a' FROM 'aaaABCaDEFaHaaa')
FROM DUAL;

--���ڿ� �ø��� : LPAD, RPAD 
SELECT LPAD('abc', 5, '*')
       ,RPAD('abc', 5, '*')
       ,RPAD(LPAD('abc', 5, '*'),7,'*')
FROM DUAL;

--���ڿ� ġȯ�Լ� : REPLACE() TRANSLATE()
SELECT REPLACE('JACK AND JUE', 'J','BL') --J�� BL�� ��ȯ
        ,TRANSLATE('JACK AND JUE', 'J', 'BL') --J�� B�� ��ȯ. �ѱ��ڸ� �ٲ���. 
        ,TRANSLATE('BCCARD', 'BC','KB')
FROM DUAL;



--�������Լ�
--�������� ��ȯ: MOD()
SELECT 3+4, 3-4, 3*4, 3/4, MOD(3,4)--3�� 4�� ���� ��������
FROM DUAL;

--�ݿø��� �� ��ȯ: ROUND(), 
SELECT ROUND(45.923)
        ,ROUND(45.923,2)-- �Ҽ������� �Ѥ�¥������ ǥ���Ѵ�. 
         ,ROUND(45.923,0)--���� �ڸ������� ǥ��
         ,ROUND(45.923,-1) -- ���� �ڸ������� ǥ��
FROM DUAL;
--������ �� ��ȯ: TRUNC()
SELECT TRUNC(45.923)
        ,TRUNC(45.923,2)-- �Ҽ������� �Ѥ�¥������ ǥ���Ѵ�. 
         ,TRUNC(45.923,0)--���� �ڸ������� ǥ��
         ,TRUNC(45.923,-1)-- ���� �ڸ������� ǥ��
FROM DUAL; 
-- �̸��� ��ҹ��� ���о��� 'e'�� ������ ������� ���, �̸��� ����Ͻÿ�


SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE UPPER(FIRST_NAME)LIKE '%E%'; --�� 

SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE LOWER(FIRST_NAME)LIKE '%e%'; 

SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE INSTR(LOWER(FIRST_NAME),'e')<>0; 

-- �Ǳ޿�(�޿�+�޿�*�����)�� 10000���� ���� �Ǳ޿��� �޴� ������� ���, �޿�, �����, �Ǳ޿��� ����Ͻÿ�
-- ��, �Ǳ޿��� ���� �ڸ����� �ݿø��ϰ� �Ǳ޿��� ���� �޴� �����κ��� ����Ѵ�. 
SELECT EMPLOYEE_ID, salary, COMMISSION_PCT, ROUND(SALARY+(SALARY*NVL(COMMISSION_PCT,0)),-1) AS "�Ǳ޿�"  
FROM EMPLOYEES
WHERE ROUND(SALARY+(SALARY*NVL(COMMISSION_PCT,0)),-1) > 10000
ORDER BY "�Ǳ޿�" DESC;--�� 


SELECT EMPLOYEE_ID, salary, COMMISSION_PCT, ROUND(SALARY+(SALARY*NVL(COMMISSION_PCT,0)),-1) 
FROM EMPLOYEES
WHERE ROUND(SALARY+(SALARY*NVL(COMMISSION_PCT,0)),-1) > 10000
ORDER BY 4 DESC;

SELECT EMPLOYEE_ID, salary, COMMISSION_PCT, ROUND(SALARY+(SALARY*NVL(COMMISSION_PCT,0)),-1) �Ǳ޿�
FROM EMPLOYEES
WHERE ROUND(SALARY+(SALARY*NVL(COMMISSION_PCT,0)),-1) > 10000
ORDER BY �Ǳ޿� DESC;


--��¥���Լ�
--����ð��� ��ȯ: SYSDATE 
-- ���ڰ� ���� ������ ��ȣ ����ݰ� ��� ����
SELECT SYSDATE
FROM DUAL;

--��¥ + ���� �� ��¥�� ��ȯ 
-- SYSDATE + 1�� ���ϳ�¥�� ��ȯ 
-- SYSDATE +2 �𷹳�¥�� ��ȯ

--��¥ + ���� �� ��¥�� ��ȯ 
-- SYSDATE - 1�� ������¥�� ��ȯ 
-- SYSDATE -2 ������¥�� ��ȯ
SELECT SYSDATE, SYSDATE+1, SYSDATE-1
FROM DUAL;

--��¥ - ��¥ �� �ϼ��� ��ȯ 
SELECT (SYSDATE+3)-SYSDATE
FROM DUAL;
--������ ���Ѵ� : ADD_MONTHS() 
SELECT SYSDATE, ADD_MONTHS(SYSDATE,5)
FROM DUAL;

SELECT SYSDATE, ADD_MONTHS(SYSDATE,-1)
FROM DUAL;

-- �������� ��ȯ�Ѵ� : MONTHS_BETWEEN()
-- �������� ��¥-��¥�� �ƴ� ���� �Լ��� ����ؾ� �Ѵ�. 
SELECT SYSDATE, MONTHS_BETWEEN('22/03/04',SYSDATE)
                ,MONTHS_BETWEEN('20220304',SYSDATE)
                       
FROM DUAL;
-- ����� �ٹ��ϼ�, �ٹ� ������, �ٹ������ ����Ͻÿ�
--�ٹ��ϼ��� �������ں��� �Ի����ڱ����� �ϼ� 
-- �ٹ��������� �Ҽ��������ڸ��� ������. 
-- �ٹ������ �Ҽ�������2�ڸ����� �ݿø��Ѵ� 
--�ٹ��ϼ��� ���� ������� ����Ͻÿ� 
SELECT EMPLOYEE_ID, HIRE_DATE, TRUNC((SYSDATE-HIRE_DATE)) �ٹ��ϼ�, TRUNC(MONTHS_BETWEEN(SYSDATE,HIRE_DATE)) �ٹ�������,  TRUNC((MONTHS_BETWEEN(SYSDATE,HIRE_DATE)/12),1) �ٹ����
FROM EMPLOYEES
ORDER BY �ٹ��ϼ� DESC;

--���ڱ������� ���� ���Ͽ� �ش� ��¥�� ��ȯ�Ѵ� : NEXT_DAY()
--�������ڱ������� ���� ����Ͽ� �ش��ϴ� ��¥�� ����Ͻÿ� 
SELECT SYSDATE, NEXT_DAY(SYSDATE, '��') FROM DUAL;


-- 22/01/01�������� ���� �����Ͽ� �ش��ϴ� ��¥�� ����Ͻÿ� 
SELECT NEXT_DAY('22/01/01', '��') FROM DUAL;
----------------------------------------
--����ȯ�Լ�
-- ������ <- ������  : TO_NUMBER()
-- ������ --> ��¥�� : TO_DATE()

--������ --> ������ : TO_CHAR() 
-- ��¥��--> ������ : TO_chAR()

--�ڵ�����ȯ
SELECT '1' || 2 FROM DUAL; -- '12' ������2�� ���������� �ڵ�����ȯ�� 
-- �����ϰ� ���� �����Ϸ��� �ϸ� �ڵ� ����Ÿ������ ��ȯ�� �ȴ�. 
SELECT '1' + 2 FROM DUAL; --3 ������ '1'�� ���������� �ڵ�����ȯ�� 
-- ���� + ���� �� 1�� �ڵ����� ���ڷ� ��ȯ�ȴ�


SELECT '21/12/25', MONTHS_BETWEEN('21/12/25', SYSDATE) FROM DUAL; -- '21/12/25'�������� ��¥������ �ڵ�����ȯ�� 
SELECT EMPLOYEE_ID, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE >= '08/01/01'; -- ��¥�� >= ������ -> �������� ��¥������ �ڵ�����ȯ��. 
-- �ڵ�����ȯ�� �ʹ� ���� ���� ���� 
SELECT '�Ի�����-' || HIRE_DATE FROM EMPLOYEES; --��¥���� ���������� �ڵ�����ȯ��. 
-- ||�� ����Ÿ���� �켱�̴�.
-- �ʹ� �������� ���� �����ڰ� ��������� ������ �غ���. 


--��������ȯ 
SELECT '1'||2, '1' || TO_CHAR(2) FROM DUAL;  

SELECT '1' + 2, TO_NUMBER('1') + 2 FROM DUAL; 


SELECT '21/12/25', MONTHS_BETWEEN('21/12/25', SYSDATE) FROM DUAL; -- '21/12/25'�������� ��¥������ �ڵ�����ȯ�� 

SELECT EMPLOYEE_ID, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE >= TO_DATE('08/01/01'); -- ��¥�� >= ������ -> �������� ��¥������ �ڵ�����ȯ��. 
-- �ڵ�����ȯ�� �ʹ� ���� ���� ���� 

SELECT '�Ի�����-' || TO_CHAR(HIRE_DATE) FROM EMPLOYEES; --��¥���� ���������� �ڵ�����ȯ��. 
-- ||�� ����Ÿ���� �켱�̴�.
-- �ʹ� �������� ���� �����ڰ� ��������� ������ �غ���. 


-- TO_CHAR(): ����->���� 
--����->���� : TO_CHAR()-9 0, .L
SELECT 24000, TO_CHAR(24000, '9,999,999'), TO_CHAR(24000, '9,999')
            ,TO_CHAR(24000, '0000000.00'),TO_CHAR(24000,'L9,999,999')
            -- L�ϸ� ��¥ǥ��
FROM DUAL; 



-- ����� ���, �޿��� ����Ͻÿ� 
SELECT EMPLOYEE_ID, SALARY
FROM EMPLOYEES;

SELECT EMPLOYEE_ID, TO_CHAR(SALARY, '9,999,999')
FROM EMPLOYEES;
-- ��¥-> ���� : TO_CHAR()���� -Y(��) M(��) D(��) HH(�ð�) MI(��) SS(��) DAY(����)
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYYMMDD HH:MI:SS'),TO_CHAR(SYSDATE, 'YYYYMMDD HH24:MI:SS')
                ,TO_CHAR(SYSDATE, 'YY-MM-DD HH24:MI:SS DAY')
FROM DUAL;


-- ���� -> ���� : TO_NUMBER()
SELECT 12345,'1.234.5', TO_NUMBER('1,234.5', '9,999.0')
FROM DUAL;

--����-> ��¥: TO_DATE()
SELECT TO_DATE('21/2/28')+1,TO_DATE('21/10/06 ���� 09:28', 'YY-MM-DD am HH:MI') 
-- �ѱ� OS�� ����/����, ����OS�� AM,PM���� �ȴ�. 
FROM DUAL;

SELECT TO_DATE('21/2/28')+1,TO_DATE('21/10/06 ���� 09:28', 'YY-MM-DD am HH:MI'),
                            SYSDATE-TO_DATE('21/10/06 ���� 09:28', 'YY-MM-DD am HH:MI')
FROM DUAL;
-- ��¥�� ������ : �ú������� ����
SELECT HIRE_DATE
FROM EMPLOYEES;
WHERE HIRE_DATE > '08/07/01';  --2008�� 7�� 1�� ���� ū ��¥7�� 2�Ϻ��� (X) 
                            -- 2008�� 7�� 1�� 0�� 0�� 0�ʺ��� ū �ð�(O)
                            
SELECT HIRE_DATE
FROM EMPLOYEES
WHERE TO_DATE(HIRE_DATE, 'YY/MM/DD') > TO_DATE('08/07/01', 'YY/MM/DD'); --2008�� 7�� 1�� ���� ū ��¥ 7�� 2�Ϻ���(O)
--����Ϸθ� ���ؾ� �Ѵ�. 


--NULL�����Լ� 
--NVL()
-- NVL2() : ù���� ���ڰ��� ���� �ƴϸ� �ι�°���� ù���� ���ڰ� NULL�̸� 

-- ������(MANAGER_ID)�� ���� ����� ����Ͻÿ�. 
SELECT *
FROM EMPLOYEES
WHERE MANAGER_ID IS NULL;

--�����ھ��� ����� �����ڹ�ȣ�� 0���� ����ϰ�, ������ �ִ� ����� �����ڹ�ȣ�� �״�� ����Ͻÿ�
SELECT EMPLOYEE_ID, NVL(MANAGER_ID, 0)
FROM EMPLOYEES;
-- ����� �� �ϴ� ���� SELECT�̰� ���� ������ ���� ������ WHERE�� ����Ѵ�. 



--�����ھ��� ����� �����ڹ�ȣ�� 0���� ����ϰ�, ������ �ִ� ����� �����ڹ�ȣ�� �״�� ����Ͻÿ�
--SET NULL '������ ����'

SELECT EMPLOYEE_ID,NVL(TO_CHAR(manager_id),'�����ھ���')
FROM EMPLOYEES;

----�����ھ��� ����� �����ڹ�ȣ�� 0���� ����ϰ�, ������ �ִ� ����� '����������'���� ����Ͻÿ�
SELECT EMPLOYEE_ID,NVL2(manager_id,'����������','�����ھ���')
-- NULL�̸� 3��° ���ڸ� ��ȯ, NULL�ƴϸ� 2���� ���ڸ� ��� 
FROM EMPLOYEES;

--SELECT EMPLOYEE_ID,NVL2(manager_id,111,'�����ھ���')-- ��°��� �޶� ������ ����. 
--FROM EMPLOYEES;

--NULLIF�� ����1���� ����2���� ������ NULL��ȯ, �ٸ��� ����1���� ��ȯ 
SELECT EMPLOYEE_ID, NULLIF(SALARY,24000)
FROM EMPLOYEES;

-------------------------------------
-- SQL�� ��������, ���ǹ�ó��, �ݺ���ó�� ����. 
-- �׷��� �̰��� ��ü���ִ� ���� �Լ��̴�. 
-- DECODE()
SELECT EMPLOYEE_ID, DECODE(MANAGER_ID,NULL,'�����ھ���','����������')
--NULL�ΰ� NULL�̶�� �����ھ���, NULL�� �ƴϸ� ����������. 
FROM EMPLOYEES;

--�μ���ȣ�� 80�̸� '������', 60�̸� 'IT��', �׿��� ���̸� '�׿��� �μ�'�� ����Ͻÿ� 
SELECT EMPLOYEE_ID,DECODE(DEPARTMENT_ID,80,'������',60,'IT��','�׿��� �μ�')
FROM EMPLOYEES;

--������ : CASE 
--CASE WHEN THEN
--      WHEN THEN
--      ELSE
--END 

SELECT EMPLOYEE_ID,CASE WHEN MANAGER_ID IS NULL  THEN ,'�����ھ���'
                                    ELSE '����������'
                  END -- ELSE �����ص� �ȴ�. WHEN 
FROM EMPLOYEES;
        --IS NULL �ؾ��ؼ� WHEN���� �����;� �� 
--�μ���ȣ�� 80�̸� '������', 60�̸� 'IT��', �׿��� ���̸� '�׿��� �μ�'�� ����Ͻÿ�         
SELECT EMPLOYEE_ID, CASE DEPARTMENT_ID WHEN 80 THEN '������'
                                    WHEN 60 THEN 'IT��'
                                    ELSE '�׿��� �μ�'
                    END
FROM EMPLOYEES;

-- ����� ���, �޿�, �޿������ ����Ͻÿ� 
-- ����� �޿��� 10000�̻��� ��� 'A', 5000�̻��̸� 'B', 5000�̸��̸� 'C'����̴�. 
SELECT employee_id, salary, CASE WHEN salary >= 10000 THEN 'A'
                                 WHEN salary >= 5000 THEN 'B'
                                 ELSE 'C'
                            END  AS �޿���� 
FROM employees;
