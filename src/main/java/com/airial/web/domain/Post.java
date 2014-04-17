package com.airial.web.domain;

import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by scambour on 15/04/14.
 */
@Entity
@Table(name = "posts")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    /*@Version
    @Column(name = "version")
    private int version;*/

    @Column(name = "title")
    private String title;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


   /* public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }*/


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return new ToStringCreator(this).append("id", getId()).append("title", getTitle()).toString();
    }
}
