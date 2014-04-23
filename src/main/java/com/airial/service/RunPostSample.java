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
        ctx.close();
    }
}
