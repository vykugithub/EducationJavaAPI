package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.Answer;
import com.example.postgresdemo.model.ExamMasterBankMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamMasterBankMappingRepository extends JpaRepository<ExamMasterBankMapping, Long> {
    List<ExamMasterBankMapping> findByExamMasterEid(Long eid);
}
