package com.ramo.blog.service;

import com.ramo.blog.domain.Tag;
import com.ramo.blog.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag getTagById(Long id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag updateTag(Long id, Tag updatedTag) {
        Optional<Tag> existingTag = tagRepository.findById(id);
        if (existingTag.isPresent()) {
            Tag tag = existingTag.get();
            return tagRepository.save(tag);
        }
        return null;
    }

    @Override
    public boolean deleteTag(Long id) {
        Optional<Tag> existingTag = tagRepository.findById(id);
        if (existingTag.isPresent()) {
            tagRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }
}
