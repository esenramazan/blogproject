package com.ramo.blog.domain.factory;

import com.ramo.blog.domain.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentFactoryImpl implements CommentFactory {
    @Override
    public Comment createComment(String content) {
        Comment comment = new Comment();
        comment.setContent(content);
        return comment;
    }
}
