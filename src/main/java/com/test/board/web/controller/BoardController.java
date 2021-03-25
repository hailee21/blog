package com.test.board.web.controller;

import com.test.board.entity.BoardEntity;
import com.test.board.service.BoardService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/getBoard")
    public String getBoard(@RequestParam(name="id", required=true) Integer boardId, Model model) {
        BoardEntity board = boardService.getBoard(boardId);
        model.addAttribute("board", board);

        return "board/board_read";
    }

    @PostMapping("/deleteBoard")
    public String deleteBoard(@RequestParam(name="id", required=true) Integer boardId, Model model) {
        boardService.deleteBoard(boardId);

        return "redirect:/board";
    }
}