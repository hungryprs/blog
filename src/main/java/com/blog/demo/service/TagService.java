package com.blog.demo.service;

import com.blog.demo.domain.Tag;
import com.blog.demo.dto.TagDTO;
import com.blog.demo.dto.TagRequest;
import com.blog.demo.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<TagDTO> getAllTags() {
        return tagRepository.findAll().stream()
                .map(tag -> {
                    TagDTO dto = new TagDTO();
                    dto.setId(tag.getId());
                    dto.setName(tag.getName());
                    return dto;
                }).collect(Collectors.toList());
    }

    public TagDTO createTag(TagRequest request) {
        Tag tag = new Tag();
        tag.setName(request.getName());
        tag = tagRepository.save(tag);

        TagDTO dto = new TagDTO();
        dto.setId(tag.getId());
        dto.setName(tag.getName());
        return dto;
    }
}
