CREATE TABLE STUDENT (
    STUDENT_ID   NUMBER PRIMARY KEY,          -- 학생 고유 ID (PK)
    STUDENT_NO   VARCHAR2(20) UNIQUE,         -- 학번 (중복 방지)
    NAME         VARCHAR2(100) NOT NULL,      -- 이름
    DEPARTMENT   VARCHAR2(100),               -- 학과
    GRADE        NUMBER,                      -- 학년 (1~4)
    EMAIL        VARCHAR2(200),               -- 이메일
    PHONE        VARCHAR2(20),                -- 전화번호
    BIRTH_DATE   DATE,                        -- 생년월일
    GENDER       VARCHAR2(10),                -- 성별
    STATUS       VARCHAR2(20) DEFAULT '재학', -- 상태 (재학, 휴학, 수료, 학사 등)
    CREATED_AT   DATE DEFAULT SYSDATE,        -- 생성일
    UPDATED_AT   DATE                         -- 수정일
);

CREATE SEQUENCE SEQ_STUDENT
START WITH 1
INCREMENT BY 1
NOCACHE;