package com.example.test.mapper;

import com.example.test.VO.Reply;
import com.example.test.util.PageUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {

    public int insertReply(Reply reply);
    public Reply selectReply(Reply reply);
    public int delete (Long rno);
    public int update(Reply reply);
    public List<Reply> getReplyList(@Param("pageUtil") PageUtil pageUtil, @Param("idx") Long idx);
}
