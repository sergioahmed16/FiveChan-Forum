package com.fchanblog.fivechan.application.ports.input;

import com.fchanblog.fivechan.domain.model.Comment;

public interface CommentOnTopicUseCase {
    void commentOnTopic(Long topicId, Comment comment);
}
