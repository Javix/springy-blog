package com.airial.web.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by scambour on 24/04/14.
 */
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    @NotEmpty(message = "Text should not be empty")
    private String text;

    private int version;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Version
    @Column(name = "version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * Used as a flag to check if it is a new record in the views
     *
     * @return true if it is a new record, false otherwise
     */
    public boolean isNew() {
        return (this.id == null);
    }

    @Override
    public String toString() {
        ToStringCreator stringCreator = new ToStringCreator(this);
        stringCreator.append("id", getId());
        stringCreator.append("text", getText());
        stringCreator.append("post", getPost());
        return stringCreator.toString();
    }
}
