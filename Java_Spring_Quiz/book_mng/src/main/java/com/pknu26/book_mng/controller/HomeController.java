package com.pknu26.book_mng.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/book")
    public String book() {
        logger.info("/book 실행");
        return "book";
    }
}
