package com.example.test.mapper;

import com.example.test.VO.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    public List<Board> getList();
    public void insertBoard();
}
