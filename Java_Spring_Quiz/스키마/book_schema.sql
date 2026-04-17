CREATE TABLE BOOK (
    BOOK_ID        NUMBER PRIMARY KEY,          -- 도서 고유 ID (PK)
    TITLE          VARCHAR2(300) NOT NULL,      -- 책 제목
    AUTHOR         VARCHAR2(200),               -- 저자
    PUBLISHER      VARCHAR2(200),               -- 출판사
    ISBN           VARCHAR2(20) UNIQUE,         -- ISBN (고유값)
    CATEGORY       VARCHAR2(100),               -- 카테고리 (IT, 소설, 역사, 전쟁, 무협 등)
    PRICE          NUMBER,                      -- 가격
    STOCK          NUMBER DEFAULT 0,            -- 재고 수량
    PUBLISHED_DATE DATE,                        -- 출판일
    DESCRIPTION    CLOB,                        -- 책 설명
    CREATED_AT     DATE DEFAULT SYSDATE,        -- 생성일
    UPDATED_AT     DATE                         -- 수정일
);

CREATE SEQUENCE SEQ_BOOK
START WITH 1
INCREMENT BY 1
NOCACHE;