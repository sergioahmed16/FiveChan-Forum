package com.fchanblog.fivechan.application.service;

import com.fchanblog.fivechan.application.ports.input.*;
import com.fchanblog.fivechan.application.ports.output.*;
import com.fchanblog.fivechan.domain.model.*;

public class ForumService implements CreateTopicUseCase, EditTopicUseCase, DeleteTopicUseCase,
        CommentOnTopicUseCase, EditCommentUseCase, DeleteCommentUseCase,
        CensorTopicUseCase, WarnUserUseCase, SuspendUserUseCase, BanUserUseCase {

    private final TopicRepository topicRepository;
    private final UserRepository userRepository;

    public ForumService(TopicRepository topicRepository, UserRepository userRepository) {
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createTopic(Topic topic) {
        topicRepository.save(topic);
    }

    @Override
    public void editTopic(Long id, Topic topic) {
        Topic existingTopic = topicRepository.findById(id);
        // Update existing topic fields with new values
        topicRepository.save(existingTopic);
    }

    @Override
    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }

    @Override
    public void commentOnTopic(Long topicId, Comment comment) {
        Topic topic = topicRepository.findById(topicId);
        topic.addComment(comment);
        topicRepository.save(topic);
    }

    @Override
    public void editComment(Long id, Comment comment) {
        Comment existingComment = topicRepository.findCommentById(id);
        // Update existing comment fields with new values
        topicRepository.save(existingComment);
    }

    @Override
    public void deleteComment(Long id) {
        topicRepository.deleteCommentById(id);
    }

    @Override
    public void censorTopic(Long id) {
        Topic topic = topicRepository.findById(id);
        topic.setCensored(true);
        topicRepository.save(topic);
    }

    @Override
    public void warnUser(Long userId) {
        User user = userRepository.findById(userId);
        user.addWarning();
        userRepository.save(user);
    }

    @Override
    public void suspendUser(Long userId) {
        User user = userRepository.findById(userId);
        user.setSuspended(true);
        userRepository.save(user);
    }

    @Override
    public void banUser(Long userId) {
        User user = userRepository.findById(userId);
        user.setBanned(true);
        userRepository.save(user);
    }
}
