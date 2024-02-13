package com.ramo.blog.domain.factory;

import com.ramo.blog.domain.Post;

public interface PostFactory {
    Post createPost(String title, String content);
}
