package com.example.test.controller;

import com.example.test.VO.TestVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class MainController {

    @GetMapping("/login")
    public String Test(){
        return "login";
    }

    @GetMapping("/loginProc")
    public String Test(TestVO testVO){
        System.out.println(testVO.getId());
        return "main";
    }

    @ResponseBody
    @PostMapping("/test")
    public void Test2(@RequestBody HashMap<String, Object> map){
        System.out.println(map);
    }

}
