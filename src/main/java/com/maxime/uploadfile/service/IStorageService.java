package com.maxime.uploadfile.service;

import com.maxime.uploadfile.model.FileDb;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IStorageService {
    public void uploadImage(MultipartFile file) throws IOException;
    Optional<FileDb> getFileDb(Long id);

    public List<FileDb> findAll();

    public void deleteById(Long id);

}
