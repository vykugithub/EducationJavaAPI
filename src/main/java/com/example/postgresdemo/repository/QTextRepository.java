package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.QText;
import com.example.postgresdemo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QTextRepository extends JpaRepository<QText, Long> {
}
