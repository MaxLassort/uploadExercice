package com.maxime.uploadfile.controller;


import com.maxime.uploadfile.model.FileDb;
import com.maxime.uploadfile.repository.StorageRepository;
import com.maxime.uploadfile.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("files")
public class FileDbController {

    @Autowired
    StorageRepository storageRepository;
    @Autowired
    StorageService storageService;

    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getFiles(){
        List<FileDb> list =  storageService.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void uploadfile(@RequestParam("file") MultipartFile file) throws IOException {
        storageService.uploadImage(file);
    }

}
