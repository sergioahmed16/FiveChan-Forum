package com.fchanblog.fivechan.application.ports.input;

import com.fchanblog.fivechan.domain.model.Comment;

public interface EditCommentUseCase {
    void editComment(Long id, Comment comment);
}
