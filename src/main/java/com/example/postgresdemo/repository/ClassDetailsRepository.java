package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.ClassDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassDetailsRepository extends JpaRepository<ClassDetails, Long> {
}
