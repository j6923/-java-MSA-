--트랜젝션
-- Quary(SELECT) 트랜잭션 자동시작, 트랜잭션 자동종료 
--DML : INSERT, UPDATE, DELETE  트랜잭션 자동시작, 자동종료안됨. 
--DDL : CREATE, ALTER, DROP 트랜잭션 자동시작, 트랜잭션 자동종료 
INSERT INTO CUSTOMER(id,pwd) VALUES ('testid', 'testp');

SELECT * FROM CUSTOMER;
COMMIT; -- 실제 디비에 디ML구문이 실제 디비에 반영하게 된다. 
         -- 트랜젝션 완료 

UPDATE CUSTOMER SET pwd='testpp' WHERE id='testid';
-- 임시 저장되어 있는 것처럼 보이는게 미러링이라고 한다. 
SELECT * FROM CUSTOMER;
ROLLBACK; -- 취소한다.
          -- 트랜젝션 취소 
-- 완료 : COMMIT  - DML에만 반영이 된다. 
-- DROP이나 CREATE는 ROLLBACK이 불가하다. 
--------
CREATE TABLE ACCOUNT(NO CHAR(3) PRIMARY KEY, BALANCE NUMBER(10) DEFAULT 0 NOT NULL); 
-- DEFAULT 0은 적지 않으면 기본값이 0이다. 
-- 강제로 NULLL값 입력 불가가 NOT NULL 이고 DEFAULT는 기본값으로 얼마 들어가는 것 
INSERT INTO ACCOUNT VALUES ('101', 100);
INSERT INTO ACCOUNT(NO) VALUES ('102'); 
SELECT * FROM ACCOUNT;

COMMIT;
--101번 계좌에서 30원을 102번계좌로 이체한다. 
UPDATE ACCOUNT SET BALANCE = BALANCE-30 WHERE NO='101'; --TX0
UPDATE ACCOUNT SET BALANCE = BALANCE+30 WHERE NO='102'; --TX0
COMMIT;
SELECT * FROM ACCOUNT;

-- 트렌젝션 4가지 조건 
--101번계좌에서 1000원을 102번 계좌로 이체한다. 
-- 마이너스 통장 없다고 가정한다. 
UPDATE ACCOUNT SET BALANCE = BALANCE-1000 WHERE NO='101'; --TX0
UPDATE ACCOUNT SET BALANCE = BALANCE+1000 WHERE NO='102'; --TX0
SELECT * FROM ACCOUNT;
-- 복구란 출금과 입금을 전 상태로 돌린 상태로 복구하는 것이고 이것을 ROLLBACK이라고 한다. 
ROLLBACK;
SELECT * FROM ACCOUNT; --원 상태로 돌아온 것을 확인할 수 있다. 
--101번계좌에서 10원을 999번 계좌로 이체한다. 
-- 에러는 안 나지만 999번 계좌가 없어 처리 0건이 되어버린다. 
UPDATE ACCOUNT SET BALANCE = BALANCE-10 WHERE NO='101'; --TX0
UPDATE ACCOUNT SET BALANCE = BALANCE+10 WHERE NO='999'; --TX0
-- 10원이 빠져버리고 어디 들어간 곳이 없는 것이다. 
SELECT * FROM ACCOUNT;
ROLLBACK;
-- SAVE POINT 
DELETE FROM ACCOUNT;
SAVEPOINT A;
INSERT INTO ACCOUNT(NO) VALUES('103');
UPDATE ACCOUNT SET BALANCE=700 WHERE NO='103'; 
SAVEPOINT B;
INSERT INTO ACCOUNT(NO) VALUES ('104');
ROLLBACK; -- DELETE 전으로 돌아감 
--ROLLBACK TO SAVEPOINT A; -- A까지만 ROLLBACK이 된다. 
--ROLLBACK TO SAVEPOINT B;
SELECT * FROM ACCOUNT;
----------------------
INSERT INTO ACCOUNT(NO) VALUES ('888');--tx-0 시작은 되었으나 종료가 안됨 
-- 갑자기 전기가 나갔을 때 자동 rollback이 된다. 



