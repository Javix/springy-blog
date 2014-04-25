package com.airial.service;

import com.airial.web.domain.Comment;
import com.airial.web.domain.Post;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Set;

/**
 * Created by scambour on 15/04/14.
 */
public class RunPostSample {
    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:jpa-app-context.xml");
        ctx.refresh();

        System.out.println("App context initialized successfully");
        PostService postService = ctx.getBean("postService", PostService.class);
        List<Post> posts = postService.findAll();
        System.out.println("Total Posts found: " + posts.size());
        System.out.println("----------------------------------------------");

        for (Post post : posts) {
            System.out.println("Post id: " + post.getId() + ": " + post.getTitle());
        }

        //Update an existing Post
        Post post = postService.findByTitleIgnoreCase("Ruby");
        System.out.println("Found post with title 'Ruby': " + post.getTitle());

        post.setTitle("Ruby-2.1");
        postService.save(post);
        System.out.println("Post " + post.getTitle() + " was updated");

        //Create a new Post
        Post jRubyPost = new Post();
        jRubyPost.setTitle("JRuby");
        postService.save(jRubyPost);
        System.out.println("Created a new Post with id: " + jRubyPost.getId() + ": " + jRubyPost.getTitle());

        //Display Post comments
        Post postWithComments = postService.findById(Long.valueOf(1));
        Set<Comment> comments = postWithComments.getComments();
        System.out.println("Post " + postWithComments.getTitle() + " has " + comments.size() + " comments");
        for (Comment comment : comments) {
            System.out.println("Comment text: " + comment.getText() + " for Post: " + comment.getPost().getTitle());
        }

        //Update a comment
        CommentService commentService = ctx.getBean("commentService", CommentService.class);
        Comment cmt = (Comment) comments.toArray()[0];
        cmt.setText("Modified");
        commentService.save(cmt);
        System.out.println("Comment " + cmt.getText() + " for post "
                + cmt.getPost().getTitle() + " was updated with success.");

        ctx.close();
    }
}
