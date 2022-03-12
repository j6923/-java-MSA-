CREATE TABLE FAQ(
    FAQIDX NUMBER(5) CONSTRAINT FAQ_IDX_PK PRIMARY KEY,
    FAQCONTENT VARCHAR2(100) CONSTRAINT FAQ_CONTTENT_NULL NOT NULL,
    FAQREPLY VARCHAR2 (1000) CONSTRAINT FAQ_REPLY_NULL NOT NULL,
    FAQCREATEAT TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
    
-- �������� 
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

INSERT INTO FAQ VALUES(1,'��й�ȣ ��߱��� ��� �ϳ���?','1. Ȩ������ ��û
Ȩ������ �� ī��Ұ����� ���ϴ� ī���ǰ ���� �� ī�� ��û
(��, ī�� ��ǰ�� ���� Ȩ������ ��û�� �Ұ��� �� �ִ� �� ���� �ٶ��ϴ�.) 2. ���� ��û
������(�� 1544-7000) ���� ���� �� ��߱� ��û 3. ����ī�� ���� �� �������� ������ ��û
�ֹε������ �� ������ ����� �������� ���� �����Ͽ� ��߱� ��û[�������]
1. ī�� ��߱� �� ī���ȣ�� �Ϻ� �Ǵ� ��ü�� ��ȿ�Ⱓ�� ��� ����ǹǷ� �����, ���ͳ� ��ŷ� �� �ڵ���ü ��û������ �ִٸ� �ش�縦 ���� ���ο� ī���ȣ�� ���� ��û �� �̿� �ٶ��ϴ�. 
2. ī�� ���ɱ����� �� ������ ���ķ� �ҿ�˴ϴ�.');

INSERT INTO NOTICE VALUES(1,50,'������������� ���� ���� ���� ���Ⱓ �翬��(`22.3��������) �ȳ�', '2022�� ��������������� �ϰ��� ���α׷� �ΰ���Ź����� ��������
���뵿�� ���� 2021-495ȣ2022�⵵ ����������������� �ϰ��� ���α׷� �� ��� ���� �ΰ���Ź����� ���� ��ȹ�� ���Ӱ� ���� �����մϴ�.
2021��12�� 6�ϰ��뵿�����');
