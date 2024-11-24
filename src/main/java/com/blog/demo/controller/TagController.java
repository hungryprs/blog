package com.blog.demo.controller;

import com.blog.demo.dto.TagDTO;
import com.blog.demo.dto.TagRequest;
import com.blog.demo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public List<TagDTO> getAllTags() {
        return tagService.getAllTags();
    }

    @PostMapping
    public TagDTO createTag(@RequestBody TagRequest request) {
        return tagService.createTag(request);
    }
}
