package com.example.test.VO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TestVO {

    private String id;
    private String password;

    @Override
    public String toString() {
        return "TestVO{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
