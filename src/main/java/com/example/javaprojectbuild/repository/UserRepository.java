package com.example.javaprojectbuild.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.javaprojectbuild.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
