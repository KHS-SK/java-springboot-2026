package com.pknu26.book_mng.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/* 
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
*/

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(
    name = "book_seq",
    sequenceName = "book_seq",
    allocationSize = 1)
    
    private Long bookId;

    @Column(length = 300, nullable = false)
    private String title;

    @Column(length = 200)
    private String author;

    @Column(length = 200)
    private String publisher;

    @Column(length = 20, unique = true)
    private String isbn;

    @Column(length = 100)
    private String category;

    @Column
    private Integer price;

    @Column
    private Integer stock = 0;

    @Column
    private LocalDateTime publishedDate;

    @Lob
    @Column
    private String description;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedBy
    private LocalDateTime updatedAt;

}
