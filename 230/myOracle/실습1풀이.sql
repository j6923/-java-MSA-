--1. �޿��� 10000 �̰ų� 14000 �� ������� ���, �̸�(first_name), �޿��� �˻��Ͻÿ�.
SELECT EMPLOYEE_ID ���, FIRST_NAME �̸�, SALARY �޿� 
FROM EMPLOYEES
WHERE SALARY IN (1000,14000);
--2. first_name �� ��ҹ��ڱ�������('e', 'E')�� �����ϴ� ��� ����� �˻��Ͻÿ�
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLYEES
WHERE UPPER(FIRST_NAME ;
--3. first_name �� 'J���� �����ϰ� n ���ڸ� �����ϴ� ����� ���, �̸��� �˻��Ͻÿ�.
--��)
--��� �̸�
-----------------------
--110 John
--139 John
--145 John
--181 Jean
--189 Jennifer
--200 Jennifer
-----------------------
--4. �޿��� 10000 �̻��� ����� ���, �μ���ȣ, �̸�, �޿�, ������ ����Ͻÿ�.��, �μ���ȣ��
--30 ��,60 ��, 90 ���� �μ��� �����ϰ� ����� �˻��Ѵ�.
SELECT EMPLOYEE_ID ���, DEPARTMENT_ID �μ���ȣ, first_name||' '|| LAST_NAME "��� ����", SALARY ����, SALARY+(SALARY*NVL(COMMISSION_PCT,0)) ����
FROM EMPLOYEES
WHERE SALARY >= 10000 AND DEPARTMENT_ID NOT IN (30,60,90);
--5. �޿��� 4000 ���� ���� ������� �μ��� �޿���ո� ����Ͻÿ�. �� �޿������
--�Ҽ������� 2 �ڸ����� �ݿø��մϴ�.
SELECT 
--6. �μ���ġ�� ���� ���� ����� �����ϰ� �μ��� �޿������ ����Ͻÿ�.�� �޿������
--�Ҽ������� 2 �ڸ����� �ݿø��մϴ�.
--7. �μ���ġ�� ���� ���� ����� �����ϰ� �޿������ 10000 �̻��� �μ��� �޿������
--����Ͻÿ�.�� �޿������ �Ҽ������� 2 �ڸ����� �ݿø��մϴ�.
--8. ��å(job_title)�� 'President'�� ����� ���, �̸��� ����Ͻÿ�: (NaturalJOIN ���� ǥ��)
--8. ��å(job_title)�� 'President'�� ����� ���, �̸��� ����Ͻÿ�: (NaturalJOIN ���� ǥ��)
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES NATURAL JOIN JOBS
WHERE JOB_TITLE = 'President';
--9. ��å(job_title)�� 'President'�� �ƴ� ����� ���, �̸��� ����Ͻÿ�(JOIN USING ���� ǥ��)
SELECT E.EMPLOYEE_ID, E.FIRST_NAME
FROM EMPLOYEES E JOIN JOBS J USING (JOB_ID)
WHERE J.job_title <> 'President';

--10. �μ���ȣ, �μ���, �μ��� �޿��Ѿװ� ��ձ޿��� ����Ͻÿ�.
--��, �޿��Ѿ��� ���� ������ �����ϰ�,
--��ձ޿��� �Ҽ��� ���� 1 �ڸ����� ��Ÿ������ �ݿø��ؾ� �Ѵ�.
SELECT D.DEPARTMENT_ID, D.DEPARTMENT_NAME, SUM(E.SALARY)�޿��Ѿ�, ROUND(AVG(E.SALARY),1)
FROM EMPLOYEES E JOIN DEPARTMENTS D ON E.DEPARTMENT_ID=D.DEPARTMENT_ID
GROUP BY D.DEPARTMENT_ID, D.DEPARTMENT_NAME
--�׷��Լ��ϰ� ���� ����� �� �ִ� �׷��Լ��� ���� ����� �� �ִ�
-- �μ��� ����Ϸ��� GROUP BY�� DEPARTMENT_NAME �� �ؾ� �Ѵ�. 
ORDER BY �޿��Ѿ�;
--11. 'Seattle', 'Toronto'���ÿ� �ٹ��ϴ�
--������� ���ø�,���, �̸�, �μ� ID, �μ��� �� ����Ͻÿ�
SELECT L.CITY, E.FIRST_NAME, E.DEPARTMENT_ID, D.DEPARTMENT_NAME
FROM EMPLOYEES E JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
                JOIN LOCATIONS L ON D.LOCATION_ID = L.LOCATION_ID 
WHERE CITY IN ('Seattle', 'Toronto');

--12. 'Seattle'�� ������ ������ �μ��� ������� 5 ��̸��� ���ø�, �μ� ID, �μ���, �������
--����Ͻÿ�
SELECT CITY, D.DEPARTMENT_ID, DEPARTMENT_NAME, COUNT(*)  
FROM EMPLYEES E
JOIN DEPARTMENTS D  ON (E.DEPARTMENT_ID=D.DEPARTMENT_ID)
JOIN LOCATIONS L ON (D.LOCATION_ID = L.LOCATION_ID)
WHERE L.CITY <> 'Seattle'
GROUP BY CITY, D.EPARTMENT_ID, DEPARTMENT_NAME
-- �׷�BY���� ����� �÷��� ����Ʈ ������ ��밡�� 
HAVING COUNT(*) <5;

--13. �μ� ID �� 50 �̰ų� 80 �� �μ��� �ٹ��ϴ� ������� ���� ID �� ��å(job_title)�� ����Ͻÿ�.
--������� ����(job_id)�� �ߺ��� �����Ͻÿ� --5 ��
SELECT DISTINCT E.JOB_ID, JOB_TITLE
FROM EMPLOYEES E JOIN JOBS J ON (E.JOB_ID = J.JOB_ID)
WHERE E.DEPARTMENT_ID IN (50,80);

--14. ����� ���, �����ڹ�ȣ, �μ� ID, �μ���, �μ��� ID �� ����Ͻÿ�
SELECT EMPLOYEE_ID ���, E.MANAGER_ID �����ڹ�ȣ, DEPARTMENT_ID "�μ�", DEPARTMENT_NAME "�μ���", D.MANAGER_ID"�μ���"
FROM EMPLOYEES E JOIN DEPARTMENTS D USING (DEPARTMENT_ID);
-- 200�� �μ����̸鼭 �μ����� ����� 
--201�� �ڱⰡ �μ��� --202�� ����� 
--15. ���� 'Davies'�� ����� �μ� ID �� �޿��� ����Ͻÿ�.
SELECT DEPARTMENT_ID, SALARY
FROM EMPLOYEES
WHERE LAST_NAME = 'Davies';
--16. ���� 'Davies'�� ����� ���� �μ��� �ٹ��ϴ� ������� ���, ��, �̸��� ����Ͻÿ�--44 ��
SELECT e.employee_id, e.last_name, e.first_name, e.department_id
FROM employees E JOIN employees Davies
ON e.department_id = davies.department_id
WHERE davies.last_name = 'Davies'
AND e.last_name <> 'Davies';
