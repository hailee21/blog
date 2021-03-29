package com.test.board.web.controller;

import com.test.board.entity.BoardEntity;
import com.test.board.entity.CommentEntity;
import com.test.board.service.BoardService;
import com.test.board.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments/{boardId}")
    public String getCommentlist(@PathVariable("boardId") Integer boardId,  Model model) {
        //Optional<CommentEntity> commentList = Optional.ofNullable(commentService.getCommentlist(boardId));
        //model.addAttribute("commentList", commentList);

        return "board/comments";
    }
}
