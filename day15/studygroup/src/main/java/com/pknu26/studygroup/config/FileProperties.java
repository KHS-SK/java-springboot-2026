package com.pknu26.studygroup.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class FileProperties {

    @Value("${file.upload-dir}")
    private String uploadDir;   // D:/uploadd/studygroup

    @Value("${file.access-url}")
    private String accessUrl;   // /upload/site
}
