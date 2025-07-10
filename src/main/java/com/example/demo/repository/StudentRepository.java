package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
	 Student findByUsernameAndPasswd(String username, String passwd);
	 Student findByUsername(String username);
}
