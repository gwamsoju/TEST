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
    public List<Board> getBetweenDay();
    public List<Board> SearchWithForeach(List list);
    public void boardUpdate(Board board);
    public List<Board> SearchBoard(List list);
}
