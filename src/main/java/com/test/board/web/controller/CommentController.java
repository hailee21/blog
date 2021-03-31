package com.test.board.web.controller;

import com.test.board.entity.CommentEntity;
import com.test.board.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.NoSuchElementException;

@Slf4j
@Controller
@RequestMapping("/boards/{boardId}/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

//    @GetMapping("/comments/{boardId}")
//    public String getCommentlist(@PathVariable("boardId") Integer boardId,  Model model) {
//        return "board/comments";
//    }

    @GetMapping("/{commentId}")
    public String getComment(@PathVariable Integer commentId, Model model) {
        System.out.println(("commentController"));
        model.addAttribute("comment", commentService.getComment(commentId));
        return "comment/comment_edit";
    }
}
