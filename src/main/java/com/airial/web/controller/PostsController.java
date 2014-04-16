package com.airial.web.controller;

import com.airial.service.PostService;
import com.airial.web.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by scambour on 15/04/14.
 */
@Controller
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model uiModel) {

        List<Post> posts = postService.findAll();
        uiModel.addAttribute("posts", posts);

        return "posts/index";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Long id, Model uiModel) {
        Post post = postService.findById(id);
        uiModel.addAttribute("post", post);
        return "posts/show";
    }
}

