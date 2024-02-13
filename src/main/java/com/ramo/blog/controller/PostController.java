package com.ramo.blog.controller;

import com.ramo.blog.domain.Post;
import com.ramo.blog.service.PostService;
import com.ramo.blog.util.GenericResponse;
import com.ramo.blog.util.factory.GenericResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/posts")
public class PostController extends GenericController {
    private final PostService postService;
    private final GenericResponseFactory<Post> genericResponseFactory;
    private final GenericResponseFactory<List<Post>> genericResponseListFactory;
    private final GenericResponseFactory<String> stringGenericResponseFactory;

    @Autowired
    public PostController(PostService postService, GenericResponseFactory<Post> genericResponseFactory, GenericResponseFactory<List<Post>> genericResponseListFactory, GenericResponseFactory<String> stringGenericResponseFactory) {
        this.postService = postService;
        this.genericResponseFactory = genericResponseFactory;
        this.genericResponseListFactory = genericResponseListFactory;
        this.stringGenericResponseFactory = stringGenericResponseFactory;
    }

    @GetMapping("/allPosts")
    public GenericResponse<List<Post>> getAllPosts() {

        try {
            return genericResponseListFactory.createSuccessResponse(postService.getAllPosts());
        } catch (Exception e) {
            return genericResponseListFactory.createErrorResponse(e.getMessage());
        }

    }


    @GetMapping("/searchPosts")
    public GenericResponse<List<Post>> getSearchPosts(String searchText) {
        try {
            return genericResponseListFactory.createSuccessResponse(postService.getSearchPosts(searchText));
        } catch (Exception e) {
            return genericResponseListFactory.createErrorResponse(e.getMessage());
        }

    }

    @GetMapping("/getPostById/{id}")
    public GenericResponse<Post> getPostById(@PathVariable Long id) {
        try {

        } catch (Exception e) {
            return genericResponseFactory.createErrorResponse(e.getMessage());
        }
        return genericResponseFactory.createSuccessResponse(postService.getPostById(id));
    }

    @PostMapping("createPost")
    public GenericResponse<Post> createPost(@RequestBody Post post) {
        try {
            return genericResponseFactory.createSuccessResponse(postService.createPost(post));
        } catch (Exception e) {
            return genericResponseFactory.createErrorResponse(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public GenericResponse<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        try {
            return genericResponseFactory.createSuccessResponse(postService.updatePost(id, post));
        } catch (Exception e) {
            return genericResponseFactory.createErrorResponse(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> deletePost(@PathVariable Long id) {
        try {

            boolean deleted = postService.deletePost(id);
            if (deleted) {
                return stringGenericResponseFactory.createSuccessResponse("Deleted Id:" + id);
            } else {
                return stringGenericResponseFactory.createErrorResponse("!!!Unkown Deleted Condition Id:" + id);
            }

        } catch (Exception e) {
            return stringGenericResponseFactory.createErrorResponse(e.getMessage());
        }


    }
}
