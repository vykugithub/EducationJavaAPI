package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.Answer;
import com.example.postgresdemo.model.SubjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectDetailsRepository extends JpaRepository<SubjectDetails, Long> {

}
