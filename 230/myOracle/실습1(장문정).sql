--1. �޿��� 10000 �̰ų� 14000 �� ������� ���, �̸�(first_name), �޿��� �˻��Ͻÿ�.
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY BETWEEN 10000 AND 14000;
--2. first_name �� ��ҹ��ڱ�������('e', 'E')�� �����ϴ� ��� ����� �˻��Ͻÿ�
SELECT FIRST_NAME
FROM EMPLOYEES 
WHERE UPPER(FIRST_NAME) LIKE '%E%';
--3. first_name �� 'J���� �����ϰ� n ���ڸ� �����ϴ� ����� ���, �̸��� �˻��Ͻÿ�.
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE LOWER(FIRST_NAME) LIKE 'j%n%'
ORDER BY FIRST_NAME DESC;
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
SELECT EMPLOYEE_ID "���", DEPARTMENT_ID "�μ���ȣ", FIRST_NAME "�̸�", SALARY "�޿�", COMMISSION_PCT "����"
FROM EMPLOYEES 
WHERE DEPARTMENT_ID NOT IN(30,60,90)
AND SALARY >= 10000
ORDER BY SALARY, EMPLOYEE_ID;
--5. �޿��� 4000 ���� ���� ������� �μ��� �޿���ո� ����Ͻÿ�. �� �޿������
--�Ҽ������� 2 �ڸ����� �ݿø��մϴ�.
SELECT DEPARTMENT_ID AS �μ���ȣ, ROUND(AVG(SALARY),1) AS �޿����
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING AVG(SALARY)>4000;

--6. �μ���ġ�� ���� ���� ����� �����ϰ� �μ��� �޿������ ����Ͻÿ�.�� �޿������
--�Ҽ������� 2 �ڸ����� �ݿø��մϴ�.
SELECT DEPARTMENT_ID AS �μ���ȣ, ROUND(AVG(SALARY),1) AS �޿����
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY DEPARTMENT_ID
ORDER BY DEPARTMENT_ID;

--7. �μ���ġ�� ���� ���� ����� �����ϰ� �޿������ 10000 �̻��� �μ��� �޿������
--����Ͻÿ�.�� �޿������ �Ҽ������� 2 �ڸ����� �ݿø��մϴ�.
SELECT DEPARTMENT_ID AS �μ���ȣ, ROUND(AVG(SALARY),1) AS �޿����
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL 
GROUP BY DEPARTMENT_ID
HAVING AVG(SALARY) >= 10000
ORDER BY DEPARTMENT_ID;

--8. ��å(job_title)�� 'President'�� ����� ���, �̸��� ����Ͻÿ�: (NaturalJOIN ���� ǥ��)
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES NATURAL JOIN JOBS
WHERE JOB_TITLE = 'President';

--9. ��å(job_title)�� 'President'�� �ƴ� ����� ���, �̸��� ����Ͻÿ�(JOIN USING ���� ǥ��)
SELECT E.EMPLOYEE_ID, E.FIRST_NAME
FROM EMPLOYEES E JOIN JOBS J USING (JOB_ID)
WHERE J.job_title <> 'President'
ORDER BY EMPLOYEE_ID;
--10. �μ���ȣ, �μ���, �μ��� �޿��Ѿװ� ��ձ޿��� ����Ͻÿ�.
--��, �޿��Ѿ��� ���� ������ �����ϰ�,
--��ձ޿��� �Ҽ��� ���� 1 �ڸ����� ��Ÿ������ �ݿø��ؾ� �Ѵ�.

SELECT D.DEPARTMENT_ID, D.DEPARTMENT_NAME, SUM(E.SALARY), ROUND(AVG(E.SALARY),1)
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
GROUP BY E.SALARY, D.DEPARTMENT_ID, D.DEPARTMENT_NAME;

--11. 'Seattle', 'Toronto'���ÿ� �ٹ��ϴ�
--������� ���ø�,���, �̸�, �μ� ID, �μ��� �� ����Ͻÿ�
SELECT L.CITY, E.FIRST_NAME, E.DEPARTMENT_ID, D.DEPARTMENT_NAME
FROM EMPLOYEES E JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
                JOIN LOCATIONS L ON D.LOCATION_ID = L.LOCATION_ID 
WHERE CITY IN ('Seattle', 'Toronto')
ORDER BY CITY;

--12. 'Seattle'�� ������ ������ �μ��� ������� 5 ��̸��� ���ø�, �μ� ID, �μ���, �������
--����Ͻÿ� 
SELECT L.CITY, E.DEPARTMENT_ID, D.DEPARTMENT_NAME, COUNT(D.DEPARTMENT_ID)
FROM EMPLOYEES E JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
                JOIN LOCATIONS L ON D.LOCATION_ID = L.LOCATION_ID
GROUP BY E.DEPARTMENT_ID,L.CITY, D.DEPARTMENT_NAME
HAVING COUNT(E.DEPARTMENT_ID)<5;

--13. �μ� ID �� 50 �̰ų� 80 �� �μ��� �ٹ��ϴ� ������� ���� ID �� ��å(job_title)�� ����Ͻÿ�.
--������� ����(job_id)�� �ߺ��� �����Ͻÿ� --5 ��
SELECT DISTINCT J.JOB_ID, JOB_TITLE 
FROM EMPLOYEES E JOIN JOBS J ON E.JOB_ID = J.JOB_ID
WHERE department_id IN (50,80);

--14. ����� ���, �����ڹ�ȣ, �μ� ID, �μ���, �μ��� ID �� ����Ͻÿ�
SELECT E.EMPLOYEE_ID, D.MANAGER_ID, DEPARTMENT_ID, D.DEPARTMENT_NAME
FROM employees E JOIN DEPARTMENTS D USING (DEPARTMENT_ID);
--15. ���� 'Davies'�� ����� �μ� ID �� �޿��� ����Ͻÿ�.
SELECT LAST_NAME, DEPARTMENT_ID, SALARY 
FROM EMPLOYEES 
WHERE LAST_NAME = 'Davies';
--16. ���� 'Davies'�� ����� ���� �μ��� �ٹ��ϴ� ������� ���, ��, �̸��� ����Ͻÿ�--44 ��
SELECT EMPLOYEE_ID, LAST_NAME, FIRST_NAME
FROM EMPLOYEES  JOIN DEPARTMENTS  USING (DEPARTMENT_ID)
WHERE DEPARTMENT_ID=(SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE LAST_NAME='Davies');

SELECT e.EMPLOYEE_ID, LAST_NAME, e.FIRST_NAME
FROM employees E JOIN employees davisE using (last_name)
order by employee_id;
