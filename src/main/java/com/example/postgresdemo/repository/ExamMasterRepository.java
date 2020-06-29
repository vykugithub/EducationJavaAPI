package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.ExamMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamMasterRepository extends JpaRepository<ExamMaster, Long> {

}
