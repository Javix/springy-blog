package com.airial.web.controller;

import com.airial.service.PostService;
import com.airial.web.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String initCreationForm(Map<String, Object> model) {
        Post post = new Post();
        model.put("post", post);
        return "posts/form";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String processCreationForm(Post post, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "posts/form";
        } else {
            postService.save(post);
            status.setComplete();
            return "redirect:/posts";
        }
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String initUpdateForm(@PathVariable Long id, Model model) {
        Post post = postService.findById(id);
        model.addAttribute(post);
        return "posts/form";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public String processUpdateForm(Post post, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "posts/form";
        } else {
            postService.save(post);
            status.setComplete();
            return "redirect:/posts";
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String destroy(@PathVariable Long id) {
        Post post = postService.findById(id);
        postService.destroy(post);
        return "redirect:/posts";
    }
}

