package com.airial.web.controller;

import com.airial.service.CommentService;
import com.airial.service.PostService;
import com.airial.web.domain.Comment;
import com.airial.web.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by scambour on 25/04/14.
 */
@Controller
@RequestMapping("/posts/{post_id}/comments")
public class CommentsController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String initCreationForm(Map<String, Object> model) {
        Comment comment = new Comment();
        model.put("comment", comment);
        return "comments/form";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String processCreationForm(@PathVariable Long post_id, @Valid Comment comment, BindingResult result, RedirectAttributes redirectAttributes,
                                      SessionStatus status) {

        Post post = postService.findById(post_id);
        comment.setPost(post);

        if (result.hasErrors()) {
            return "comments/form";
        } else {
            redirectAttributes.addFlashAttribute("message", "Comment created successfully !");
            commentService.save(comment);
            status.setComplete();
            return "redirect:/posts/{post_id}";
        }
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String initUpdateForm(@PathVariable Long id, Model model) {
        Comment comment = commentService.findById(id);
        model.addAttribute(comment);
        model.addAttribute(comment.getPost());
        return "comments/form";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
    public String processUpdateForm(@PathVariable Long post_id, @Valid Comment comment, BindingResult result, RedirectAttributes redirectAttributes,
                                    SessionStatus status) {
        Post post = postService.findById(post_id);
        comment.setPost(post);
        if (result.hasErrors()) {
            return "comments/form";
        } else {
            redirectAttributes.addFlashAttribute("message", "Comment updated successfully !");
            commentService.save(comment);
            status.setComplete();

            return "redirect:/posts/{post_id}";
        }
    }
}
