CREATE TABLE PRODUCT (
    PRODUCT_ID     NUMBER PRIMARY KEY,           -- 상품 고유 ID (PK)
    PRODUCT_NAME   VARCHAR2(200) NOT NULL,       -- 상품명
    CATEGORY       VARCHAR2(100),                -- 카테고리
    PRICE          NUMBER(10, 2) NOT NULL,       -- 가격
    STOCK          NUMBER DEFAULT 0,             -- 재고 수량
    BRAND          VARCHAR2(100),                -- 브랜드
    MANUFACTURER   VARCHAR2(200),                -- 제조사
    DESCRIPTION    CLOB,                         -- 상품 설명
    IMAGE_URL      VARCHAR2(500),                -- 이미지 경로
    STATUS         VARCHAR2(20) DEFAULT 'SALE',  -- 상태 (SALE, SOLDOUT, SHIPPED, PAID, DONE  등)
    CREATED_AT     DATE DEFAULT SYSDATE,         -- 생성일
    UPDATED_AT     DATE                          -- 수정일
);

CREATE SEQUENCE SEQ_PRODUCT
START WITH 1
INCREMENT BY 1
NOCACHE;