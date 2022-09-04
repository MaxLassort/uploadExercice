package com.maxime.uploadfile.service;

import com.maxime.uploadfile.model.FileDb;
import com.maxime.uploadfile.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StorageService implements IStorageService{

    @Autowired
    private StorageRepository repo;

    @Override
    public void uploadImage(MultipartFile file) throws IOException {
        FileDb filedb = new FileDb(file.getName(), file.getContentType(), file.getBytes());
        repo.save(filedb);
    }

    @Override
    public Optional<FileDb> getFileDb(Long id) {
        Optional<FileDb> fileToDb = repo.findById(id);
        if(repo.findById(id).isPresent()){
            return fileToDb;
        }
        return null;
    }

    @Override
    public List<FileDb> findAll(){
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id){
        repo.deleteById(id);
    }
}
