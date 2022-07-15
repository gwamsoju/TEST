package com.example.test;

import com.example.test.VO.Board;
import com.example.test.mapper.BoardMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CDATATest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void CDATA_테스트(){
        boardMapper.getBetweenDay().forEach(board -> System.out.println(board));
    }
}
