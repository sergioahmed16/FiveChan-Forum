package com.fchanblog.fivechan.infrastructure.adapters.input;

import com.fchanblog.fivechan.application.ports.input.*;
import com.fchanblog.fivechan.domain.model.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/forum")
public class ForumController {

    private final CreateTopicUseCase createTopicUseCase;
    private final EditTopicUseCase editTopicUseCase;
    private final DeleteTopicUseCase deleteTopicUseCase;
    private final CommentOnTopicUseCase commentOnTopicUseCase;
    private final EditCommentUseCase editCommentUseCase;
    private final DeleteCommentUseCase deleteCommentUseCase;
    private final CensorTopicUseCase censorTopicUseCase;
    private final WarnUserUseCase warnUserUseCase;
    private final SuspendUserUseCase suspendUserUseCase;
    private final BanUserUseCase banUserUseCase;

    public ForumController(CreateTopicUseCase createTopicUseCase, EditTopicUseCase editTopicUseCase,
                           DeleteTopicUseCase deleteTopicUseCase, CommentOnTopicUseCase commentOnTopicUseCase,
                           EditCommentUseCase editCommentUseCase, DeleteCommentUseCase deleteCommentUseCase,
                           CensorTopicUseCase censorTopicUseCase, WarnUserUseCase warnUserUseCase,
                           SuspendUserUseCase suspendUserUseCase, BanUserUseCase banUserUseCase) {
        this.createTopicUseCase = createTopicUseCase;
        this.editTopicUseCase = editTopicUseCase;
        this.deleteTopicUseCase = deleteTopicUseCase;
        this.commentOnTopicUseCase = commentOnTopicUseCase;
        this.editCommentUseCase = editCommentUseCase;
        this.deleteCommentUseCase = deleteCommentUseCase;
        this.censorTopicUseCase = censorTopicUseCase;
        this.warnUserUseCase = warnUserUseCase;
        this.suspendUserUseCase = suspendUserUseCase;
        this.banUserUseCase = banUserUseCase;
    }

    @PostMapping("/topics")
    public void createTopic(@RequestBody Topic topic) {
        createTopicUseCase.createTopic(topic);
    }

    @PutMapping("/topics/{id}")
    public void editTopic(@PathVariable Long id, @RequestBody Topic topic) {
        editTopicUseCase.editTopic(id, topic);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable Long id) {
        deleteTopicUseCase.deleteTopic(id);
    }

    @PostMapping("/topics/{id}/comments")
    public void commentOnTopic(@PathVariable Long id, @RequestBody Comment comment) {
        commentOnTopicUseCase.commentOnTopic(id, comment);
    }

    @PutMapping("/comments/{id}")
    public void editComment(@PathVariable Long id, @RequestBody Comment comment) {
        editCommentUseCase.editComment(id, comment);
    }

    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable Long id) {
        deleteCommentUseCase.deleteComment(id);
    }

    @PostMapping("/topics/{id}/censor")
    public void censorTopic(@PathVariable Long id) {
        censorTopicUseCase.censorTopic(id);
    }

    @PostMapping("/users/{id}/warn")
    public void warnUser(@PathVariable Long id) {
        warnUserUseCase.warnUser(id);
    }

    @PostMapping("/users/{id}/suspend")
    public void suspendUser(@PathVariable Long id) {
        suspendUserUseCase.suspendUser(id);
    }

    @PostMapping("/users/{id}/ban")
    public void banUser(@PathVariable Long id) {
        banUserUseCase.banUser(id);
    }
}
