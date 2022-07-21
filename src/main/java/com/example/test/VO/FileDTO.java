package com.example.test.VO;

import lombok.Data;

@Data
public class FileDTO {

    private String fileName; // 파일 원본 이름
    private String uploadPath; // 업로드 경로
    private String uuid; // UUID값
    private boolean image; // 이미지 여부 -> 즉, 이미지인지 아닌지 판별 ....

}
