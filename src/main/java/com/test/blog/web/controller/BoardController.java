package com.test.blog.web.controller;

import com.test.blog.service.BoardService;
import com.test.blog.vo.BoardVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BoardController {

    private BoardService boardService;


    @GetMapping("/board")
    public String getBoardlist(Model model) {
        List<BoardVo> boardVoList = boardService.getBoardlist();
        model.addAttribute("boardList", boardVoList);
        return "board/board_main";
    }

//    @GetMapping("/board/{boardId}")
//    public String addBoard(@RequestParam(name="boardId", required=true) Integer boardId, Model model) {
//        //String title = boardDTO.getTitle();
//        model.addAttribute("name", name);
//        return "board/board_read"; //BoardService.addBoard(title);
//    }


}