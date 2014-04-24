package com.airial.service;

import com.airial.web.domain.Post;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

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
        System.out.println("Post size: " + posts.size());

        for (Post post : posts) {
            System.out.println("Post title: " + post.getTitle());
        }

        Post post = postService.findByTitleIgnoreCase("Ruby");
        System.out.println("Found post with title 'Ruby': " + post.getTitle());

        post.setTitle("Ruby-2.1");
        System.out.println("Version before: " + post.getVersion());
        postService.save(post);
        System.out.println("Version after: " + post.getVersion());
        System.out.println("Post " + post.getTitle() + " was updated");

        Post jrubyPost = new Post();
        jrubyPost.setTitle("JRuby");
        postService.save(jrubyPost);
        System.out.println("Jruby post " + jrubyPost.getTitle() + ", version: " + jrubyPost.getVersion());

        jrubyPost.setTitle("Jruby-1.7.12");
        postService.save(jrubyPost);
        System.out.println("Jruby post " + jrubyPost.getTitle() + ", version updated: " + jrubyPost.getVersion());

        ctx.close();
    }
}
