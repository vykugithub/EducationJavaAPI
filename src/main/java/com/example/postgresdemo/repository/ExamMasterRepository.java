package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.ExamMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamMasterRepository extends JpaRepository<ExamMaster, Long> {

    List<ExamMaster> findByClassDetailsCid(Long cid);

}
