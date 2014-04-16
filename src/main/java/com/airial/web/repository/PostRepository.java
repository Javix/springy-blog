package com.airial.web.repository;

import com.airial.web.domain.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by scambour on 15/04/14.
 */
public interface PostRepository extends CrudRepository<Post, Long> {
}
