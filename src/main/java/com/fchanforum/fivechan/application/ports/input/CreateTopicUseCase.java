package com.fchanblog.fivechan.application.ports.input;

import com.fchanblog.fivechan.domain.model.Topic;


public interface CreateTopicUseCase {
    void createTopic(Topic topic);
}
