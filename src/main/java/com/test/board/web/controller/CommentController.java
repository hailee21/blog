package com.test.board.web.controller;

import com.test.board.entity.CommentEntity;
import com.test.board.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/boards/{boardId}/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

//    @GetMapping("")
//    public List<CommentEntity> getCommentList(@PathVariable Integer boardId) {
//        return commentService.getCommentList(boardId);
//    }

    @PostMapping("")
    public Object createComment(@RequestBody CommentEntity commentEntity) {
        commentService.createComment(commentEntity);
        return "redirect:/boards";
    }

    @GetMapping("/{commentId}")
    public String getComment(@PathVariable Integer commentId, Model model) {
        model.addAttribute("comment", commentService.getComment(commentId));
        return "comment/comment_edit";
    }

    @PutMapping("/{comentId}")
    public String updateCommon(@PathVariable Integer commentId, @RequestBody CommentEntity commentEntity) {
        commentService.updateComment(commentId, commentEntity);
        return "redirect:/boards";
    }

    @DeleteMapping("/{commentId}")
    public String deleteBoard(@PathVariable Integer commentId) {
        commentService.deleteComment(commentId);
        return "redirect:/boards";
    }
}
