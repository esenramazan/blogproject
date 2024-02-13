package com.ramo.blog.controller;

import com.ramo.blog.domain.Tag;
import com.ramo.blog.service.TagService;
import com.ramo.blog.util.GenericResponse;
import com.ramo.blog.util.factory.GenericResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/tags")
public class TagController extends GenericController {

    private final TagService tagService;
    private final GenericResponseFactory<Tag> genericResponseFactory;
    private final GenericResponseFactory<List<Tag>> genericResponseListFactory;

    private final GenericResponseFactory<String> stringGenericResponseFactory;

    @Autowired
    public TagController(TagService tagService, GenericResponseFactory<Tag> genericResponseFactory, GenericResponseFactory<List<Tag>> genericResponseListFactory, GenericResponseFactory<String> stringGenericResponseFactory) {
        this.tagService = tagService;
        this.genericResponseFactory = genericResponseFactory;
        this.genericResponseListFactory = genericResponseListFactory;
        this.stringGenericResponseFactory = stringGenericResponseFactory;
    }

    @GetMapping
    public GenericResponse<List<Tag>> getAllTags() {

        try {
            return genericResponseListFactory.createSuccessResponse(tagService.getAllTags());
        } catch (Exception e) {
            return genericResponseListFactory.createErrorResponse(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public GenericResponse<Tag> getTagById(@PathVariable Long id) {

        try {
            return genericResponseFactory.createSuccessResponse(tagService.getTagById(id));
        } catch (Exception e) {
            return genericResponseFactory.createErrorResponse(e.getMessage());
        }


    }

    @PostMapping
    public GenericResponse<Tag> createTag(@RequestBody Tag tag) {

        try {
            return genericResponseFactory.createSuccessResponse(tagService.createTag(tag));
        } catch (Exception e) {
            return genericResponseFactory.createErrorResponse(e.getMessage());
        }


    }

    @PutMapping("/{id}")
    public GenericResponse<Tag> updateTag(@PathVariable Long id, @RequestBody Tag tag) {
        try {
            return genericResponseFactory.createSuccessResponse(tagService.updateTag(id, tag));
        } catch (Exception e) {
            return genericResponseFactory.createErrorResponse(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteTag(@PathVariable Long id) {

        try {
            boolean deleted = tagService.deleteTag(id);
            if (deleted) {
                return null;
            } else {
                return null;
            }
        } catch (Exception e) {
            return stringGenericResponseFactory.createErrorResponse(e.getMessage());
        }


    }
}
