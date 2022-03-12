-- 데이터 조작어 : INSERT/ UPDATE/ DELETE 

-- 자료추가 
INSERT INTO CUSTOMER VALUES ('id1', 'p1', 'n1', '서울시');-- 컬럼 나열한 순서대로 하면 됨. 
INSERT INTO CUSTOMER  (id, pwd) VALUES ('id2', 'p2') ;-- id와 pwd만 저장하겠어 
-- id2 p2 null null 
INSERT INTO CUSTOMER VALUES ('id3', 'p3', 'n3', null);
INSERT INTO CUSTOMER VALUES ('id4', 'p4', 'n4', '');  -- '' 도 널이다 
SELECT * FROM CUSTOMER;

-- 자료 변경 
--UPDATE 테이블 명   
--SET  컬럼 이름 
--WHERE ;

UPDATE CUSTOMER
SET name ='오문정'
WHERE id='id3';  --LIKE><>=<= 모두 사용가능하다. 

SELECT * FROM CUSTOMER;     --id3 p3 오문정 
                            -- id2 p2 null null 

UPDATE CUSTOMER 
SET ADDRESS='경기도', name = '오문정'  -- 값 여러개 변경하려면 , 쓰기 
WHERE id='id2';


UPDATE CUSTOMER 
SET address = null;   -- 다 변경됨
-- where조건이 없으면 모든 행이 다 수정된다. 

--  데이터 삭제 
--DELETE FROM 테이블명
--DELETE FROM CUSTOMER-- 이렇게 주면 다 삭제 

DELETE FROM CUSTOMER WHERE name = '오문정'; --데이터 삭제 
SELECT * FROM CUSTOMER;

--DELETE 행 삭제 
-- DROP 은 테이블 삭제 
-- DELETE는 테이블 구조는 남아있다 

--옳지 않은 자료 입력하는 경우 
--SHOW RECYCLEBIN
-- 특정 컬럼에 제약조건 설정하기 
-- 무결성제약조건: NOT NULL, UNIQUE, PRIMARY KEY, FOREIGN KEY, CHECK 
-- NOT NULL은 NULL값 포함 안됨. 
-- UNIQUE : 중복안됨. 
-- PRIMARY KEY: NOT NULL + UNIQUE 
-- FOREIGN KEY :  다른 테이블의 컬럼을 참조한다. 
                 -- 테이블 PK를 참조 
--CHECK : 값 범위 지정 가능 
          -- 남, 여, 양수, 음수 등의 값만 저장되도록 설정 
          


-- 제약조건 확인 
-- NOT NULL 조건 위배 
INSERT INTO t2 VALUES (NULL, 'a', 1);  --HR 계정의 T2테이블의 A 
--ORA-01400: cannot insert NULL into ("HR"."T2"."A")
INSERT INTO t2 VALUES ('a1', 'a', 11);
INSERT INTO t2 ('a1', 'aa', 12); -- ok 중복가능 
--UNIQUE 제약조건 위배 
INSERT INTO t2 (a,b,c) VALUES ('a', 'b2', 1);
INSERT INTO t2 (a,b,c) VALUES ('a2', 'b2', 2);  --ORA-00001: unique constraint (HR.T2_B_UQ) violated
INSERT INTO t2 (a,b,c) VALUES ('a2', '', 2); --unique는 null값 가능 ok 포함가능
INSERT INTO t2 (a,b,c) VALUES ('a2', null, 3); --ok NULL 포함가능 
---------------
INSERT INTO t2(a,b,c) VALUES ('a', null, null); -- c 컬럼 PK제약 조건 
-- ORA-01400: cannot insert NULL into ("HR"."T2"."C")
INSERT INTO t2(a,b,c) VALUES ('a', null, 1);   --ORA-00001: unique constraint (HR.T2_C_PK) violated


SELECT * FROM T2;


--CHECK 위배 
INSERT INTO t3(a,b) VALUES ('a1', 0);--ORA-02290: check constraint (HR.T3_B_CK) violated
INSERT INTO t3(a,b) VALUES ('a2', -2); --ORA-02290: check constraint (HR.T3_B_CK) violated

-- foreign key 위배 
INSERT INTO t4(a,b) VALUES ('a1', 2); --ok 
INSERT INTO t4(a,b) VALUES ('a2', 999); --ORA-02291: integrity constraint (HR.T4_B_FK) violated - parent key not found

--not null은 컬럼 level로만 설정해줘야 한다. 
--고객테이블의 PK. NOTNULL 제약조건 확인 
DELETE FROM CUSTOMER;
INSERT INTO CUSTOMER(id, pwd) VALUES ('id1', 'p1');
INSERT INTO CUSTOMER(id, pwd) VALUES ('id1', 'p2');--ORA-00001: unique constraint (HR.CUSTOMER_ID) violated
INSERT INTO CUSTOMER(id, pwd) values ('', 'p2');  --ORA-01400: cannot insert NULL into ("HR"."CUSTOMER"."ID")
INSERT INTO CUSTOMER(id) VALUES ('id3');  -- 적지 않을 때는 null로 기입 
--ORA-01400: cannot insert NULL into ("HR"."CUSTOMER"."PWD")


UPDATE CUSTOMER SET NAME = '오문정', ADDRESS = '서울';

INSERT INTO CUSTOMER VALUES ('id2', 'p2', '김건우', null);
INSERT INTO CUSTOMER VALUES ('id3', 'p3', '김동현', '전북');
select * from customer;

INSERT INTO PRODUCT VALUES ('C0001', '아메리카노', 1000);
INSERT INTO PRODUCT VALUES ('C0002', 'ICE아메리카노', 1000);
INSERT INTO PRODUCT VALUES ('C0003', '라테', 1500);
INSERT INTO PRODUCT VALUES ('C0004', 'ICE라테', 1500);
SELECT *FROM PRODUCT;

INSERT INTO ORDER_INFO VALUES (1, 'id2', '21/11/10');
INSERT INTO ORDER_LINE VALUES (1,'C0002',2);
INSERT INTO ORDER_LINE VALUES (1,'C0003',1);

INSERT INTO ORDER_INFO VALUES (2, 'id3', '21/11/10');
INSERT INTO ORDER_LINE VALUES (2,'C0002',1);

INSERT INTO ORDER_INFO VALUES (3, 'id2', '21/11/10');
INSERT INTO ORDER_LINE VALUES (3,'C0001',1);
INSERT INTO ORDER_LINE VALUES (3,'C0002',1);






--주문번호, 주문일자, 주문상품번호, 주문상품명, 상품가격, 주문수량을 출력하시오 
SELECT INFO.ORDER_NO, INFO.ORDER_DT, LINE.ORDER_PROD_NO, P.PROD_NAME, P.PROD_PRICE, LINE.ORDER_QUANTITY 
FROM ORDER_INFO INFO JOIN ORDER_LINE LINE ON (INFO.ORDER_NO = LINE.ORDER_NO) 
JOIN PRODUCT P ON (LINE.ORDER_PROD_NO = P.PROD_NO)
WHERE ORDER_ID = 'id2'
ORDER BY ORDER_NO DESC, PROD_NAME ASC; 