package com.ramo.blog.domain.factory;

import com.ramo.blog.domain.Tag;
import org.springframework.stereotype.Component;

@Component
public class TagFactoryImpl implements TagFactory {
    @Override
    public Tag createTag(String name) {
        Tag tag = new Tag();
        tag.setName(name);
        return tag;
    }
}
