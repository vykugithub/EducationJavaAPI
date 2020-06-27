package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.QImage;
import com.example.postgresdemo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QImageRepository extends JpaRepository<QImage, Long> {
}
