package com.example.postgresdemo.controller;

import com.example.postgresdemo.dto.ExamBankDTO;
import com.example.postgresdemo.dto.ExamMasterBankMappingDTO;
import com.example.postgresdemo.dto.ExamMasterDTO;
import com.example.postgresdemo.dto.QuestionDTO;
import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.mappers.ExamBankMapper;
import com.example.postgresdemo.mappers.ExamMasterBankMappingMapper;
import com.example.postgresdemo.mappers.ExamMasterMapper;
import com.example.postgresdemo.mappers.QuestionMapper;
import com.example.postgresdemo.model.*;
import com.example.postgresdemo.repository.ExamBankRepository;
import com.example.postgresdemo.repository.ExamMasterBankMappingRepository;
import com.example.postgresdemo.repository.ExamMasterRepository;
import com.example.postgresdemo.repository.QuestionBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ExamController {

    @Autowired
    ExamMasterRepository examMasterRepository;

    @Autowired
    ExamBankRepository  examBankRepository;

    @Autowired
    QuestionBankRepository questionBankRepository;

    @Autowired
    ExamMasterBankMappingRepository examMasterBankMappingRepository;

    @GetMapping("/exams")
    public List<ExamMasterDTO> getExams(Pageable pageable) {
        Page<ExamMaster> list = examMasterRepository.findAll(pageable);
        return list.stream().map(ExamMasterMapper.INSTANCE::objToDto).collect(Collectors.toList());
    }

    @PostMapping("/exams")
    public ExamMaster createExam(@Valid @RequestBody ExamMasterDTO  examMasterDTO) {
        ExamMaster examMaster = ExamMasterMapper.INSTANCE.dtoToObj(examMasterDTO);
//        for (ExamMasterBankMapping mapping : examMaster.getExamMasterBankMappings()) {
//            mapping.setExamMaster(examMaster);
//        }
        return examMasterRepository.save(examMaster);
    }

//    @PutMapping("/exams/{examId}")
//    public ExamMaster updateExam(@PathVariable Long examId,@Valid @RequestBody ExamMasterDTO  examMasterDTO) {
//        ExamMaster examMaster = ExamMasterMapper.INSTANCE.dtoToObj(examMasterDTO);
//        return examMasterRepository.findById(examId)
//                .map(exam -> {
//                    exam.setExamMasterBankMappings(examMasterDTO.getExamMasterBankMappings());
//                    for(ExamMasterBankMapping embm:examMasterDTO.getExamMasterBankMappings()){
//                        embm.setExamMaster(examMaster);
//                    }
//                    return examMasterRepository.save(examMaster);
//                }).orElseThrow(() -> new ResourceNotFoundException("Exam not found with id " + examId));
//    }

    @PostMapping("/exams/subjects/{examId}")
    public ExamMasterBankMapping createExamSubjects(@PathVariable Long examId,@Valid @RequestBody ExamMasterBankMappingDTO mappingDTO) {
        ExamMasterBankMapping mapping = ExamMasterBankMappingMapper.INSTANCE.dtoToObj(mappingDTO);
        return examMasterRepository.findById(examId).map(examMaster ->{
                    mapping.setExamMaster(examMaster);
                    return examMasterBankMappingRepository.save(mapping);
    }).orElseThrow(() -> new ResourceNotFoundException("Exam not found with id " + examId));
    }

    @GetMapping("/exams/subjects/{examId}")
    public List<ExamMasterBankMapping> getExamSubjects(@PathVariable Long examId) {
        return examMasterBankMappingRepository.findByExamMasterEid(examId);
    }

    @PostMapping("/exams/questions/{emid}")
    public ExamBank addQuestionToExam(@PathVariable Long emid,@Valid @RequestBody ExamBankDTO examBankDTO) {
        ExamBank mapping = ExamBankMapper.INSTANCE.dtoToObj(examBankDTO);
        return examMasterBankMappingRepository.findById(emid).map(examMasterBankMapping ->{
            return questionBankRepository.findById(examBankDTO.getQid()).map(questionBank -> {
                mapping.setExamMasterBankMapping(examMasterBankMapping);
                mapping.setQuestion(questionBank);
                return examBankRepository.save(mapping);
            }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + mapping.getQuestion().getQid()));
        }).orElseThrow(() -> new ResourceNotFoundException("Exam not found with id " + emid));
    }
}
