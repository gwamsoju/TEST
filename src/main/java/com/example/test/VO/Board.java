package com.example.test.VO;

import lombok.Data;

import java.sql.Date;

@Data
public class Board {

    private int idx;
    private String title;
    private String context;
    private Date createAt;
    private String id;
}
