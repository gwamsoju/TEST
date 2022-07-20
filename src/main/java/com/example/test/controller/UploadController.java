package com.example.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Slf4j
@Controller
public class UploadController {

    @GetMapping("/uploadForm")
    public String uploadForm(){

        return "uploadForm";
    }

    @PostMapping("/upload")
    public void uploadFile(MultipartFile[] uploadFiles, Model model){ // 태그 name이 controller에 인자로 들어옴.
        
        String uploadPath = "c:\\upload";

        for(MultipartFile multipartFile : uploadFiles){
            log.info("FileName : "+multipartFile.getOriginalFilename());
            log.info("FileSize : "+multipartFile.getSize());

            File file = new File(uploadPath, multipartFile.getOriginalFilename());

            try{
                multipartFile.transferTo(file); // transferTo -> 받은 파일을 설정한 Path로 전달한다.
            }catch(Exception e){
                log.error(e.getMessage());
            }
        }
    }
}
