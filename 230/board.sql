CREATE TABLE Board(   
 boardIdx NUMBER(10) CONSTRAINT board_boardIdx_pk PRIMARY KEY, 
 boardType NUMBER(5) NOT NULL,
 boardTitle VARCHAR2(100) NOT NULL,
 boardcontent VARCHAR2 (1000) NOT NULL,
 boardattachment VARCHAR2(50),
 boardcreateAt timestamp DEFAULT SYSDATE,
 boardThumbUp NUMBER(30) DEFAULT 0,
 userIdx NUMBER(5) CONSTRAINT board_boardIdx_fk REFERENCES UserInfo(userIdx)
);

INSERT INTO Board VALUES (1, '잡담', '게시글제목1', '게시글내용1', '첨부파일1', '', '', 1);  