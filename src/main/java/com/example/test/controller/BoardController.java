package com.example.test.controller;

import com.example.test.Service.BoardService;
import com.example.test.VO.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public String board(Model model){
        List<Board> lists = boardService.getList();
        model.addAttribute("lists",lists);
        return "board";
    }
    @GetMapping("/write")
    public String write(){
        return "write";
    }
}
