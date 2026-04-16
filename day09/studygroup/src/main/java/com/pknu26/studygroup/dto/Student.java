package com.pknu26.studygroup.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 어노테이션만 잘 작성하면 코드가 간편해진다!
@Getter // 멤버변수 getter 메서드 자동생성
@Setter // 멤버변수 setter 메서드 자동생성
@NoArgsConstructor  // 파라미터 없는 기본 생성자를 자동으로 생성해주는 어노테이션
@AllArgsConstructor // 파라미터 생성자를 자동으로 생성해주는 어노테이션
public class Student {

    private Long id;
    private String name;
    private Integer age;
    private String major;
    
}
