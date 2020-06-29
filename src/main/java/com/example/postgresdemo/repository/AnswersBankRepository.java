package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.AnswersBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswersBankRepository extends JpaRepository<AnswersBank, Long> {

}
