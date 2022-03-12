--Ʈ������
-- Quary(SELECT) Ʈ����� �ڵ�����, Ʈ����� �ڵ����� 
--DML : INSERT, UPDATE, DELETE  Ʈ����� �ڵ�����, �ڵ�����ȵ�. 
--DDL : CREATE, ALTER, DROP Ʈ����� �ڵ�����, Ʈ����� �ڵ����� 
INSERT INTO CUSTOMER(id,pwd) VALUES ('testid', 'testp');

SELECT * FROM CUSTOMER;
COMMIT; -- ���� ��� ��ML������ ���� ��� �ݿ��ϰ� �ȴ�. 
         -- Ʈ������ �Ϸ� 

UPDATE CUSTOMER SET pwd='testpp' WHERE id='testid';
-- �ӽ� ����Ǿ� �ִ� ��ó�� ���̴°� �̷����̶�� �Ѵ�. 
SELECT * FROM CUSTOMER;
ROLLBACK; -- ����Ѵ�.
          -- Ʈ������ ��� 
-- �Ϸ� : COMMIT  - DML���� �ݿ��� �ȴ�. 
-- DROP�̳� CREATE�� ROLLBACK�� �Ұ��ϴ�. 
--------
CREATE TABLE ACCOUNT(NO CHAR(3) PRIMARY KEY, BALANCE NUMBER(10) DEFAULT 0 NOT NULL); 
-- DEFAULT 0�� ���� ������ �⺻���� 0�̴�. 
-- ������ NULLL�� �Է� �Ұ��� NOT NULL �̰� DEFAULT�� �⺻������ �� ���� �� 
INSERT INTO ACCOUNT VALUES ('101', 100);
INSERT INTO ACCOUNT(NO) VALUES ('102'); 
SELECT * FROM ACCOUNT;

COMMIT;
--101�� ���¿��� 30���� 102�����·� ��ü�Ѵ�. 
UPDATE ACCOUNT SET BALANCE = BALANCE-30 WHERE NO='101'; --TX0
UPDATE ACCOUNT SET BALANCE = BALANCE+30 WHERE NO='102'; --TX0
COMMIT;
SELECT * FROM ACCOUNT;

-- Ʈ������ 4���� ���� 
--101�����¿��� 1000���� 102�� ���·� ��ü�Ѵ�. 
-- ���̳ʽ� ���� ���ٰ� �����Ѵ�. 
UPDATE ACCOUNT SET BALANCE = BALANCE-1000 WHERE NO='101'; --TX0
UPDATE ACCOUNT SET BALANCE = BALANCE+1000 WHERE NO='102'; --TX0
SELECT * FROM ACCOUNT;
-- ������ ��ݰ� �Ա��� �� ���·� ���� ���·� �����ϴ� ���̰� �̰��� ROLLBACK�̶�� �Ѵ�. 
ROLLBACK;
SELECT * FROM ACCOUNT; --�� ���·� ���ƿ� ���� Ȯ���� �� �ִ�. 
--101�����¿��� 10���� 999�� ���·� ��ü�Ѵ�. 
-- ������ �� ������ 999�� ���°� ���� ó�� 0���� �Ǿ������. 
UPDATE ACCOUNT SET BALANCE = BALANCE-10 WHERE NO='101'; --TX0
UPDATE ACCOUNT SET BALANCE = BALANCE+10 WHERE NO='999'; --TX0
-- 10���� ���������� ��� �� ���� ���� ���̴�. 
SELECT * FROM ACCOUNT;
ROLLBACK;
-- SAVE POINT 
DELETE FROM ACCOUNT;
SAVEPOINT A;
INSERT INTO ACCOUNT(NO) VALUES('103');
UPDATE ACCOUNT SET BALANCE=700 WHERE NO='103'; 
SAVEPOINT B;
INSERT INTO ACCOUNT(NO) VALUES ('104');
ROLLBACK; -- DELETE ������ ���ư� 
--ROLLBACK TO SAVEPOINT A; -- A������ ROLLBACK�� �ȴ�. 
--ROLLBACK TO SAVEPOINT B;
SELECT * FROM ACCOUNT;
----------------------
INSERT INTO ACCOUNT(NO) VALUES ('888');--tx-0 ������ �Ǿ����� ���ᰡ �ȵ� 
-- ���ڱ� ���Ⱑ ������ �� �ڵ� rollback�� �ȴ�. 



