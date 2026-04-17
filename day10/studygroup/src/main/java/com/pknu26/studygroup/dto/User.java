package com.pknu26.studygroup.dto;

import java.time.LocalDateTime;

import lombok.Data;


/**
 *  USER_ID      NUMBER         PRIMARY KEY,
    LOGIN_ID     VARCHAR2(50)   NOT NULL UNIQUE,
    PASSWORD     VARCHAR2(255)  NOT NULL,
    NAME         VARCHAR2(100)  NOT NULL,
    ROLE         VARCHAR2(30)   DEFAULT 'ROLE_USER' NOT NULL,
    CREATED_AT   DATE           DEFAULT SYSDATE NOT NULL,
    UPDATED_AT   DATE
*/
@Data
public class User {

    private Long userId;
    private String loginId;
    private String password;
    private String name;
    private String role;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
