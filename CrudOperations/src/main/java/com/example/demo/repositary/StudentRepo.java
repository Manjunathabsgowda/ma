package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
