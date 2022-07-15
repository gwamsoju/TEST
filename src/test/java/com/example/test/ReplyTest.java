package com.example.test;

import com.example.test.VO.Reply;
import com.example.test.mapper.ReplyMapper;
import com.example.test.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class ReplyTest {

    @Autowired
    private ReplyMapper replyMapper;

    @Test
    public void 테스트_1(){
        Reply reply = Reply.builder()
                .bno("1")
                .reply("댓글 테스트_3")
                .replyer("wodud")
                .build();

        replyMapper.insertReply(reply);
    }

    @Test
    public void 테스트_2(){
        Reply reply = new Reply();
        reply.setRno(1L);

        Reply reply1 = replyMapper.selectReply(reply);

        System.out.println(reply1);
    }
    
    @Test
    public void 테스트_3(){
        PageUtil pageUtil = new PageUtil();

        List<Reply> replyList = replyMapper.getReplyList(pageUtil, 1L);

        replyList.forEach(reply -> System.out.println(reply));
    }

}
