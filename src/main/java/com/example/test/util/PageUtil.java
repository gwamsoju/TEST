package com.example.test.util;

import lombok.Data;

@Data
public class PageUtil {

    private int pageNum;
    private int amount;

    public PageUtil() {
        this(1,10);
    }

    public PageUtil(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }
}
