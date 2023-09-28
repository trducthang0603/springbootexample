package com.example.javaprojectbuild.repository;

import com.example.javaprojectbuild.model.DatabaseFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, String> {
}
