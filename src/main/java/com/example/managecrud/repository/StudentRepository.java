package com.example.managecrud.repository;

import com.example.managecrud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository  extends JpaRepository<Student , Long> {
}
