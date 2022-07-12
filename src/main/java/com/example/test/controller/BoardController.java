package com.example.test.controller;

import com.example.test.Service.BoardService;
import com.example.test.VO.Board;
import com.example.test.VO.PageDTO;
import com.example.test.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public String board(Model model, PageUtil pageUtil){
        List<Board> lists = boardService.getList(pageUtil);
        int totalBoard = boardService.getTotalBoard();
        model.addAttribute("lists",lists);
            model.addAttribute("pageMaker", new PageDTO(totalBoard,pageUtil));
        return "board";
    }
    @GetMapping("/write")
    public String write(){
        return "write";
    }

    @PostMapping("/write")
    public String upload(){

        return "redirect:/";
    }

    @GetMapping("/lists/{idx}")
    public String listByNumber(Model model, Board board1){
        Board board = boardService.listByNumber(board1);
        model.addAttribute("board",board);
        return "boardDetail";
    }
}
