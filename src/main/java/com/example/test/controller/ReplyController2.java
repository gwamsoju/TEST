package com.example.test.controller;

import com.example.test.Service.ReplyService;
import com.example.test.VO.Reply;
import com.example.test.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController2 {

    private final ReplyService replyService;

    @GetMapping("/{bno}")
    public void getReply(Long bno, PageUtil pageUtil, ModelAndView mv){
        List<Reply> lists = replyService.getReplyList(bno, pageUtil);

        mv.addObject("Replys",lists);
        mv.setViewName("/");

    }
}
