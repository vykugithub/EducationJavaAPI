package com.example.postgresdemo.controller;

import com.example.postgresdemo.dto.QuestionDTO;
import com.example.postgresdemo.mappers.QuestionMapper;
import com.example.postgresdemo.model.QuestionBank;
import com.example.postgresdemo.repository.QuestionBankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class QuestionBankController {

    Logger logger = LoggerFactory.getLogger(QuestionBankController.class);

    @Autowired
    QuestionBankRepository questionBankRepository;

    @GetMapping("/questions")
    public List<QuestionDTO> getQuestions(Pageable pageable) {
        return questionBankRepository.findAll(pageable).stream().map(QuestionMapper.INSTANCE::objToDto).collect(Collectors.toList());
    }

    @PostMapping("/questions")
    public QuestionBank createQuestion(@Valid @RequestBody QuestionDTO question) {
        QuestionBank questionB= QuestionMapper.INSTANCE.dtoToObj(question);
        return questionBankRepository.save(questionB);
    }
}
