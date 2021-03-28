package com.test.board.web.controller;

import com.test.board.entity.BoardEntity;
import com.test.board.service.BoardService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board")
    public String getBoardlist(Model model) {
        List<BoardEntity> boardList = boardService.getBoardlist();
        model.addAttribute("boardList", boardList);

        return "board/board_main";
    }

    @GetMapping("/getBoard/{boardId}")
    public String getBoard(@PathVariable("boardId") Integer boardId, Model model) {
        BoardEntity board = boardService.getBoard(boardId);
        model.addAttribute("board", board);

        return "board/board_read";
    }

    @DeleteMapping("/deleteBoard/{boardId}")
    public String deleteBoard(@PathVariable("boardId") Integer boardId, Model model) {
        boardService.deleteBoard(boardId);

        return "redirect:/board";
    }
}