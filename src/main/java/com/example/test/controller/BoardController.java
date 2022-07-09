package com.example.test.controller;

import com.example.test.Service.BoardService;
import com.example.test.VO.Board;
import com.example.test.VO.FileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @PostMapping("/write")
    public String upload(MultipartFile[] uploadFile, Model model )throws IllegalStateException, IOException {
        List<FileVO> lists = new ArrayList<>();

        for(MultipartFile multipartFile : uploadFile){

            if(!multipartFile.isEmpty()){
                FileVO fileVO = new FileVO(UUID.randomUUID().toString()
                                            ,multipartFile.getOriginalFilename()
                                            ,multipartFile.getContentType());

                System.out.println(fileVO);
                lists.add(fileVO);
                System.out.println(lists);
                File fileVO1 = new File(fileVO.getUuid() + "-" + fileVO.getFileName());
                multipartFile.transferTo(fileVO1);
            }
        }
        model.addAttribute("lists",lists);
        return "result";
    }
}
