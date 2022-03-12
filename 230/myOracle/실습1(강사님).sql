-- 1. �޿��� 10000 �̰ų� 14000 �� ������� ���, �̸�(first_name), �޿��� �˻��Ͻÿ�.
SELECT employee_id ���, first_name �̸�, salary �޿�
FROM employees
WHERE  salary IN (10000 ,14000);

-- 2. first_name �� ��ҹ��ڱ�������('e', 'E')�� �����ϴ� ��� ����� �˻��Ͻÿ�
SELECT employee_id, first_name
FROM employees
WHERE upper(first_name) LIKE '%E%';

-- 3. first_name �� 'J���� �����ϰ� n ���ڸ� �����ϴ� ����� ���, �̸��� �˻��Ͻÿ�.
SELECT employee_id, first_name
FROM employees
WHERE  first_name LIKE 'J%n%';

--4 �޿��� 10000 �̻��� ����� ���, �μ���ȣ, �̸�, �޿�, ������ ����Ͻÿ�.��, �μ���ȣ��
--  30 ��,60 ��, 90 ���� �μ��� �����ϰ� ����� �˻��Ѵ�.
SELECT employee_id ���, department_id �μ���ȣ, 
first_name ||' '|| last_name "��� ����", salary ���� , salary+(salary*NVL(commission_pct, 0)) ����
FROM employees
WHERE  salary >= 10000 AND department_id NOT IN (30, 60, 90);

--5. �޿��� 4000 ���� ���� ������� �μ��� �޿���ո� ����Ͻÿ�. �� �޿������
--   �Ҽ������� 2 �ڸ����� �ݿø��մϴ�.
SELECT department_id �μ���ȣ ,ROUND(AVG(salary),1) ��ձ޿�
FROM employees
WHERE salary > 4000
GROUP BY department_id;

--6. �μ���ġ�� ���� ���� ����� �����ϰ� �μ��� �޿������ ����Ͻÿ�.�� �޿������
--   �Ҽ������� 2 �ڸ����� �ݿø��մϴ�.
SELECT department_id �μ���ȣ ,ROUND(AVG(salary),1) ��ձ޿�
FROM employees
WHERE department_id is not null
GROUP BY department_id;

--7. �μ���ġ�� ���� ���� ����� �����ϰ� �޿������ 10000 �̻��� �μ��� �޿������
--   ����Ͻÿ�.�� �޿������ �Ҽ������� 2 �ڸ����� �ݿø��մϴ�
SELECT department_id �μ���ȣ ,ROUND(AVG(salary),1) ��ձ޿�
FROM employees
WHERE department_id is not null
GROUP BY department_id
HAVING avg(salary) >= 10000;

--8 ��å(job_title)�� 'President'�� ����� ���, �̸��� ����Ͻÿ�: (NaturalJOIN ���� ǥ��)
SELECT employee_id, first_name 
FROM employees 
NATURAL JOIN jobs 
WHERE job_title = 'President';

--9. ��å(job_title)�� 'President'�� �ƴ� ����� ���, �̸��� ����Ͻÿ�(JOIN USING ���� ǥ��)
SELECT employee_id, first_name
FROM employees JOIN jobs USING(job_id) 
WHERE job_title <> 'President';

--10. �μ���ȣ, �μ���, �μ��� �޿��Ѿװ� ��ձ޿��� ����Ͻÿ�.
--    ��, �޿��Ѿ��� ���� ������ �����ϰ�,
--    ��ձ޿��� �Ҽ��� ���� 1 �ڸ����� ��Ÿ������ �ݿø��ؾ� �Ѵ�
SELECT e.department_id �μ���ȣ, d.department_name �μ��� ,SUM(e.salary)�޿��Ѿ� , ROUND(AVG(e.salary),1)��ձ޿�
FROM employees e JOIN departments d ON e.department_id = d.department_id
GROUP BY e.department_id , d.department_name
ORDER BY  3;


-- 11. 'Seattle', 'Toronto'���ÿ� �ٹ��ϴ�
--      ������� ���ø�,���, �̸�, �μ� ID, �μ��� �� ����Ͻÿ�
-- join on
SELECT l.CITY ���ø�,  e.employee_id ���, e.first_name �̸�, d.department_id �μ�ID, d.department_name �μ���
FROM employees e 
     JOIN departments d ON e.department_id = d.department_id 
     JOIN locations l ON d.location_ID = l.location_id 
WHERE  L.CITY IN( 'Seattle', 'Toronto');

-- 12. 'Seattle'�� ������ ������ �μ��� ������� 5 ��̸��� ���ø�, �μ� ID, �μ���, ������� ����Ͻÿ�.
SELECT city, d.department_id, department_name, COUNT(*)
FROM employees e 
JOIN departments d ON (e.department_id = d.department_id) 
JOIN locations l ON (d.location_id = l.location_id)
WHERE  l.city <> 'Seattle'
GROUP BY city, d.department_id, department_name
HAVING COUNT(*) < 5;

-- 13. �μ� ID �� 50 �̰ų� 80 �� �μ��� �ٹ��ϴ� ������� ���� ID �� ��å(job_title)�� ����Ͻÿ�.
-- ������� ����(job_id)�� �ߺ��� �����Ͻÿ� --5 ��
SELECT DISTINCT e.job_id, job_title
FROM employees e JOIN jobs j ON (e.job_id = j.job_id)
WHERE e.department_id IN (50, 80);

-- 14. ����� ���, �����ڹ�ȣ, �μ� ID, �μ���, �μ��� ID �� ����Ͻÿ�  
SELECT employee_id ���, e.manager_id �����ڹ�ȣ, department_id "�μ� ID", department_name �μ���, d.MANAGER_ID "�μ��� ID"
FROM employees e JOIN departments d USING(department_id);

-- 15. ���� 'Davies'�� ����� �μ� ID �� �޿��� ����Ͻÿ�. 
SELECT department_id, salary --50, 3100
FROM employees
WHERE last_name = 'Davies';

-- 16.���� 'Davies'�� ����� ���� �μ��� �ٹ��ϴ� ������� ���, ��, �̸��� ����Ͻÿ�--44 ��
--<<16�� ��Ʈ>>
--������̺��� ���������� 1�������� �������� 2���̻����� ó���� �� �ֽ��ϴ� 
SELECT e.employee_id, e.last_name, e.first_name, e.department_id
FROM employees E JOIN employees Davies
ON e.department_id = davies.department_id
WHERE davies.last_name = 'Davies'
AND e.last_name <> 'Davies';
