package com.blog.demo.service;

import com.blog.demo.domain.Comment;
import com.blog.demo.dto.CommentDTO;
import com.blog.demo.dto.CommentRequest;
import com.blog.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<CommentDTO> getAllComments() {
        return commentRepository.findAll().stream()
                .map(comment -> {
                    CommentDTO dto = new CommentDTO();
                    dto.setId(comment.getId());
                    dto.setContent(comment.getContent());
                    dto.setPostId(comment.getPost().getId());
                    dto.setAuthorId(comment.getAuthor().getId());
                    return dto;
                }).collect(Collectors.toList());
    }

    public CommentDTO createComment(CommentRequest request) {
        Comment comment = new Comment();
        comment.setContent(request.getContent());
        // Map Post and Author based on IDs
        // Ensure post and author exist in their respective repositories
        comment = commentRepository.save(comment);

        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setContent(comment.getContent());
        dto.setPostId(comment.getPost().getId());
        dto.setAuthorId(comment.getAuthor().getId());
        return dto;
    }
}
