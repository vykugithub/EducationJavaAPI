package com.example.postgresdemo.controller;

import com.example.postgresdemo.model.ClassDetails;
import com.example.postgresdemo.model.QuestionBank;
import com.example.postgresdemo.repository.QuestionBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class QuestionBankController {

    @Autowired
    QuestionBankRepository questionBankRepository;

    @GetMapping("/questions")
    public Page<QuestionBank> getQuestions(Pageable pageable) {
        return questionBankRepository.findAll(pageable);
    }

    @PostMapping("/questions")
    public QuestionBank createQuestion(@Valid @RequestBody QuestionBank question) {
        return questionBankRepository.save(question);
    }
}
