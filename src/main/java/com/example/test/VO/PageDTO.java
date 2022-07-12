package com.example.test.VO;

import com.example.test.util.PageUtil;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {

    private int startPage;
    private int endPage;
    private boolean prev, next;

    private int total;
    private PageUtil pageUtil;

    public PageDTO(int total, PageUtil pageUtil) {
        this.total = total; // boardService.getTotalBoard()로 구함.
        this.pageUtil = pageUtil;

        this.endPage = (int)(Math.ceil(pageUtil.getPageNum() / 10.0)) * 10; // 끝 페이지의 번호는 10번
        this.startPage = this.endPage - 9; // 첫 페이지는 끝 페이지 번호 - 9 -> 결국 1 ... 11 .... 21 .... 31 이 나옴

        int realEnd = (int)(Math.ceil((total * 1.0)/ pageUtil.getAmount()));// 전체 게시물 수 / 한 페이지에 보여줄 게시물
                                                                            // EX) 190 / 10 => 진짜 끝 페이지는 19쪽이다.
        if(realEnd < this.endPage){ // 진짜 끝페이지는 19이고 형식상 끝페이지가 20이면 결국 20페이지에는 아무 데이터도 없다.
                                    // 그래서 아래 해당 로직을 수행
            this.endPage = realEnd;
        }

        this.prev = this.startPage > 1; // boolean 타입을 이용해서 첫 페이지가 무엇이냐에 따라 '이전'이라는 버튼이 나오도록 함.

        this.next = this.endPage < realEnd; // 현재 끝페이지가 진짜 끝페이지보다 작다면 '다음'버튼 활성화
    }
}
