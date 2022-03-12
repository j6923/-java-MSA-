-- ������ ���۾� : INSERT/ UPDATE/ DELETE 

-- �ڷ��߰� 
INSERT INTO CUSTOMER VALUES ('id1', 'p1', 'n1', '�����');-- �÷� ������ ������� �ϸ� ��. 
INSERT INTO CUSTOMER  (id, pwd) VALUES ('id2', 'p2') ;-- id�� pwd�� �����ϰھ� 
-- id2 p2 null null 
INSERT INTO CUSTOMER VALUES ('id3', 'p3', 'n3', null);
INSERT INTO CUSTOMER VALUES ('id4', 'p4', 'n4', '');  -- '' �� ���̴� 
SELECT * FROM CUSTOMER;

-- �ڷ� ���� 
--UPDATE ���̺� ��   
--SET  �÷� �̸� 
--WHERE ;

UPDATE CUSTOMER
SET name ='������'
WHERE id='id3';  --LIKE><>=<= ��� ��밡���ϴ�. 

SELECT * FROM CUSTOMER;     --id3 p3 ������ 
                            -- id2 p2 null null 

UPDATE CUSTOMER 
SET ADDRESS='��⵵', name = '������'  -- �� ������ �����Ϸ��� , ���� 
WHERE id='id2';


UPDATE CUSTOMER 
SET address = null;   -- �� �����
-- where������ ������ ��� ���� �� �����ȴ�. 

--  ������ ���� 
--DELETE FROM ���̺��
--DELETE FROM CUSTOMER-- �̷��� �ָ� �� ���� 

DELETE FROM CUSTOMER WHERE name = '������'; --������ ���� 
SELECT * FROM CUSTOMER;

--DELETE �� ���� 
-- DROP �� ���̺� ���� 
-- DELETE�� ���̺� ������ �����ִ� 

--���� ���� �ڷ� �Է��ϴ� ��� 
--SHOW RECYCLEBIN
-- Ư�� �÷��� �������� �����ϱ� 
-- ���Ἲ��������: NOT NULL, UNIQUE, PRIMARY KEY, FOREIGN KEY, CHECK 
-- NOT NULL�� NULL�� ���� �ȵ�. 
-- UNIQUE : �ߺ��ȵ�. 
-- PRIMARY KEY: NOT NULL + UNIQUE 
-- FOREIGN KEY :  �ٸ� ���̺��� �÷��� �����Ѵ�. 
                 -- ���̺� PK�� ���� 
--CHECK : �� ���� ���� ���� 
          -- ��, ��, ���, ���� ���� ���� ����ǵ��� ���� 
          


-- �������� Ȯ�� 
-- NOT NULL ���� ���� 
INSERT INTO t2 VALUES (NULL, 'a', 1);  --HR ������ T2���̺��� A 
--ORA-01400: cannot insert NULL into ("HR"."T2"."A")
INSERT INTO t2 VALUES ('a1', 'a', 11);
INSERT INTO t2 ('a1', 'aa', 12); -- ok �ߺ����� 
--UNIQUE �������� ���� 
INSERT INTO t2 (a,b,c) VALUES ('a', 'b2', 1);
INSERT INTO t2 (a,b,c) VALUES ('a2', 'b2', 2);  --ORA-00001: unique constraint (HR.T2_B_UQ) violated
INSERT INTO t2 (a,b,c) VALUES ('a2', '', 2); --unique�� null�� ���� ok ���԰���
INSERT INTO t2 (a,b,c) VALUES ('a2', null, 3); --ok NULL ���԰��� 
---------------
INSERT INTO t2(a,b,c) VALUES ('a', null, null); -- c �÷� PK���� ���� 
-- ORA-01400: cannot insert NULL into ("HR"."T2"."C")
INSERT INTO t2(a,b,c) VALUES ('a', null, 1);   --ORA-00001: unique constraint (HR.T2_C_PK) violated


SELECT * FROM T2;


--CHECK ���� 
INSERT INTO t3(a,b) VALUES ('a1', 0);--ORA-02290: check constraint (HR.T3_B_CK) violated
INSERT INTO t3(a,b) VALUES ('a2', -2); --ORA-02290: check constraint (HR.T3_B_CK) violated

-- foreign key ���� 
INSERT INTO t4(a,b) VALUES ('a1', 2); --ok 
INSERT INTO t4(a,b) VALUES ('a2', 999); --ORA-02291: integrity constraint (HR.T4_B_FK) violated - parent key not found

--not null�� �÷� level�θ� ��������� �Ѵ�. 
--�����̺��� PK. NOTNULL �������� Ȯ�� 
DELETE FROM CUSTOMER;
INSERT INTO CUSTOMER(id, pwd) VALUES ('id1', 'p1');
INSERT INTO CUSTOMER(id, pwd) VALUES ('id1', 'p2');--ORA-00001: unique constraint (HR.CUSTOMER_ID) violated
INSERT INTO CUSTOMER(id, pwd) values ('', 'p2');  --ORA-01400: cannot insert NULL into ("HR"."CUSTOMER"."ID")
INSERT INTO CUSTOMER(id) VALUES ('id3');  -- ���� ���� ���� null�� ���� 
--ORA-01400: cannot insert NULL into ("HR"."CUSTOMER"."PWD")


UPDATE CUSTOMER SET NAME = '������', ADDRESS = '����';

INSERT INTO CUSTOMER VALUES ('id2', 'p2', '��ǿ�', null);
INSERT INTO CUSTOMER VALUES ('id3', 'p3', '�赿��', '����');
select * from customer;

INSERT INTO PRODUCT VALUES ('C0001', '�Ƹ޸�ī��', 1000);
INSERT INTO PRODUCT VALUES ('C0002', 'ICE�Ƹ޸�ī��', 1000);
INSERT INTO PRODUCT VALUES ('C0003', '����', 1500);
INSERT INTO PRODUCT VALUES ('C0004', 'ICE����', 1500);
SELECT *FROM PRODUCT;

INSERT INTO ORDER_INFO VALUES (1, 'id2', '21/11/10');
INSERT INTO ORDER_LINE VALUES (1,'C0002',2);
INSERT INTO ORDER_LINE VALUES (1,'C0003',1);

INSERT INTO ORDER_INFO VALUES (2, 'id3', '21/11/10');
INSERT INTO ORDER_LINE VALUES (2,'C0002',1);

INSERT INTO ORDER_INFO VALUES (3, 'id2', '21/11/10');
INSERT INTO ORDER_LINE VALUES (3,'C0001',1);
INSERT INTO ORDER_LINE VALUES (3,'C0002',1);






--�ֹ���ȣ, �ֹ�����, �ֹ���ǰ��ȣ, �ֹ���ǰ��, ��ǰ����, �ֹ������� ����Ͻÿ� 
SELECT INFO.ORDER_NO, INFO.ORDER_DT, LINE.ORDER_PROD_NO, P.PROD_NAME, P.PROD_PRICE, LINE.ORDER_QUANTITY 
FROM ORDER_INFO INFO JOIN ORDER_LINE LINE ON (INFO.ORDER_NO = LINE.ORDER_NO) 
JOIN PRODUCT P ON (LINE.ORDER_PROD_NO = P.PROD_NO)
WHERE ORDER_ID = 'id2'
ORDER BY ORDER_NO DESC, PROD_NAME ASC; 