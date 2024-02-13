package com.ramo.blog.service;

import com.ramo.blog.domain.Comment;

import java.util.List;

public interface CommentService {
    Comment getCommentById(Long id);
    Comment createComment(Comment comment);
    boolean deleteComment(Long id);
    Comment updateComment(Long id, Comment updatedComment);
    List<Comment> getAllComments();
}
