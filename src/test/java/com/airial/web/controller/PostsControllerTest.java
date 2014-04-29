package com.airial.web.controller;

import com.airial.config.ControllerTestConfig;
import com.airial.service.PostService;
import com.airial.web.domain.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.support.SimpleSessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by scambour on 29/04/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ControllerTestConfig.class})
@ActiveProfiles("test")
public class PostsControllerTest {
    private final List<Post> posts = new ArrayList<Post>();
    private PostService postService;
    private MessageSource messageSource;

    @Before
    public void initPosts() {
        Post post = new Post();
        post.setId(1L);
        post.setTitle("Example post");
        posts.add(post);
    }

    @Test
    public void shouldDisplayPostList() {
        postService = mock(PostService.class);
        when(postService.findAll()).thenReturn(posts);

        PostsController postsController = new PostsController();
        ReflectionTestUtils.setField(postsController, "postService", postService);
        ExtendedModelMap uiModel = new ExtendedModelMap();
        String result = postsController.index(uiModel);
        assertNotNull(result);
        assertEquals(result, "posts/index");

        List<Post> modelPosts = (List<Post>) uiModel.get("posts");
        assertEquals(1, modelPosts.size());
    }

    @Test
    public void shouldCreatePost() {
        final Post newPost = new Post();
        newPost.setTitle("new example Post");
        newPost.setId(999l);

        postService = mock(PostService.class);

        when(postService.save(newPost)).thenAnswer(new Answer<Post>() {
            public Post answer(InvocationOnMock invocation) throws Throwable {
                posts.add(newPost);
                return null;
            }
        });

        PostsController postsController = new PostsController();
        ReflectionTestUtils.setField(postsController, "postService", postService);
        BindingResult bindingResult = new BeanPropertyBindingResult(newPost, "post");
        SessionStatus status = new SimpleSessionStatus();
        RedirectAttributes redirectAttributes = new RedirectAttributesModelMap();

        String result = postsController.processCreationForm(newPost, bindingResult, redirectAttributes, status);
        assertNotNull(result);
        assertEquals("redirect:/posts", result);
        assertEquals(2, posts.size());
    }


}
