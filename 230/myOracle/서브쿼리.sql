-- ��������
-- ���������� ��ġ�� ���� 
--��Į�� ���� : SELECT(SELECT~~)
--�ζ��κ�: FROM(SELECT~~) 
--�������� WHERE �÷� �񱳿���(SELECT~~)

--���������� ��ȯ����� ����
-- ������ �������� : �񱳿����� ��밡��(=, <>, >, >=, <, <=) 
--���������� ���� �� ���Ǵ� �����ڷδ� �Ϲݺ񱳿����� ���� �ȴ�. 
-- ������ �������� : IN, ANY, ALL �����ڸ� ���� 
-- ANY���� ũ��, �۴�, ALL���� ũ��, �۴� �� Ư�� �����ڸ� ����ؾ� �Ѵ�. 

-- �ִ�޿��� �޴� ����� �޿��� ����Ͻÿ� 
SELECT MAX(SALARY) FROM EMPLOYEES;

-- �ִ�޿��� �޴� ����� ���, �̸�, �޿��� ����Ͻÿ� 
--1) �ִ�޿��� �˻�(���)�Ѵ�.->SELECT MAX(SALARY) FROM EMPLOYEES;
--2) 1)�� ���� �޿��� �޴� ����� ���, �̸�, �޿��� ����Ѵ�. 
-- FROM EMPLOYEES
--WHERE SALARY= 24000; 
--24000�� ����� ������ 1)�����̰� �ȴ�. 
-- �׷��� WHERE SALARY=(SELECT MAX(SALARY) FROM EMPLOYEES);
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY 
FROM EMPLOYEES
WHERE SALARY = (SELECT MAX(SALARY) FROM EMPLOYEES);

-- ��ձ޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿��� ����Ͻÿ� 
--1) ��ձ޿��� �˻��Ѵ�. 
--2) 1)���� ���� �޿��� �޴� ����� ���, �̸�, �޿��� ����Ͻÿ� 
SELECT employee_id, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEES);

-- �˻����� �ʰ� �ٷ� �������� �ϱ� 
-- �ִ�޿��� �޴� ����� ���� �μ����� �ٹ��ϴ� ������� ���, �̸�, �޿�, �μ���ȣ�� ����Ͻÿ� 
--1) �ִ�޿��� �˻��Ѵ�. -- SELECT MAX(SALARY) FROM EMPLOYEES; 
--2) 1)�� ���� �޿��� �޴� ����� �μ���ȣ�� �˻��Ѵ�. 
--3) 2)�� ���� �μ���ȣ�� ���� ����� ����Ѵ�. 
--SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID
--FROM EMPLOYEES
--WHERE SALARY=(SELECT MAX(SALARY) FROM EMPLOYEES);  2�� 
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID 
                        FROM EMPLOYEES WHERE salary= (SELECT MAX(SALARY)FROM EMPLOYEES)); 

-- ������ �������� 
-- �μ��� ��ձ޿��� ����Ͻÿ� 
SELECT DEPARTMENT_ID, AVG(SALARY)
FROM EMPLOYEES 
GROUP BY DEPARTMENT_ID;

--�μ��� ��ձ޿����� ���� �޿��� �޴� ����� �μ����, �̸�, �޿��� ����Ͻÿ� 
-- 1) �μ��� ��ձ޿��� ����Ѵ�. 
-- 2) 1)���� ���� �޿��� �޴� ����� ��� 
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
-- ������ ����� �� ���� ���� 
--�μ��� �ִ�޿����� ���� �޿��� �޴� ����� �μ����, �̸�, �޿��� ����Ͻÿ� 
-- 1) �μ��� ��ձ޿��� ����Ѵ�. 
-- 2) 1)�� ���� ���� �޿��� �޴� ����� ��� 
SELECT DEPARTMENT_ID, MAX(SALARY)
FROM EMPLOYEES 
GROUP BY DEPARTMENT_ID;

SELECT DEPARTMENT_ID, EMPLOYEE_ID, FIRST_NAME, SALARY 
FROM EMPLOYEES
WHERE SALARY =(SELECT AVG(SALARY)
FROM EMPLOYEES 
GROUP BY DEPARTMENT_ID);  -- �Ϲ� �񱳿����� ��� �Ұ� 

SELECT DEPARTMENT_ID, EMPLOYEE_ID, FIRST_NAME, SALARY 
FROM EMPLOYEES
WHERE SALARY IN (SELECT MAX(SALARY)
FROM EMPLOYEES 
GROUP BY DEPARTMENT_ID);-- (X: ����� Ʋ��) 


SELECT DEPARTMENT_ID, EMPLOYEE_ID, FIRST_NAME, SALARY 
FROM EMPLOYEES
WHERE (DEPARTMENT_ID,SALARY)  IN (SELECT DEPARTMENT_ID,MAX(SALARY)
FROM EMPLOYEES 
GROUP BY DEPARTMENT_ID);-- 11�� NULL �μ����� 


SELECT DEPARTMENT_ID, EMPLOYEE_ID, FIRST_NAME, SALARY 
FROM EMPLOYEES
WHERE (NVL(DEPARTMENT_ID,0),SALARY)  IN (SELECT NVL(DEPARTMENT_ID,0),MAX(SALARY)
FROM EMPLOYEES 
GROUP BY DEPARTMENT_ID);-- 12�� NULL�μ� ���� 

-- =ANY�� IN�� ���� 
SELECT DEPARTMENT_ID, EMPLOYEE_ID, FIRST_NAME, SALARY 
FROM EMPLOYEES
WHERE (NVL(DEPARTMENT_ID,0),SALARY) = ANY (SELECT NVL(DEPARTMENT_ID,0),MAX(SALARY)
FROM EMPLOYEES 
GROUP BY DEPARTMENT_ID);

--���� 
-- ������ IT_PROG�� ������� �ִ�޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�, ������ȣ�� ����Ͻÿ� 
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY
FROM EMPLOYEES
WHERE SALARY
<(SELECT MAX(SALARY)
FROM EMPLOYEES 
WHERE JOB_ID = 'IT_PROG');  --80�� 

--���� ������ ANY�� Ǯ�� 
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY
FROM EMPLOYEES
WHERE SALARY< ANY(SELECT SALARY 
FROM EMPLOYEES
    WHERE JOB_ID= 'IT_PROG');-- 80�� 
-- �ִ밪���� ���� �̾ ANY 

-- ��å(JOB_TILLE)�� 'PRESIDENT'�� ����� ���, �̸��� ����Ͻÿ� 
SELECT EMPLOYEE_ID, FIRST_NAME 
FROM EMPLOYEES E NATURAL JOIN JOBS  
WHERE JOB_TITLE = 'President';

-- ���� ������ ���������� �ذ��غ���. 
--1) ��å�� 'President'�� job_id�˻��Ѵ�. 
--2) 1)�� ���� job_id���� ����� �����Ѵ�. 
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE JOB_ID=(SELECT JOB_ID
FROM JOBS
WHERE JOB_TITLE = 'President');
-- ��Į�� ���� 
-- SELECT������ ���������� ����ϴ� ���� �ǹ��Ѵ�. 
-- �μ���ȣ, �μ���, �μ��� �޿� �Ѿ� 
-- ��¿� �ʿ�
SELECT DEPARTMENT_ID, DEPARTMENT_NAME, SUM(SALARY)
FROM EMPLOYEES E JOIN DEPARTMENTS D USING (DEPARTMENT_ID)
GROUP BY DEPARTMENT_ID, DEPARTMENT_NAME;--�μ���� �μ� �� ����ؾ� �ؼ� ������.


-- ���� 'Davies'�� ����� ���� �μ��� �ٹ��ϴ� ������� ���, ��, �̸��� ����Ͻÿ� 
-- ����� ������ ���� �������� �� �ϰ� ���������� �ذ��� �� �ִ�. 
-- 1) ���� 'Davies'�� ����� �μ���ȣ�� �˻��Ѵ�. 
-- 2) 1)�� ���� �μ��� �ٹ��ϴ� ������� ���, ��, �̸��� ��� 
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID
FROM employees 
WHERE department_id=
(SELECT department_id FROM employees WHERE last_name = 'Davies')
AND last_name <> 'Davies';


-- ��Į�� ������ ��ȯ
SELECT DEPARTMENT_ID, (SELECT DEPARTMENT_NAME FROM DEPARTMENTS WHERE DEPARTMENT_ID = EMPLOYEES.DEPARTMENT_ID ), SUM(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID;
-- �μ����� DEPARTMENTS�� �ִ� ���̴�.

------
--'Sales'�μ��� ��ձ޿����� ���� �޿��� �޴� ������� �μ���ȣ, ���, �޿��� ����Ͻÿ� 
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


--'Sales'�μ��� ��ձ޿����� ���� �޿��� �޴� 'Sales' ������� �μ���ȣ, ���, �޿��� ����Ͻÿ� 
-- sales�μ��� ����鸸 ���� 
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
                    
--��ȣ�������������� �ذ� 
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
-- ROWNUM : ���ȣ �ǻ��÷� 
SELECT ROWNUM, EMPLOYEE_ID, SALARY 
FROM EMPLOYEES;-- ���ȣ�� �� �� �ִ�. 
-- ������ �غ��� 
SELECT ROWNUM, EMPLOYEE_ID, SALARY 
FROM EMPLOYEES
ORDER BY SALARY;-- SELECT ������ ���� ROWNUM�� ���׹��׵ȴ�. 

-- ���� �޿��� �޴� ����� ���ȣ�� 1������ ���۵ǵ��� ����Ͻÿ� 
SELECT ROWNUM, EMPLOYEE_ID, SALARY 
FROM (SELECT EMPLOYEE_ID, SALARY 
    FROM EMPLOYEES
    ORDER BY SALARY);  --FROM ������ ����ϴ� ���������� �ζ��κ��� �Ѵ�.
-- �����޿��� �޴� ����� ���ȣ�� 1������ ���۵ǵ��� ����Ͻÿ� 
-- ���ȣ�� 1~5�ุ ����Ѵ�. 
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
-- ����� ������ �ʾ� �ζ��� �� �ѹ� �� ���� 
SELECT *
FROM(SELECT ROWNUM  R, EMPLOYEE_ID, SALARY -- ���⼭ ROWNUM�� ���������, R�� �� 
    FROM (SELECT EMPLOYEE_ID, SALARY 
            FROM EMPLOYEES
             ORDER BY SALARY)
WHERE R BETWEEN 6 AND 10; 


