package com.lix.service;

import com.lix.common.advice.LyException;
import com.lix.common.lyenum.ExceptionEnum;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class UploadService {
    private static final List<String> type= Arrays.asList("xx");
    public String uploadFile(MultipartFile file) {

        try {
            String contentType = file.getContentType();
            System.out.println(contentType);
           /* BufferedImage image = ImageIO.read(file.getInputStream());
            if(image==null){

            }*/
            File file1 = new File("E:/java学习/微服务电商/static/"+file.getOriginalFilename());
            file.transferTo(file1);
            return "http://myimage.leyou.com/java学习/微服务电商/static/"+file.getOriginalFilename();
        } catch (IOException e) {
            throw new LyException(ExceptionEnum.UPLOAD_IMAGE_FAILED);
        }
    }
}
