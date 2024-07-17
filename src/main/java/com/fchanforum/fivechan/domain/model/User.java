package com.fchanblog.fivechan.domain.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Long id;
    private String username;
    private boolean suspended;
    private boolean banned;
    private List<String> warnings;

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
        this.suspended = false;
        this.banned = false;
        this.warnings = new ArrayList<>();
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    public void addWarning() {
        this.warnings.add("Warning issued at " + System.currentTimeMillis());
    }
}
