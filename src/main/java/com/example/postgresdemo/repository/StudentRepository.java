package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.ClassDetails;
import com.example.postgresdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
