package com.blog.demo.controller;

import com.blog.demo.dto.CommentDTO;
import com.blog.demo.dto.CommentRequest;
import com.blog.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<CommentDTO> getAllComments() {
        return commentService.getAllComments();
    }

    @PostMapping
    public CommentDTO createComment(@RequestBody CommentRequest request) {
        return commentService.createComment(request);
    }
}
