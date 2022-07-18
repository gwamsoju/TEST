package com.example.test.controller;

import com.example.test.Service.BoardService;
import com.example.test.Service.ReplyService;
import com.example.test.VO.Board;
import com.example.test.VO.Reply;
import com.example.test.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController2 {
    
    private final BoardService boardService;
    private final ReplyService replyService;

    @GetMapping("/{idx}")
    public void getReply(Long idx, PageUtil pageUtil, ModelAndView mv){
        List<Reply> lists = replyService.getReplyList(idx, pageUtil);

        mv.addObject("Replys",lists);
        mv.setViewName("/");

    }

    @ResponseBody
    @PostMapping("/new")
    public int insertReply(Reply reply, Long idx){
        boardService.updateCnt(idx);
        return replyService.insertReply(reply);
    }
}
