package com.example.test.VO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reply {

    private Long rno;
    private Long idx;

    private String reply;
    private String replyer;
    private Date replyDate;
    private Date updateDate;

}

