package com.fchanblog.fivechan.application.ports.output;

import com.fchanblog.fivechan.domain.model.*;

public interface TopicRepository {
    void save(Topic topic);
    Topic findById(Long id);
    void deleteById(Long id);
    void save(Comment comment);
    Comment findCommentById(Long id);
    void deleteCommentById(Long id);
}
