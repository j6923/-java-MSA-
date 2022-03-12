CREATE TABLE FAQ(
    FAQIDX NUMBER(5) CONSTRAINT FAQ_IDX_PK PRIMARY KEY,
    FAQCONTENT VARCHAR2(100) CONSTRAINT FAQ_CONTTENT_NULL NOT NULL,
    FAQREPLY VARCHAR2 (1000) CONSTRAINT FAQ_REPLY_NULL NOT NULL,
    FAQCREATEAT TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
    
-- 공지사항 
CREATE TABLE NOTICE(
    NTCIDX NUMBER(5) CONSTRAINT NOTICE_PK PRIMARY KEY,
    USERIDX NUMBER(5) CONSTRAINT NOTICE_FK REFERENCES USERINFO(UIDX),
    NTCTITLE VARCHAR2(100) CONSTRAINT NTC_TITLE_NULL NOT NULL,
    NTCCONTENT VARCHAR2(1000) CONSTRAINT NTC_CONTENT_NULL NOT NULL,
    NTCATTACHMENT VARCHAR2(100),
    NTCCREATEAT TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

drop table notice;
drop table faq;

INSERT INTO FAQ VALUES(1,'비밀번호 재발급은 어떻게 하나요?','1. 홈페이지 신청
홈페이지 내 카드소개에서 원하는 카드상품 선택 후 카드 신청
(단, 카드 상품에 따라 홈페이지 신청이 불가할 수 있는 점 양해 바랍니다.) 2. 유선 신청
고객센터(☎ 1544-7000) 상담원 연결 후 재발급 신청 3. 신한카드 지점 및 신한은행 영업점 신청
주민등록증을 꼭 지참후 가까운 지점으로 직접 내사하여 재발급 신청[참고사항]
1. 카드 재발급 시 카드번호의 일부 또는 전체와 유효기간이 모두 변경되므로 보험료, 인터넷 통신료 등 자동이체 신청내역이 있다면 해당사를 통해 새로운 카드번호로 변경 신청 후 이용 바랍니다. 
2. 카드 수령까지는 약 일주일 전후로 소요됩니다.');

INSERT INTO NOTICE VALUES(1,50,'재취업지원서비스 전면 비대면 제공 허용기간 재연장(`22.3월말까지) 안내', '2022년 국민취업지원제도 일경험 프로그램 민간위탁사업자 모집공고
고용노동부 공고 2021-495호2022년도 『국민취업지원제도 일경험 프로그램 』 사업 관련 민간위탁사업자 모집 계획을 붙임과 같이 공고합니다.
2021년12월 6일고용노동부장관');
