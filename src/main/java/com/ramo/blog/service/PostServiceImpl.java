package com.ramo.blog.service;

import com.ramo.blog.domain.Post;
import com.ramo.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }
    @Override
    public Post updatePost(Long id, Post updatedPost) {
        Optional<Post> existingPost = postRepository.findById(id);
        if (existingPost.isPresent()) {
            Post post = existingPost.get();
            return postRepository.save(post);
        }
        return null;
    }
    @Override
    public boolean deletePost(Long id) {
        Optional<Post> existingPost = postRepository.findById(id);
        if (existingPost.isPresent()) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Post> getAllPosts() {

        List<Post> postList = postRepository.findAll();

        postList.forEach(p -> p.setContentSummary(p.getContent().length() > 50 ? p.getContent().substring(0, 50) : p.getContent()));

        return postList;
    }

    public List<Post> getSearchPosts(String searchText) {

        List<Post> postList = postRepository.findAll();
        List<Post> searchedList = new ArrayList<>();


        for(Post p : postList) {
            if(p.getContent().contains(searchText)) {
                p.setContentSummary(p.getContent().length() > 500 ? p.getContentSummary().substring(0, 500) : p.getContent());
                searchedList.add(p);
            }
        }

        return searchedList;
    }

}
