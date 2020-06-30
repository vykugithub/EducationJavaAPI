package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.Student;
import com.example.postgresdemo.model.StudentExamMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentExamMasterRepository extends JpaRepository<StudentExamMaster, Long> {
}
