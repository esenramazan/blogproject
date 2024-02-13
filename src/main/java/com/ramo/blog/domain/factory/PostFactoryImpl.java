package com.ramo.blog.domain.factory;

import com.ramo.blog.domain.Post;
import org.springframework.stereotype.Component;

@Component
public class PostFactoryImpl implements PostFactory {
    @Override
    public Post createPost(String title, String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        // Diğer gerekli alanları ayarla
        return post;
    }
}
