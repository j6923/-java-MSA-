select * from employees;
-- ctrl + enter 
-- *�� ��� �÷��̰� from ������ ���̺� �̴�. 
-- ���̺��� ���� ��� �÷� ������ .
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, HIRE_DATE
FROM EMPLOYEES;

--COMMENT 

--�÷� ��Ī �ֱ� : HEADING�� ��Ī���� ��Ÿ��, HEADING�� �⺻ �빮�ڷ� ��µ�.  
SELECT EMPLOYEE_ID ���, FIRST_NAME "��� �̸�", salary, hire_date "hiredate"
FROM EMPLOYEES; 

-- ���ڿ� ��ȣ ''
-- ���ڿ����տ����� ||
SELECT employee_id, first_name, last_name, first_name||last_name, first_name ||'-'|| last_name "��� ����"
FROM EMPLOYEES;

--������ 
-- ��������� : +, -, *, /
-- �񱳿����� : >, <, >=, <=, = , <>
-- ���Կ����� : = 


-- BETWEEN ������: <= AD ]

-- Ư�� �� �����ϱ� : WHERE 

-- �޿��� 5000�̻��� ������� ���, �̸�, �޿��� ����Ͻÿ�. 
SELECT EMPLOYEE_ID, FIRST_NAME, salary 
FROM EMPLOYEES
WHERE salary >= 5000;

---�޿��� 12�� ���� ���� 100000�̻��� ������� ���, �̸�, �޿��� ����Ͻÿ�. 
SELECT employee_id, first_name, salary, salary*12
from employees 
where salary * 12 >= 100000;

--�޿��� 5000�̻� 10000������ ������� ���, �̸�, �޿��� ����Ͻÿ�. 
SELECT employee_id, first_name, salary
FROM employees
where salary>=5000 and salary<=10000;


SELECT employee_id as ���, first_name as �̸�, salary as �޿�
FROM employees
where salary between 5000 and 10000;

-- ������� ���, �μ���ȣ�� ����Ͻÿ� 
SELECT employee_id, department_id
FROM employees;

-- �μ���ȣ�� 90�̰ų�, 30�̰ų� 20�� ������� ���, �μ���ȣ�� ����Ͻÿ�. 
SELECT employee_id, department_id
FROM employees
WHERE department_id=90 OR department_id =30 OR department_id = 20; 


SELECT employee_id as ���, first_name as �̸�, salary as �޿�
FROM employees
where department_id in (90,30,20);
-- department_id�� 90,30,20�� �ִ� �� 

--�μ���ȣ�� 90�̰ų�, 30�̰ų� 20�̰� 
--�޿��� 5000�̻� 10000������ ������� ���, �̸�, �޿��� ����Ͻÿ�.

SELECT employee_id as ���, first_name as �̸�, salary as �޿�
FROM employees
WHERE (department_id=90 OR department_id =30 OR department_id = 20)
AND salary>=5000 and salary<=10000; 


SELECT employee_id as ���, first_name as �̸�, salary as �޿�
FROM employees
WHERE department_id IN (90,30,20) AND salary BETWEEN 5000 AND 10000;
-- 

--�μ���ȣ�� 90�ƴϰ� , 30�ƴϰ� 20�ƴ� �μ��� ���, �̸�, �μ���ȣ�� ����Ͻÿ�. 
SELECT employee_id, first_name, department_id
FROM employees
WHERE department_id <> 90 AND department_id <>30 AND department_id<>20;

SELECT employee_id, first_name, department_id
FROM employees
WHERE department_id NOT IN(90, 30,20);



-- LIKE % _ 
-- ���� ���̺� 
SELECT *FROM jobs;
-- Manager�� ������ �������� ����Ͻÿ�. 
SELECT JOB_TITLE
FROM jobs
WHERE JOB_TITLE LIKE '%Manager';

--����� �̸��� 'e'�� ������ ������� ����� �̸��� ����Ͻÿ�. 
SELECT employee_id, first_name
FROM EMPLOYEES
WHERE first_name Like '%e%';

-- ����� �Ի����� 
SELECT hire_date From employees;
--�Ի�⵵�� 07�⵵�� ����� ����� �Ի����ڸ� ����Ͻÿ� 
SELECT employee_id, hire_date
FROM employees
WHERE hire_date Like '07%';

SELECT employee_id, hire_date
FROM employees
WHERE hire_date BETWEEN '07/01/01' AND '07/12/31';

-- �Ի���� 11���� ����� ���, �Ի����ڸ� ����Ͻÿ�. 
-- �� �⵵�� ���Ի���� �˰� ���� �� 
SELECT employee_id, hire_date
FROM employees
WHERE hire_date LIKE '__/11/__';

----------ORDAET BY: ���� 
-- ���� �޿��� ���� ������� ���, �̸�, �޿��� ����Ͻÿ�. 
SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary;

--�������� 
-- ���� �޿��� ���� ������� ���, �̸�, �޿��� ����Ͻÿ�.
SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary DESC;

SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary DESC;
-- ���� �޿��� ���� ������� ���, �̸�, �޿��� ����Ͻÿ�. �� �޿����� ��� �̸��� ���������� ����Ͻÿ�. 
SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary DESC, first_name ASC;

SELECT employee_id ���, first_name �̸�, salary �޿�
FROM employees
ORDER BY �޿� DESC, first_name ASC;  -- ��Ī���

-- �÷� ��ġ�� �ؼ� ����غ���. 
SELECT employee_id ���, first_name �̸�, salary �޿�
FROM employees
ORDER BY 3 DESC, first_name ASC;  -- ��ġ���

-- ���� �޿��� �޴� ������� ���, �̸��� ����Ͻÿ�. 
SELECT employee_id, first_name
FROM employees
ORDER BY salary DESC;
-- ------
--distinct 
-- ����� �μ���ȣ�� ����Ͻÿ�. 
SELECT department_id
FROM employees;

-- ����� ���� �μ���ȣ�� �ߺ����� ����Ͻÿ�. 
SELECT DISTINCT department_id
FROM employees;

-- ����� ���� �μ���ȣ, ������ȣ�� ����Ͻÿ� 
SELECT department_id, job_id
FROM employees
ORDER BY department_id, job_id;

-- ����� ���� �μ���ȣ, ������ȣ�� �ߺ����� ����Ͻÿ�
SELECT DISTINCT department_id, job_id
FROM employees
ORDER BY department_id, job_id;

-----------------------------
--NULL : �ƹ��͵� �ƴϴ� 
SELECT employee_id, first_name, last_name, department_id, salary, commission_pct
FROM employees;

--�μ���ġ ���� �ʴ� ����� ���, �̸�, �μ���ȣ�� ����Ͻÿ�. 
SELECT employee_id, first_name, department_id
FROM employees
WHERE department_id = null;  --�ƹ� ���� �� ���´�. 


SELECT employee_id, first_name, department_id
FROM employees
WHERE department_id is null;

--�μ���ġ ���� ����� ���, �̸�, �μ���ȣ�� ����Ͻÿ�. 
SELECT employee_id, first_name, department_id
FROM employees
WHERE department_id IS NOT null;

-- ��� ����� ���, �̸�, �޿�, �����, �ݿ�*������� ����Ͻÿ� 
SELECT employee_id, first_name, commission_pct, (salary*commission_pct)+salary �Ǳ޿�
FROM employees;

-- NULL���� �Լ� : NVL(ǥ����, ��ȯ��)ǥ������ ����� NULL�̸� ��ȯ���� ��ȯ�ϰ�, ǥ������ NULL�� �ƴϸ� ǥ���İ��� ��ȯ�Ѵ�. 
SELECT employee_id, first_name, commission_pct, (salary*NVL(commission_pct,0))+salary �Ǳ޿�
FROM employees;
-- ���� �μ���ȣ�� ���� ������� ����Ͻÿ�. 
SELECT employee_id, department_id
FROM employees
ORDER BY department_id; --���������ϸ� null�� ���� �������� ��µ�, DBMS���� �ٸ�. 

--------------
-- ROWNUM : ���ȣ���� ���� �ǻ��÷� 
SELECT rownum, employee_id FROM employees;
SELECT rownum, employee_id, salary FROM employees ORDER BY salary DESC;

--�޿��� ���� �޴� ��������� 5�� ����Ͻÿ� 
SELECT rownum,employee_id, salary
FROM employees
WHERE rownum<=5
ORDER BY salary DESC; --(X)

