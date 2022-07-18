package com.example.test.Service;

import com.example.test.VO.Board;
import com.example.test.mapper.BoardMapper;
import com.example.test.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;

    @Override
    public List<Board> getList(PageUtil pageUtil) {
        System.out.println(pageUtil);
        return boardMapper.getList(pageUtil);
    }

    @Override
    public Board listByNumber(Board board) {
        return boardMapper.listByNumber(board);
    }

    @Override
    public void uploadFile(MultipartFile uploadFile)throws IOException {
        uploadFile.transferTo(new File("C://TEST" + uploadFile.getOriginalFilename()));
    }

    @Override
    public int getTotalBoard() {
        return boardMapper.getTotalBoard();
    }

    @Override
    public int getReplyCnt(Long idx) {
        return boardMapper.getReplyCnt(idx);
    }

    @Override
    public void updateCnt(Long idx) {
        boardMapper.updateCnt(idx);
    }
}
