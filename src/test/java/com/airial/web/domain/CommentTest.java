package com.airial.web.domain;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by scambour on 29/04/14.
 */
public class CommentTest {

    private Comment comment;

    @Test
    @Transactional
    public void testHasText() {
        String text = "Java SE";
        comment = new Comment();
        comment.setText(text);
        assertEquals(text, comment.getText());
    }

    @Test
    @Transactional
    public void testHasNoTitle() {
        comment = new Comment();
        assertNull(comment.getText());
    }

    @Test
    @Transactional
    public void testHasNoPost() {
        comment = new Comment();
        comment.setText("Much more difficult");
        assertNull(comment.getPost());
    }

    @Test
    @Transactional
    public void testHasPost() {
        Post post = new Post();
        post.setTitle("Java EE");
        comment = new Comment();
        comment.setText("Much more difficult");
        comment.setPost(post);
        assertNotNull(comment.getPost());
    }
}
