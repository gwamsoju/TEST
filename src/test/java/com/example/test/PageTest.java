package com.example.test;

import com.example.test.Service.BoardService;
import com.example.test.VO.Board;
import com.example.test.mapper.BoardMapper;
import com.example.test.util.PageUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PageTest {

    @Autowired
    private BoardMapper mapper;
    @Autowired
    private BoardService boardService;

    @Test
    public void 페이지_테스트1(){

        PageUtil pageUtil = new PageUtil();
        List<Board> list = mapper.getList(pageUtil);

        list.forEach(board -> System.out.println(board));

    }

    @Test
    public void 페이지_테스트2(){

        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageNum(2);
        pageUtil.setAmount(5);
        List<Board> list = mapper.getList(pageUtil);

        list.forEach(board -> System.out.println(board));

    }

    @Test
    public void 페이지_테스트3(){

        boardService.getList(new PageUtil(2,5))
                    .forEach(board -> System.out.println(board));
    }


}
