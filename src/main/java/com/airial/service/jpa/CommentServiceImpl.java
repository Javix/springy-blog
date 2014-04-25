package com.airial.service.jpa;

import com.airial.service.CommentService;
import com.airial.web.domain.Comment;
import com.airial.web.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by scambour on 25/04/14.
 */
@Service("commentService")
@Repository
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    @Transactional(readOnly = true)
    public Comment findById(Long id) {
        return commentRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comment> findByTextIgnoreCase(String text) {
        return commentRepository.findByTextIgnoreCase(text);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void destroy(Comment comment) {
        commentRepository.delete(comment);
    }
}
