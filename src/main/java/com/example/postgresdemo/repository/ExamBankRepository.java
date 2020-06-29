package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.ExamBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamBankRepository extends JpaRepository<ExamBank, Long> {

}
