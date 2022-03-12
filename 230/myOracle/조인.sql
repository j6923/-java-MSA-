-- ����� ���, �̸�, �μ���ȣ, �μ����� ����Ͻÿ� 
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_id
from employees; --107�� 

SELECT DEPARTMENT_ID, DEPARTMENT_NAME
FROM DEPARTMENTS; --27�� 

SELECT* 
FROM EMPLOYEES, DEPARTMENTS; --2889�� 

-- ����Ŭ ���� JOIN ǥ���
SELECT *
FROM EMPLOYEES, DEPARTMENTS
WHERE EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID; --106 �� 
-- ����Ŭ ���� ǥ����� ����Ŭ�����ۿ� ������� ���Ѵ�. 

--ANSI JOIN
--INNER JOIN ON 
--INNER�� ������ �����ϴ�. 
SELECT EMPLOYEE_ID, FIRST_NAME, EMPLOYEES.DEPARTMENT_ID, DEPARTMENT_NAME 
FROM EMPLOYEES JOIN DEPARTMENTS ON EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID;
--EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID; ���� 
-- ���� �̸��� �÷��� ��� ���̺� �÷����� 

--��Ī�� �ο������� ��Ī�� ����ؾ� �Ѵ�. 
SELECT EMPLOYEE_ID, FIRST_NAME, E.DEPARTMENT_ID, DEPARTMENT_NAME 
FROM EMPLOYEES E JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;
-- ������ �÷� � ������ �� ���ָ� ������. 

--�� -- ������ �÷��� �� USING�� ����ϸ� �ȴ�. 
SELECT E.EMPLOYEE_ID, E.FIRST_NAME, DEPARTMENT_ID, D.DEPARTMENT_NAME 
FROM EMPLOYEES E JOIN DEPARTMENTS D USING (DEPARTMENT_ID);

--NATURAL JOIN 
-- ����� ���, �̸�, ������ȣ, �������� ����Ͻÿ� 
SELECT EMPLOYEE_ID, FIRST_name, employees.job_id, job_title 
FROM EMPLOYEES JOIN JOBS ON EMPLOYEES.JOB_ID = JOBS.JOB_ID; 

--NATURAL JOIN���� ������. 
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, JOB_TITLE
FROM EMPLOYEES NATURAL JOIN JOBS;
-- ���� �̸��� ���� ���� �˾Ƽ� ã����. 
-- ��Ī�� ������� �ʴ´�. 
-- ���� �̸��� �÷����� ���� ���� �����ؿ´�. 
-- �����ϴ�. 

--�߸��� NATURAL JOIN�� ���캸��. 
-- ����� ��� �̸�, �μ���ȣ, �μ����� ����Ͻÿ� 
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_id, DEPARTMENT_NAME
from employees NATURAL JOIN DEPARTMENTS;--(x) 
-- �μ� �� ������ ����� �� ���̴�. 
-- �ǵ��� �ٿ� �ٸ��� �ȴ�. 
-- ID�� ���� �޴��� ���̵� ���� 
-- �μ����� �����ڷ� �ϰ� �ִ� ����� ����ϴ� �� \\

--USING : �÷����� ������ ��� 
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_id, DEPARTMENT_NAME
from employees JOIN DEPARTMENTS USING (DEPARTMENT_ID);--OK 
--- ���� ������ INNER JOIN 

---OUTER JOIN 
-- ����� ���, �̸�, �μ���ȣ, �μ����� ����Ͻÿ� 
SELECT EMPLOYEE_ID, DEPARTMENT_ID, DEPARTMENT_NAME
FROM EMPLOYEES JOIN DEPARTMENTS USING (DEPARTMENT_ID);

SELECT EMPLOYEE_ID, FIRST_NAME, D.DEPARTMENT_ID, DEPARTMENT_NAME
FROM EMPLOYEES E, DEPARTMENTS D 
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID; -- ����Ŭ ���� ǥ��� 


-- ����� ���, �̸�, �μ���ȣ, �μ����� ����Ͻÿ� 
--�μ����� ����� ��� ����Ѵ�. 
SELECT EMPLOYEE_ID, DEPARTMENT_ID, DEPARTMENT_NAME
FROM EMPLOYEES LEFT JOIN DEPARTMENTS USING (DEPARTMENT_ID);
-- LEFT�� �ᵵ LEFT OUTER JOIN�� ������ ȿ���̴�.  

SELECT EMPLOYEE_ID, FIRST_NAME, D.DEPARTMENT_ID, DEPARTMENT_NAME
FROM EMPLOYEES E, DEPARTMENTS D 
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID(+); -- ����Ŭ ���� ǥ��� 
-- ����Ŭ�� LEFT OUTER JOIN ǥ��� 
-- ������ �� 
-- �� �����ʿ� ǥ���� ���� LEFT OUTER JOIN


-- ����� ���, �̸�, �μ���ȣ, �μ����� ����Ͻÿ� 
-- ������� �μ��� ��� ����Ѵ�. 
-- ������ ���� ����̰� �������� ������ �ǰ� �Ѵ�. 
-- RIGHT OUTER JOIN 
SELECT EMPLOYEE_ID,  DEPARTMENT_ID, DEPARTMENT_NAME
FROM EMPLOYEES RIGHT JOIN DEPARTMENTS USING (DEPARTMENT_ID);
--OUTER�� �����ص� �ȴ�. 
SELECT EMPLOYEE_ID, FIRST_NAME, D.DEPARTMENT_ID, DEPARTMENT_NAME
FROM EMPLOYEES E, DEPARTMENTS D 
WHERE E.DEPARTMENT_ID(+) = D.DEPARTMENT_ID; -- ����Ŭ ���� ǥ��� 
-- ����Ŭ�� LEFT OUTER JOIN ǥ��� 
-- ������ �� 
-- �� �����ʿ� ǥ���� ���� LEFT OUTER JOIN

-- ����� ���, �̸�, �μ���ȣ, �μ����� ����Ͻÿ� 
-- �μ����� ����� ����ϰ�, ������� �μ��� ��� ����Ѵ�. 
-- ���� ���̺��� ���� ��Ƽ� ���� �� ��µǰ� �ϴ� ���̴�. 
SELECT EMPLOYEE_ID, DEPARTMENT_ID, DEPARTMENT_NAME
FROM EMPLOYEES FULL JOIN DEPARTMENTS USING (DEPARTMENT_ID);

-- SELF JOIN
-- ����� ���, �̸�, �����ڹ�ȣ, �������̸��� ����Ͻÿ� 
SELECT E.EMPLOYEE_ID ���, E.FIRST_NAME �����, E.MANAGER_ID �����ڹ�ȣ, M.FIRST_NAME �����ڸ� 
FROM EMPLOYEES E
JOIN EMPLOYEES M ON (E.MANAGER_ID = M.EMPLOYEE_ID); 

-- ����� ���, �̸�, �μ���ȣ, �����ڹ�ȣ, �������̸�, �������ҼӺμ��� ����Ͻÿ� 
SELECT E.EMPLOYEE_ID ���, E.FIRST_NAME �����, E.DEPARTMENT_ID "��� �ҼӺμ�", E.MANAGER_ID �����ڹ�ȣ, M.FIRST_NAME �����ڸ�,
        M.DEPARTMENT_ID"������ �ҼӺμ�"
FROM EMPLOYEES E
JOIN EMPLOYEES M ON (E.MANAGER_ID = M.EMPLOYEE_ID); 


-- ����� ���, �̸�, �μ���ȣ, �����ڹ�ȣ, �������̸�, �������ҼӺμ��� ����Ͻÿ� 
-- ����μ��� �����ںμ��� �ٸ� ����鸸 ����Ͻÿ� 
SELECT E.EMPLOYEE_ID ���, E.FIRST_NAME �����, E.DEPARTMENT_ID "��� �ҼӺμ�", E.MANAGER_ID �����ڹ�ȣ, M.FIRST_NAME �����ڸ�,
        M.DEPARTMENT_ID"������ �ҼӺμ�"
FROM EMPLOYEES E
JOIN EMPLOYEES M ON (E.MANAGER_ID = M.EMPLOYEE_ID)
WHERE E.DEPARTMENT_ID<>M.DEPARTMENT_ID; -- ����μ��� �����ںμ��� �ٸ� �����

-- ����� ���, �̸�, �޿�, �μ���ȣ, �����ڹ�ȣ, �������̸�, �����ڱ޿�, �������ҼӺμ��� ����Ͻÿ� 
-- ����޿��� �����ڱ޿��� ���� ����鸸 ����Ͻÿ� 
SELECT E.EMPLOYEE_ID ���, E.FIRST_NAME �����, E.SALARY �޿�, E.DEPARTMENT_ID "��� �ҼӺμ�", E.MANAGER_ID �����ڹ�ȣ, M.FIRST_NAME �����ڸ�,
       M.SALARY �����ڱ޿�, M.DEPARTMENT_ID"������ �ҼӺμ�"
FROM EMPLOYEES E
JOIN EMPLOYEES M ON (E.MANAGER_ID = M.EMPLOYEE_ID)
WHERE E.SALARY > M.SALARY;

