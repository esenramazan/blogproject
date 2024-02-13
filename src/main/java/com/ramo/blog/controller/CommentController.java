package com.ramo.blog.controller;

import com.ramo.blog.domain.Comment;
import com.ramo.blog.service.CommentService;
import com.ramo.blog.util.GenericResponse;
import com.ramo.blog.util.factory.GenericResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/comments")
public class CommentController extends GenericController {

    private final CommentService commentService;
    private final GenericResponseFactory<Comment> genericResponseFactory;
    private final GenericResponseFactory<List<Comment>> genericResponseListFactory;

    private final GenericResponseFactory<String> stringGenericResponseFactory;

    @Autowired
    public CommentController(CommentService commentService, GenericResponseFactory<Comment> genericResponseFactory, GenericResponseFactory<List<Comment>> genericResponseListFactory, GenericResponseFactory<String> stringGenericResponseFactory) {
        this.commentService = commentService;
        this.genericResponseFactory = genericResponseFactory;
        this.genericResponseListFactory = genericResponseListFactory;
        this.stringGenericResponseFactory = stringGenericResponseFactory;
    }

    @GetMapping
    public GenericResponse<List<Comment>> getAllComments() {
        try {
            ApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
            applicationContext.getAutowireCapableBeanFactory();
            List<Comment> comments = commentService.getAllComments();
            return genericResponseListFactory.createSuccessResponse(comments);
        } catch (Exception e) {
            return genericResponseListFactory.createErrorResponse(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public GenericResponse<Comment> getCommentById(@PathVariable Long id) {
        try {
            return genericResponseFactory.createSuccessResponse(commentService.getCommentById(id));
        } catch (Exception e) {
            return genericResponseFactory.createErrorResponse(e.getMessage());
        }

    }

    @PostMapping
    public GenericResponse<Comment> createComment(@RequestBody Comment comment) {
        try {
            return genericResponseFactory.createSuccessResponse(commentService.createComment(comment));
        } catch (Exception e) {
            return genericResponseFactory.createErrorResponse(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public GenericResponse<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment) {

        try {
            return genericResponseFactory.createSuccessResponse(commentService.updateComment(id, comment));
        } catch (Exception e) {
            return genericResponseFactory.createErrorResponse(e.getMessage());
        }


    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteComment(@PathVariable Long id) {

        try {

            boolean deleted = commentService.deleteComment(id);
            if (deleted) {
                return stringGenericResponseFactory.createSuccessResponse("Deleted Id:" + id);
            } else {
                return stringGenericResponseFactory.createErrorResponse("UnDeleted Id:" + id);
            }

        } catch (Exception e) {
            return stringGenericResponseFactory.createErrorResponse(e.getMessage());
        }


    }
}
