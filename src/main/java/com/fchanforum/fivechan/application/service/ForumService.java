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
        saveTopic(topic);
    }

    @Override
    public void editTopic(Long id, Topic topic) {
        Topic existingTopic = findTopicById(id);
        updateTopic(existingTopic, topic);
        saveTopic(existingTopic);
    }

    @Override
    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }

    @Override
    public void commentOnTopic(Long topicId, Comment comment) {
        Topic topic = findTopicById(topicId);
        topic.addComment(comment);
        saveTopic(topic);
    }

    @Override
    public void editComment(Long id, Comment comment) {
        Comment existingComment = findCommentById(id);
        updateComment(existingComment, comment);
        saveComment(existingComment);
    }

    @Override
    public void deleteComment(Long id) {
        topicRepository.deleteCommentById(id);
    }

    @Override
    public void censorTopic(Long id) {
        Topic topic = findTopicById(id);
        topic.setCensored(true);
        saveTopic(topic);
    }

    @Override
    public void warnUser(Long userId) {
        User user = findUserById(userId);
        user.addWarning();
        saveUser(user);
    }

    @Override
    public void suspendUser(Long userId) {
        User user = findUserById(userId);
        user.setSuspended(true);
        saveUser(user);
    }

    @Override
    public void banUser(Long userId) {
        User user = findUserById(userId);
        user.setBanned(true);
        saveUser(user);
    }

    // Helper Methods

    private void saveTopic(Topic topic) {
        topicRepository.save(topic);
    }

    private Topic findTopicById(Long id) {
        return topicRepository.findById(id);
    }

    private void updateTopic(Topic existingTopic, Topic newTopicData) {
        // Update existing topic fields with new values
        existingTopic.setTitle(newTopicData.getTitle());
        existingTopic.setContent(newTopicData.getContent());
    }

    private Comment findCommentById(Long id) {
        return topicRepository.findCommentById(id);
    }

    private void updateComment(Comment existingComment, Comment newCommentData) {
        // Update existing comment fields with new values
        existingComment.setContent(newCommentData.getContent());
    }

    private void saveComment(Comment comment) {
        topicRepository.save(comment);
    }

    private User findUserById(Long userId) {
        return userRepository.findById(userId);
    }

    private void saveUser(User user) {
        userRepository.save(user);
    }
}
