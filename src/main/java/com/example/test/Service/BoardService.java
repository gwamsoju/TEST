package com.example.test.Service;

import com.example.test.VO.Board;
import com.example.test.util.PageUtil;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BoardService {

    public List<Board> getList(PageUtil pageUtil);
    public Board listByNumber(Board board);
    public void uploadFile(MultipartFile uploadFile) throws IOException;
    public int getTotalBoard();
    public int getReplyCnt(Long idx);
    public void updateCnt(Long idx);
}
