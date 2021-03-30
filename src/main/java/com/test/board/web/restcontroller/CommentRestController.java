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
        System.out.println(boardId);
        return commentService.getCommentList(boardId); //"board/comments";
    }

    @PostMapping("")
    public Object createComment(@RequestBody CommentEntity commentEntity) {
        return commentService.createComment(commentEntity);
    }

    @PutMapping("/{commentId}")
    public CommentEntity updateComment(@PathVariable Integer commentId, @RequestBody CommentEntity commentEntity) {
        return commentService.updateComment(commentId, commentEntity);
    }

}
