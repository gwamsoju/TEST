package com.example.test.controller;

import com.example.test.VO.FileDTO;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    private boolean checkImageType(File file){ // 업로드되는 파일이 어떤 타입인지 확인.

        try{
            String contentType = Files.probeContentType(file.toPath()); // 내부적으로 FileTypeDetector가 파일의 타입을 가지고
                                                                        // 판단하여 값을 반환해줌.
            
            return contentType.startsWith("image"); // contentType이 "Image"로 시작하면 true를 반환함.

        }catch(IOException e){
            e.printStackTrace();
        }

        return false;
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

    @PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<FileDTO>> AjaxUpload(MultipartFile[] uploadFile){
        log.info("ajax Upload ......");

        List<FileDTO> list = new ArrayList<>();

        String uploadFolder = "c:\\upload";

        String uploadFolderPath = getFolder();

        File uploadPath = new File(uploadFolder, uploadFolderPath);

        log.info("upload Path : " + uploadPath);

        if(uploadPath.exists() == false ){ // 오늘 날짜로 만들어진 경로가 있는지 확인하는 것.
            uploadPath.mkdirs(); // yyyy\MM\dd 형태의 폴더를 만든다.
        }

        UUID uuid = UUID.randomUUID(); // 동일한 이름이 들어올 경우 기존 파일을 지우게 되므로
                                        // 그런 경우를 방지하기 위해 저장되는 파일의 이름을 임의로 바꾼다.

        for(MultipartFile multipartFile : uploadFile){

            FileDTO fileDTO = new FileDTO();

            log.info("---------------------------");
            log.info("uploadFileName : " + multipartFile.getOriginalFilename());
            log.info("uploadFileSize : " + multipartFile.getSize());

            String originalFileName = multipartFile.getOriginalFilename();

            fileDTO.setFileName(originalFileName);

            String uploadFileName = uuid.toString() + "_" + originalFileName;
            log.info(uploadFileName);
            File saveFile = new File(uploadPath, uploadFileName);

            try{
                multipartFile.transferTo(saveFile); // 받은 파일을 전송해준다.

                fileDTO.setUuid(uuid.toString());
                fileDTO.setUploadPath(uploadFolderPath);

                if(checkImageType(saveFile)){ // 메소드 실행 후 반환값이 true이면 괄호 안의 코드를 수행한다.

                    fileDTO.setImage(true); // -> 파일이 이미지이면 true로 설정.
                    FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
                    Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100 , 100);
                    thumbnail.close();

                }

                list.add(fileDTO);

            }catch(Exception e){
                log.error(e.getMessage());
            }
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
