package com.airial.web.domain;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by scambour on 29/04/14.
 */
public class PostTest {

    private Post post;

    @Test
    @Transactional
    public void testHasTitle() {
        String javaTitle = "Java";
        post = new Post();
        post.setTitle(javaTitle);
        assertEquals(javaTitle, post.getTitle());
    }

    @Test
    @Transactional
    public void testHasNoTitle() {
        post = new Post();
        assertNull(post.getTitle());
    }

    @Test
    @Transactional
    public void testHasNoComments() {
        post = new Post();
        assertTrue(post.getComments().isEmpty());
    }

    @Test
    @Transactional
    public void testHasOneComment() {
        post = new Post();
        post.setTitle("Java");
        Comment comment = new Comment();
        comment.setText("SE 1.7");
        post.getComments().add(comment);
        assertTrue(post.getComments().size() == 1);
    }
}
