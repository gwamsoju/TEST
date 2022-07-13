package com.example.test.VO;

import lombok.Data;

import java.sql.Date;

@Data
public class Board {

    private String idx;
    private String title;
    private String context;
    private Date createAt;
    private String id;
    private String fileId;
}
