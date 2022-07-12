package com.example.test.mapper;

import com.example.test.VO.Board;
import com.example.test.util.PageUtil;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    public List<Board> getList(PageUtil pageUtil);
    public void insertBoard();
    public Board listByNumber(Board board);
    public int getTotalBoard();
}
