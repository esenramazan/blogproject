package com.ramo.blog.service;

import com.ramo.blog.domain.Post;

import java.util.List;

public interface PostService {
    Post getPostById(Long id);
    Post createPost(Post post);

    Post updatePost(Long id, Post updatedPost);

    boolean deletePost(Long id);

    List<Post> getAllPosts();
    List<Post> getSearchPosts(String searchText);
}
