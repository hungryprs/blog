package com.blog.demo.dto;

import lombok.Data;

@Data
public class CommentRequest {
    private String content;
    private Long postId;
    private Long authorId;
}

