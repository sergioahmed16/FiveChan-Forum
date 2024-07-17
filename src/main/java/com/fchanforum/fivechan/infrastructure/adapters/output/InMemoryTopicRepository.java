package com.fchanblog.fivechan.infrastructure.adapters.output;

import com.fchanblog.fivechan.application.ports.output.*;
import com.fchanblog.fivechan.domain.model.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryTopicRepository implements TopicRepository {
    private final Map<Long, Topic> topics = new HashMap<>();
    private final Map<Long, Comment> comments = new HashMap<>();

    @Override
    public void save(Topic topic) {
        topics.put(topic.getId(), topic);
    }

    @Override
    public Topic findById(Long id) {
        return topics.get(id);
    }

    @Override
    public void deleteById(Long id) {
        topics.remove(id);
    }

    @Override
    public void save(Comment comment) {
        comments.put(comment.getId(), comment);
    }

    @Override
    public Comment findCommentById(Long id) {
        return comments.get(id);
    }

    @Override
    public void deleteCommentById(Long id) {
        comments.remove(id);
    }
}
