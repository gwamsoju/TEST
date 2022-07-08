package com.example.test;

import com.example.test.VO.Board;
import com.example.test.mapper.BoardMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BoardTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    void 게시물_가져오기(){
        List<Board> list = boardMapper.getList();
        System.out.println(list.size());
    }
}
