package com.example.test;

import com.example.test.VO.Board;
import com.example.test.mapper.BoardMapper;
import com.example.test.util.PageUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class BoardTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    void 게시물_가져오기(){
        PageUtil pageUtil = new PageUtil();
        List<Board> list = boardMapper.getList(pageUtil);
        System.out.println(list.size());
    }

    @Test
    void 게시물_가져오기2(){
        List<String> list = Arrays.asList("wodud","ckdrl");

       boardMapper.SearchWithForeach(list).forEach(board -> System.out.println(board));
    }

    @Test
    void 게시물_조건_가져오기(){

        PageUtil pageUtil = new PageUtil();
        pageUtil.setType("W");
        pageUtil.setKeyword("ck");

        boardMapper.getList(pageUtil).forEach(board -> System.out.println(board));
    }
}
