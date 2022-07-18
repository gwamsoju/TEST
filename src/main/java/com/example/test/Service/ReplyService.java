package com.example.test.Service;

import com.example.test.VO.Reply;
import com.example.test.mapper.ReplyMapper;
import com.example.test.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyMapper replyMapper;

    public int insertReply(Reply reply){

        return replyMapper.insertReply(reply);
    }

    public Reply getReply(Reply reply){
        return replyMapper.selectReply(reply);
    }

    public int delete(Long idx){
        return replyMapper.delete(idx);
    }

    public int update(Reply reply){
        return replyMapper.update(reply);
    }

    public List<Reply> getReplyList(Long idx, PageUtil pageUtil){
        return replyMapper.getReplyList(pageUtil, idx);
    }
}
