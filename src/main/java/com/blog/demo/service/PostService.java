package com.blog.demo.service;

import com.blog.demo.domain.Post;
import com.blog.demo.dto.PostDTO;
import com.blog.demo.dto.PostRequest;
import com.blog.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<PostDTO> getAllPosts() {
        return postRepository.findAll().stream()
                .map(post -> {
                    PostDTO dto = new PostDTO();
                    dto.setId(post.getId());
                    dto.setTitle(post.getTitle());
                    dto.setContent(post.getContent());
                    dto.setAuthorId(post.getAuthor().getId());
                    dto.setCategoryId(post.getCategory().getId());
                    return dto;
                }).collect(Collectors.toList());
    }

    public PostDTO createPost(PostRequest request) {
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        // Map Author and Category
        post = postRepository.save(post);

        PostDTO dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setAuthorId(post.getAuthor().getId());
        dto.setCategoryId(post.getCategory().getId());
        return dto;
    }
}
