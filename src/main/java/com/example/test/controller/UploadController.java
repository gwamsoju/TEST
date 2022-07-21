package com.example.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Controller
public class UploadController {

    private String getFolder(){ // 오늘 날짜를 문자열로 생성한다.

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();

        String str = simpleDateFormat.format(date);

        return str.replace("-", File.separator); // File.separator를 사용해서 2022-07-21을 2022\07\22로 변경해서
                                                        // 해당 경로를 만들기 위해서 사용함.
                                                        // 결론적으로 C:\\upload\2022\07\21 이라는 경로가 생기게 하기 위함.
    }

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

    @GetMapping("/ajaxUpload")
    public String ajaxUpload(){
        log.info("ajax upload");
        return "ajaxUpload";
    }

    @PostMapping("/uploadAjaxAction")
    public void AjaxUpload(MultipartFile[] uploadFile){
        log.info("ajax Upload ......");

        String uploadPath = "c:\\upload";

        File file1 = new File(uploadPath, getFolder());

        log.info("upload Path : " + file1);

        if(file1.exists() == false ){ // 오늘 날짜로 만들어진 폴더가 있는지 확인하는 것.
            file1.mkdirs(); // yyyy\MM\dd 형태의 폴더를 만든다.
        }

        UUID uuid = UUID.randomUUID(); // 동일한 이름이 들어올 경우 기존 파일을 지우게 되므로
                                        // 그런 경우를 방지하기 위해 저장되는 파일의 이름을 임의로 바꾼다.

        for(MultipartFile multipartFile : uploadFile){

            log.info("---------------------------");
            log.info("uploadFileName : " + multipartFile.getOriginalFilename());
            log.info("uploadFileSize : " + multipartFile.getSize());

            String uploadFileName = uuid.toString() + "_" + multipartFile.getOriginalFilename();
            log.info(uploadFileName);
            File file = new File(file1, uploadFileName);

            try{
                multipartFile.transferTo(file); // 받은 파일을 전송해준다.
            }catch(Exception e){
                log.error(e.getMessage());
            }
        }
    }
}
