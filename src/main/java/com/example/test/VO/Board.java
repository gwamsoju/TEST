package com.example.test.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    private Long idx;
    private String title;
    private String context;
    private Date createAt;
    private String id;
    private String fileId;
    private int replyCnt;

}
