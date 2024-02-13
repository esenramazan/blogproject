package com.ramo.blog.domain.factory;

import com.ramo.blog.domain.Comment;

public interface CommentFactory {
    Comment createComment(String content);
}
