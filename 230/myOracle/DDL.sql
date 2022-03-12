-- Data Definition Language 
--��ü ����CREATE, ����ALTER, ���� DROP

-- ���̺�� �÷����� ���ڷ� ���۾ȵ�, �����ȵ�. (date, number, order)
CREATE TABLE t1(
    a char(5),
    b varchar2(5),
    c number(5), 
    d number (5,2),
    e DATE 
);
-- ���ڷ� ������ �ȵȴ�. 
-- ����Ŭ ������ ����ϸ� �ȵȴ�. 
-- ���� �����ϴ� ���� �÷� 
-- ���̺��� ������Ұ� ���̴�. 

-- ���̺� ���� Ȯ�� 
DESC T1;  
ALTER TABLE t1 -- alter table ���̺� �� -> ���̺� ���� 
ADD F VARCHAR2(2); -- �÷� �߰�   -- ALTER ���̺�� ADD �ɼ��� ��

ALTER TABLE t1
DROP COLUMN F;  --���̺� ���� 

DESC T1;

ALTER TABLE t1
MODIFY d NUMBER(7,2);         -- �÷� �ڷ���/�ڸ��� ���� 

ALTER TABLE t1
RENAME COLUMN D TO DD;   -- �÷��� ���� 

RENAME t1 TO t11;    --���̺� �̸� ���� 

desc t11;

drop table t11;
roll back;
desc t11;
------ 
--�� ���̺� : CUSTOMER 
-- ���̵� �÷�: id VARCHAR2(10)
-- ��й�ȣ�÷� : pwd VARCHAR2(10)
-- �ֹι�ȣ���� 13�ڸ��� ���� CHAR�� ����ϴ� ���� ����. 
-- �̸��÷� : name VARCHAR2(10)
-- �ּ��÷� : address varchar2(30)  --�ѱ� 10�ڸ� ������ �����ȣ ���̺� ���� �����ϵ��� �Ǿ� �ִ�. 

CREATE TABLE CUSTOMER(
    id VARCHAR2(10),
    pwd VARCHAR2(10),
    name VARCHAR2(10),
    address VARCHAR2(30)
);

DESC CUSTOMER;

ALTER TABLE CUSTOMER 

-- ���� ���� ������� 
-- �÷����� �������� ���� 
CREATE TABLE t2(
    a char(5) CONSTRAINT t2_a_nn NOT NULL,
    b varchar2(5) CONSTRAINT t2_b_uq UNIQUE,
    C number(5) CONSTRAINT t2_c_pk PRIMARY KEY
);-- 
--���̺� ���� �������� ���� --not null�� �÷� level�θ� ��������� �Ѵ�. 
--� ���� ���� �������� ��������� 
CREATE TABLE t3(
    a varchar2(2), 
    b number(5),
    CONSTRAINT t3_a_pk PRIMARY KEY(a), 
    CONSTRAINT t3_b_ck CHECK (b>0)
);

CREATE TABLE t4(
  a varchar2(2) CONSTRAINT t4_a_pk PRIMARY KEY,
  b number(5),
  CONSTRAINT t4_b_fk FOREIGN KEY(b) REFERENCES t2(c)
);


--CREATE TABLE t4(
--  a varchar2(2) CONSTRAINT t4_a_pk PRIMARY KEY,
--  b number(5),
--  CONSTRAINT ���������̸� FOREIGN KEY(b) REFERENCES t2(c)
--);
-- �θ���Ƽ�� pk�ڷ����� ���ƾ� �Ѵ�. 
--�̹� �����ϴ� ���̺��� ��� ���̺� ������������ ���������� �߰��� �� �ִ�.
DESC CUSTOMER;
ALTER TABLE CUSTOMER 
ADD CONSTRAINT CUSTOMER_ID_PK PRIMARY KEY(id);-- ���̺� ���� �������� �������� 
-- �������� �߰� �������� �� 
-- constraint���� ���������̸����� �����ص� ��. 
-- ������� �̸��� �� �� ������ ���ִ� ���� ����. 
ALTER TABLE CUSTOMER -- �÷������� �������� ���� 
-- �÷� ����鼭 �������� �߰��ϴ� ��
-- not null�� �̸��� ������ �� �Ǽ� ���� �� �ʿ���� �������� �Ѵ�. 
MODIFY pwd CONSTRAINT CUSTOMER_PWD_NN NOT NULL;



desc customer;
CREATE TABLE PRODUCT(
    prod_no VARCHAR2(5) CONSTRAINT no_pk PRIMARY KEY,
    prod_name VARCHAR2(20) CONSTRAINT nm_nll NOT NULL,
    prod_price NUMBER(7) CONSTRAINT pr_ck NOT NULL, CHECK (prod_price>0)  
);
desc product;
CREATE TABLE ORDER_INFO(
    ORDER_NO NUMBER CONSTRAINT num_pk PRIMARY KEY,
    ORDER_ID VARCHAR2(10) CONSTRAINT id_nll_fk_re NOT NULL, FOREIGN KEY(ORDER_ID) REFERENCES CUSTOMER(id),
    ORDER_DT DATE CONSTRAINT dt_nll NOT NULL
);
--ORDER_ID VARCHAR2(10) CONSTRAINT id_nll_fk_re NOT NULL  REFERENCES CUSTOMER(id),

CREATE TABLE ORDER_LINE(
    ORDER_NO NUMBER CONSTRAINT LiNE_NO_PK_FK PRIMARY KEY REFERENCES ORDER_INFO(ORDER_NO),
    ORDER_PROD_NO VARCHAR2(5) CONSTRAINT LINE_PROD_PK_FK PRIMARY KEY REFERENCES PRODUCT(PROD_NO),
    ORDER_QUANTITY NUMBER(2) CONSTRAINT LINE_QUAN_NULL_CK NOT NULL CHECK(ORDER_QUANTITY>0)
);





CREATE TABLE order_line(
  order_no NUMBER CONSTRAINT order_line_no_fk REFERENCES order_info(order_no),
  order_prod_no VARCHAR2(5),
  order_quantity NUMBER(2) NOT NULL,
  CONSTRAINT order_line_pk PRIMARY KEY(order_no, order_prod_no),
  CONSTRAINT order_line_prod_no_fk FOREIGN KEY(order_prod_no) REFERENCES product(prod_no),
  CONSTRAINT order_line_quantity_ck CHECK (order_quantity > 0)
);

--CREATE TABLE order_line(
--	  order_no NUMBER CONSTRAINT order_line_no_fk REFERENCES order_info(order_no),
--	  order_prod_no VARCHAR2(5),
--	  order_quantity NUMBER(2) NOT NULL,
--	  CONSTRAINT order_line_pk PRIMARY KEY(order_no, order_prod_no),
--	  CONSTRAINT order_line_prod_no_fk FOREIGN KEY(order_prod_no) REFERENCES product(prod_no),
--	  CONSTRAINT order_line_quantity_ck CHECK (order_quantity > 0)
--	);

--- ��ųʸ� ���� 
-- ���̺� ������ ����ִ� �ְ� USER_TABLES
DESC USER_TABLES;
SELECT * FROM USER_TABLES;
--CUSTOMER ���̺� ���� ������ USER_TABLES�� �ִ�. 
-- ��ųʸ� ������������ 
SELECT * FROM USER_CONSTRAINTS;  --���������� �� �������. 
SELECT * FROM USER_CONSTRAINTS WHERE LOWER(CONSTRAINT_NAME) = 'order_line_quantity_ck';
UPDATE user_constraints SET constraint_name= UPPER('order_line_quant_ck') WHERE LOWER(CONSTRAINT_NAME) ='order_line_quantity_ck';
-- ���� ���� �ȵ�]
-- ������������
ALTER TABLE order_line
DROP CONSTRAINT order_line_quantity_ck;
-- üũ ���� ���� ���� 

SELECT * FROM USER_CONSTRAINTS WHERE LOWER(CONSTRAINT_NAME) = 'order_line_quantity_ck';
-- ���������� ���ֹ���. 
--���������߰� 
ALTER TABLE order_line
ADD CONSTRAINT order_line_quantity_ck CHECK (order_quantity>0);


