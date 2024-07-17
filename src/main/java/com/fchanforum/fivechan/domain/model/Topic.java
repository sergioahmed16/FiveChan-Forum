package com.fchanblog.fivechan.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private Long id;
    private String title;
    private String content;
    private boolean censored;
    private List<Comment> comments;

    public Topic(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.censored = false;
        this.comments = new ArrayList<>();
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCensored() {
        return censored;
    }

    public void setCensored(boolean censored) {
        this.censored = censored;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }
}
