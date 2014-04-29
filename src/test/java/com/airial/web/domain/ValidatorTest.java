package com.airial.web.domain;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by scambour on 29/04/14.
 */
public class ValidatorTest {

    private Validator createValidator() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.afterPropertiesSet();
        return localValidatorFactoryBean;
    }

    @Test
    public void emptyPostTitle() {
        Post post = new Post();
        post.setTitle("");

        Validator validator = createValidator();
        Set<ConstraintViolation<Post>> constraintViolations = validator.validate(post);
        Assert.assertEquals(1, constraintViolations.size());

        ConstraintViolation<Post> violation =  constraintViolations.iterator().next();
        Assert.assertEquals(violation.getPropertyPath().toString(), "title");
        Assert.assertEquals(violation.getMessage(), "Title should not be empty");
    }

    @Test
    public void emptyCommentText() {
        Comment comment = new Comment();
        comment.setText("");

        Validator validator = createValidator();
        Set<ConstraintViolation<Comment>> constraintViolations = validator.validate(comment);
        Assert.assertEquals(1, constraintViolations.size());

        ConstraintViolation<Comment> violation =  constraintViolations.iterator().next();
        Assert.assertEquals(violation.getPropertyPath().toString(), "text");
        Assert.assertEquals(violation.getMessage(), "Text should not be empty");
    }
}
