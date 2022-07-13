package com.example.test.util;

import lombok.Data;

@Data
public class PageUtil {

    private int pageNum;
    private int amount;

    private String type;
    private String keyword;

    public PageUtil() {
        this(1,10);
    }

    public PageUtil(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    public String[] getTypeArr(){

        return type == null ? new String[] {} : type.split("");
    }
}
