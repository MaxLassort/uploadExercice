package com.maxime.uploadfile.repository;

import com.maxime.uploadfile.model.FileDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StorageRepository extends JpaRepository<FileDb, Long> {


}
