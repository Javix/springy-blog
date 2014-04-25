package com.airial.service;

import com.airial.web.domain.Comment;

import java.util.List;

/**
 * Created by scambour on 25/04/14.
 */
public interface CommentService {

    public Comment findById(Long id);

    public List<Comment> findByTextIgnoreCase(String text);

    public void save(Comment comment);

    public void destroy(Comment comment);
}
