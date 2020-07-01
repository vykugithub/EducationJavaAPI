package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.Student;
import com.example.postgresdemo.model.StudentExamDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentExamDetailsRepository extends JpaRepository<StudentExamDetails, Long> {
    Page<StudentExamDetails> findBySedId(Long sedId, Pageable pageable);
}
