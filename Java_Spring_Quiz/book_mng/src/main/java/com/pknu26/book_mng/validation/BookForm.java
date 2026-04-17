package com.pknu26.book_mng.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookForm {

    @Size(max = 300)
    @NotBlank(message = "제목을 작성하세요.")
    private String title;

    @Size(max = 200)
    @NotBlank(message = "작가를 작성하세요.")
    private String author;

    @Size(max = 200)
    @NotBlank(message = "출판사를 작성하세요.")
    private String publisher;

    @Size(max = 20)
    @NotBlank(message ="ISBN을 입력하세요.")
    private String isbn;

    @Size (max = 100)
    @NotBlank(message = "카테고리를 입력하세요.")
    private String category;

    @NotNull(message = "가격을 입력하세요.")
    private Integer price;

    @NotNull(message = "수량을 입력하세요.")
    private Integer stock;

    @NotBlank(message = "설명문을 입력하세요")
    private String description;
}
