package com.blog.demo.dto;

import lombok.Data;

@Data
public class PostRequest {
    private String title;
    private String content;
    private Long authorId;
    private Long categoryId;
}
