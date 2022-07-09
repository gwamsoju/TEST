package com.example.test.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileVO {

    private String uuid;
    private String fileName;
    private String contentType;

    @Override
    public String toString() {
        return "FileVO{" +
                "uuid='" + uuid + '\'' +
                ", fileName='" + fileName + '\'' +
                ", contentType='" + contentType + '\'' +
                '}';
    }
}
