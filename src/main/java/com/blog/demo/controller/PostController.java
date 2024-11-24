package com.blog.demo.controller;

import com.blog.demo.dto.PostDTO;
import com.blog.demo.dto.PostRequest;
import com.blog.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping
    public PostDTO createPost(@RequestBody PostRequest request) {
        return postService.createPost(request);
    }
}
