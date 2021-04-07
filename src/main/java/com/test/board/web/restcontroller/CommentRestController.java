package com.test.board.web.restcontroller;

import com.test.board.entity.CommentEntity;
import com.test.board.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/boards/{boardId}/comments")
public class CommentRestController {

    private final CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("")
    public List<CommentEntity> getCommentList(@PathVariable Integer boardId) {
        return commentService.getCommentList(boardId);
    }

    @PostMapping("")
    public Object createComment(@RequestBody CommentEntity commentEntity) {
        return commentService.createComment(commentEntity);
    }

    @GetMapping("/{commentId}")
    public CommentEntity getComment(@PathVariable Integer commentId) {
        return commentService.getComment(commentId);
    }

    @PutMapping("/{commentId}")
    public CommentEntity updateComment(@PathVariable Integer commentId, @RequestBody CommentEntity commentEntity) {
        return commentService.updateComment(commentId, commentEntity);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Integer commentId) {
        commentService.deleteComment(commentId);
    }

}
