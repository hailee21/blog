package com.test.board.web.controller;

import com.test.board.entity.BoardEntity;
import com.test.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("")
    public String getBoardList(Model model) {
//        List<BoardEntity> boardList = boardService.getBoardList();
//        model.addAttribute("boardList", boardList);
        model.addAttribute("boardList", boardService.getBoardList());
        return "board/board_main";
    }

    @GetMapping("/{boardId}")
    public String getBoard(@PathVariable Integer boardId, Model model) {
        model.addAttribute("board", boardService.getBoard(boardId));
        return "board/board_read";
    }

    @GetMapping("/create")
    public String createBoard() {
        return "board/board_add";
    }

    @PostMapping("/create")
    public String createBoard(@RequestBody BoardEntity boardEntity) {
        boardService.createBoard(boardEntity);
        return "redirect:/boards";
    }

    @PostMapping("/update/{boardId}")
    public String updateBoard(@PathVariable Integer boardId, @RequestBody BoardEntity boardEntity) {
        boardService.updateBoard(boardId, boardEntity);
        return "redirect:/boards";
    }

    @PostMapping("/delete/{boardId}")
    public String deleteBoard(@PathVariable Integer boardId) {
        boardService.deleteBoard(boardId);
        return "redirect:/boards";
    }
}