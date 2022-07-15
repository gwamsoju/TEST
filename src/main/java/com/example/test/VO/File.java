package com.example.test.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class File {

    private int fileId;
    private String fileName;
    private String originalFileName;
    private String filePath;

}
