package com.ramo.blog.service;

import com.ramo.blog.domain.Tag;

import java.util.List;

public interface TagService {
    Tag getTagById(Long id);
    Tag createTag(Tag tag);
    boolean deleteTag(Long id);
    Tag updateTag(Long id, Tag updatedTag);
    List<Tag> getAllTags();
}