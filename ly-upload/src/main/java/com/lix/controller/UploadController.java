package com.lix.controller;


import com.lix.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("upload")
public class UploadController {
    @Autowired
    UploadService uploadService;
    @PostMapping("image")
    public ResponseEntity<String> uploadFile(MultipartFile file){
        return ResponseEntity.ok(uploadService.uploadFile(file));
    }
}
