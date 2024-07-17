package com.fchanblog.fivechan.application.ports.input;

import com.fchanblog.fivechan.domain.model.Topic;

public interface EditTopicUseCase {
    void editTopic(Long id, Topic topic);
}
