package com.example.test.Service;

import com.example.test.VO.Board;
import com.example.test.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;

    @Override
    public List<Board> getList() {
        return boardMapper.getList();
    }
}
