-- Data Definition Language 
--객체 생성CREATE, 변경ALTER, 삭제 DROP

-- 테이블명 컬럼명은 숫자로 시작안됨, 예약어안됨. (date, number, order)
CREATE TABLE t1(
    a char(5),
    b varchar2(5),
    c number(5), 
    d number (5,2),
    e DATE 
);
-- 숫자로 만들어서는 안된다. 
-- 오라클 예약어로 사용하면 안된다. 
-- 행을 구성하는 것이 컬럼 
-- 테이블의 구성요소가 행이다. 

-- 테이블 구조 확인 
DESC T1;  
ALTER TABLE t1 -- alter table 테이블 명 -> 테이블 수정 
ADD F VARCHAR2(2); -- 컬럼 추가   -- ALTER 테이블로 ADD 옵션을 줌

ALTER TABLE t1
DROP COLUMN F;  --테이블 삭제 

DESC T1;

ALTER TABLE t1
MODIFY d NUMBER(7,2);         -- 컬럼 자료형/자릿수 변경 

ALTER TABLE t1
RENAME COLUMN D TO DD;   -- 컬럼명 변경 

RENAME t1 TO t11;    --테이블 이름 변경 

desc t11;

drop table t11;
roll back;
desc t11;
------ 
--고객 테이블 : CUSTOMER 
-- 아이디 컬럼: id VARCHAR2(10)
-- 비밀번호컬럼 : pwd VARCHAR2(10)
-- 주민번호같이 13자리인 경우는 CHAR를 사용하는 것이 좋다. 
-- 이름컬럼 : name VARCHAR2(10)
-- 주소컬럼 : address varchar2(30)  --한글 10자리 실제는 우편번호 테이블 따로 참조하도록 되어 있다. 

CREATE TABLE CUSTOMER(
    id VARCHAR2(10),
    pwd VARCHAR2(10),
    name VARCHAR2(10),
    address VARCHAR2(30)
);

DESC CUSTOMER;

ALTER TABLE CUSTOMER 

-- 제약 조건 설정방법 
-- 컬럼레벨 제약조건 설정 
CREATE TABLE t2(
    a char(5) CONSTRAINT t2_a_nn NOT NULL,
    b varchar2(5) CONSTRAINT t2_b_uq UNIQUE,
    C number(5) CONSTRAINT t2_c_pk PRIMARY KEY
);-- 
--테이블 레벨 제약조건 설정 --not null은 컬럼 level로만 설정해줘야 한다. 
--어떤 것의 제약 조건인지 설정해줘야 
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
--  CONSTRAINT 제약조건이름 FOREIGN KEY(b) REFERENCES t2(c)
--);
-- 부모엔터티의 pk자료형과 같아야 한다. 
--이미 존재하는 테이블인 경우 테이블 구조변경으로 제약조건을 추가할 수 있다.
DESC CUSTOMER;
ALTER TABLE CUSTOMER 
ADD CONSTRAINT CUSTOMER_ID_PK PRIMARY KEY(id);-- 테이블 레벨 제약조건 형식조건 
-- 제약조건 추가 제약조건 명 
-- constraint부터 제약조건이름까지 생략해도 됨. 
-- 재약조건 이름은 될 수 있으면 써주는 것이 좋다. 
ALTER TABLE CUSTOMER -- 컬럼레벨로 제약조건 수정 
-- 컬럼 만들면서 제약조건 추가하는 것
-- not null은 이름이 노출이 안 되서 굳이 쓸 필요없어 생략많이 한다. 
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

--- 딕셔너리 정보 
-- 테이블 정보가 담겨있는 애가 USER_TABLES
DESC USER_TABLES;
SELECT * FROM USER_TABLES;
--CUSTOMER 테이블에 대한 정보는 USER_TABLES에 있다. 
-- 딕셔너리 제약조건정보 
SELECT * FROM USER_CONSTRAINTS;  --제약조건이 다 들어있음. 
SELECT * FROM USER_CONSTRAINTS WHERE LOWER(CONSTRAINT_NAME) = 'order_line_quantity_ck';
UPDATE user_constraints SET constraint_name= UPPER('order_line_quant_ck') WHERE LOWER(CONSTRAINT_NAME) ='order_line_quantity_ck';
-- 권한 없어 안됨]
-- 제약조건제거
ALTER TABLE order_line
DROP CONSTRAINT order_line_quantity_ck;
-- 체크 제약 조건 삭제 

SELECT * FROM USER_CONSTRAINTS WHERE LOWER(CONSTRAINT_NAME) = 'order_line_quantity_ck';
-- 제약조건을 없애버림. 
--제약조건추가 
ALTER TABLE order_line
ADD CONSTRAINT order_line_quantity_ck CHECK (order_quantity>0);


