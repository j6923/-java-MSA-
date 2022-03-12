--�׷��Լ�: SUM(), COUNT(), AVG(), MAX(), MIN()... 
SELECT SUM(SALARY) �޿�����
,COUNT(*) �����
,COUNT(DEPARTMENT_ID) "�μ��� ���� �����"
,COUNT(COMMISSION_PCT) "������ �޴� �����"
,AVG(SALARY) "��ձ޿�"
,MAX(SALARY) "�ִ�޿�"
,MIN(SALARY) "�ּұ޿�"
FROM EMPLOYEES;

--A���̺� 
--a1 
--100 
-- 200
-- null
-- 400 
CREATE TABLE a(a1 number);
INSERT INTO a VALUES(100);
INSERT INTO a VALUES(200);
INSERT INTO a VALUES(NULL);
INSERT INTO a values(400);
SELECT * FROM a;
SELECT SUM(a1), COUNT(a1), AVG(a1) FROM a;

-------------------------------
--GROUP BY������ ����� �÷��� SELECT������ �׷��Լ��� �Բ� ����� �� �ִ�. 
-- �μ��� ������� ����Ͻÿ�
SELECT DEPARTMENT_ID,COUNT(*) --EMPLYEE_ID, DEPARTMENT_ID, COUNT(*)-- ����  
FROM EMPLOYEES                -- FFROM EMPLYEES
--WHERE                        -- GROUP BY DEPARTMENT_ID; 
GROUP BY DEPARTMENT_ID
ORDER BY 2 DESC; 
--HAVING 
--ORDER BY 
-- 2007�⿡ �Ի��� ������� ��ձ޿��� ����Ͻÿ� 
SELECT COUNT(*) "2007�� �Ի��ڼ�", AVG(SALARY) "2007�� ��� ��ձ޿�"
FROM EMPLOYEES
WHERE TO_CHAR(HIRE_DATE, 'YYYY') = '2007';  --�⵵ 4�ڸ��� ����Ÿ������ �����Դ�. 

--�⵵�� �Ի��� ������� ��ձ޿��� ����Ͻÿ�. �� �ֱٿ������� ����Ͻÿ�. 
SELECT TO_CHAR(HIRE_DATE,'YYYY')"�⵵��", COUNT(*)"�����",ROUND(AVG(SALARY),2) "��ձ޿�" 
FROM EMPLOYEES
GROUP BY TO_CHAR(HIRE_DATE,'YYYY')
ORDER BY 1 DESC;
-- ���� �Ի��� ������� ��ձ޿��� ����Ͻÿ�. �� 1������ ����Ͻÿ� 

SELECT TO_CHAR(HIRE_DATE,'MM'), COUNT(*), AVG(SALARY) 
FROM EMPLOYEES
GROUP BY TO_CHAR(HIRE_DATE, 'MM') -- ������ �� 
ORDER BY 1 DESC; 

SELECT TO_CHAR(HIRE_DATE,'MM'), COUNT(*), AVG(SALARY) 
FROM EMPLOYEES
GROUP BY TO_CHAR(HIRE_DATE, 'MM') -- ������ �� 
ORDER BY 1 ASC; 

SELECT TO_NUMBER(TO_CHAR(HIRE_DATE,'MM')), COUNT(*), AVG(SALARY) 
FROM EMPLOYEES
GROUP BY TO_CHAR(HIRE_DATE, 'MM') -- ������ �� 
ORDER BY 1 ASC; 


SELECT TO_NUMBER(TO_CHAR(hire_date, 'FMMM')), COUNT(*), AVG(salary)
FROM employees
GROUP BY TO_CHAR(hire_date, 'FMMM')
ORDER BY 1 ASC;

-- ���� 
SELECT LOCATION_ID, CITY 
FROM LOCATIONS;

-- �μ� 
SELECT DEPARTMENT_ID, LOCATION_ID
FROM DEPARTMENTS;

-- ������ ������ȣ(LOCATION_ID), �μ����� ����Ͻÿ� 
SELECT LOCATION_ID, COUNT(*)
FROM DEPARTMENTS 
GROUP BY LOCATION_ID;  

SELECT COUNT(*)  
FROM DEPARTMENTS; 
-- �Ѻμ����� 27��

-- ������ ������ȣ, ���ø�, �μ����� ����Ͻÿ� --> �ȵ�, �ذ��Ϸ��� JOIN �Ǵ� SUBQUERY�� �ذ� 
SELECT LOCATION_ID, CITY, COUNT(*)
FROM DEPARTMENTS 
GROUP BY LOCATION_ID;
-- CITY�� DEPARTMENTS�� ����. 
-- GROUP BY���� CITY�� ������� �ʾ� SELECT���� CITY��� �Ұ� 

--�Ϲݱ�(7��~12��) ���� �Ի��ڼ��� ����Ͻÿ� 
SELECT TO_CHAR(HIRE_DATE,'MM') "��",COUNT(*) "�Ի��ڼ�"
FROM EMPLOYEES
WHERE TO_CHAR(HIRE_DATE,'MM')BETWEEN '07' AND '12' -- ���ڰ����� �ϸ� 
GROUP BY TO_CHAR(HIRE_DATE, 'MM')
ORDER BY TO_CHAR(HIRE_DATE, 'MM');


SELECT TO_CHAR(HIRE_DATE,'MM') "�Ի��� ��",COUNT(*) "�Ի��� �����"
FROM EMPLOYEES
WHERE TO_NUMBER(TO_CHAR(HIRE_DATE,'MM'))>=7
GROUP BY TO_CHAR(HIRE_DATE, 'MM')
ORDER BY 1 ASC;

-- HAVING : �ۺο� ���� ������ 
--�Ϲݱ�(7��~12��) ���� �Ի��ڼ��� ����Ͻÿ�. ��, �Ի��ڼ��� 7�� �̻��� ���� ����Ѵ� 
SELECT TO_CHAR(HIRE_DATE,'MM'),COUNT(*)
FROM EMPLOYEES
WHERE TO_CHAR(HIRE_DATE,'MM')BETWEEN '07' AND '12' 
AND COUNT(*) >= 7-- WHERE������ �׷��Լ� ��� �Ұ� �׷��� ������ ��.
GROUP BY TO_CHAR(HIRE_DATE, 'MM')
ORDER BY 1;

SELECT TO_CHAR(HIRE_DATE,'MM'),COUNT(*)
FROM EMPLOYEES
WHERE TO_CHAR(HIRE_DATE,'MM')BETWEEN '07' AND '12' 
GROUP BY TO_CHAR(HIRE_DATE, 'MM')
HAVING COUNT(*)>=7
ORDER BY 1;
-- �׷쿡 ���� ������ HAVING�� ���´�.


--�޿��� 5000�̻��� ������� �μ��� ��ձ޿��� ����Ͻÿ� 
SELECT DEPARTMENT_ID, AVG(SALARY)
FROM EMPLOYEES
WHERE SALARY >= 5000
GROUP BY DEPARTMENT_ID;


--�޿��� 5000�̻��� ������� �μ��� ��ձ޿��� ����Ͻÿ�. �� ��ձ޿��� 10000�̻��� �μ��� ����Ͻÿ�
SELECT DEPARTMENT_ID, AVG(SALARY)
FROM EMPLOYEES
WHERE SALARY >= 5000
GROUP BY DEPARTMENT_ID
HAVING AVG(SALARY) >= 10000;

-- �μ��� ������� ����Ͻÿ� 
SELECT DEPARTMENT_ID, COUNT(*)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID;

-- �μ��� ������� ����Ͻÿ�. �ѻ������ ����Ͻÿ�. 
SELECT DEPARTMENT_ID, COUNT(*)
FROM EMPLOYEES
GROUP BY ROLLUP(DEPARTMENT_ID);

-- �μ���, ������ ������� ����Ͻÿ�. 
SELECT DEPARTMENT_ID,JOB_ID, COUNT(*)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID, JOB_ID -- ��׷� �μ���, �ұ׷� JOB_ID 
ORDER BY DEPARTMENT_ID, JOB_ID;


-- �μ���, ������ ������� ����Ͻÿ�. �ѻ����, �μ��� ������� ����Ѵ�. 
-- �μ���ġ���� ���� ����� �����Ѵ�. 
SELECT NVL(TO_CHAR(DEPARTMENT_ID),'�ѻ����'),NVL(JOB_ID, '�μ��� �����'), COUNT(*)
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL 
GROUP BY ROLLUP (DEPARTMENT_ID, JOB_ID) 
ORDER BY DEPARTMENT_ID, JOB_ID;

-- �μ���, ������ ������� ����Ͻÿ�. �ѻ����, �μ��� ������� ����Ѵ�. 
-- �μ���ġ���� ���� ����� �����Ѵ�. 
SELECT NVL(TO_CHAR(DEPARTMENT_ID),'�ѻ����'),NVL(JOB_ID, '�μ��� �����'), COUNT(*)
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL 
GROUP BY CUBE (DEPARTMENT_ID, JOB_ID) 
ORDER BY DEPARTMENT_ID, JOB_ID;


SELECT DEPARTMENT_ID, JOB_ID, COUNT(*)
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL 
GROUP BY CUBE (DEPARTMENT_ID, JOB_ID) 
ORDER BY DEPARTMENT_ID, JOB_ID;
