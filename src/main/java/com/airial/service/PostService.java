package com.airial.service;

import com.airial.web.domain.Post;

import java.util.List;

/**
 * Created by scambour on 15/04/14.
 */
public interface PostService {
    public List<Post> findAll();

    public Post findById(Long id);
    public Post findByTitleIgnoreCase(String title);

    public void save(Post post);
    public void destroy(Post post);
}
