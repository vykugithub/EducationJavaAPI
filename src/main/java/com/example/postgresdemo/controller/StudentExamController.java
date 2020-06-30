package com.example.postgresdemo.controller;

import com.example.postgresdemo.dto.ExamMasterBankMappingDTO;
import com.example.postgresdemo.dto.ExamMasterDTO;
import com.example.postgresdemo.dto.StudentDTO;
import com.example.postgresdemo.dto.StudentExamMasterDTO;
import com.example.postgresdemo.mappers.ExamMasterMapper;
import com.example.postgresdemo.mappers.StudentExamMasterMapper;
import com.example.postgresdemo.model.*;
import com.example.postgresdemo.repository.ExamMasterRepository;
import com.example.postgresdemo.repository.StudentExamDetailsRepository;
import com.example.postgresdemo.repository.StudentExamMasterRepository;
import com.example.postgresdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentExamController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentExamDetailsRepository studentExamDetailsRepository;

    @Autowired
    StudentExamMasterRepository studentExamMasterRepository;

    @Autowired
    ExamMasterRepository examMasterRepository;

    @GetMapping("/myExams/{cid}")
    public List<ExamMasterDTO> getMyExams(@PathVariable Long cid){
        List<ExamMaster> list = examMasterRepository.findByClassDetailsCid(cid);
        return list.stream().map(ExamMasterMapper.INSTANCE::objToDto).collect(Collectors.toList());
    }

    @PostMapping("/myExams/")
    public StudentExamMaster startExam(@Valid @RequestBody StudentExamMasterDTO studentExamMasterDTO){
        Student student=studentRepository.findById(studentExamMasterDTO.getStu_id()).get();
        ExamMaster examMaster = examMasterRepository.findById(studentExamMasterDTO.getEid()).get();

        StudentExamMaster studentExamMaster=new StudentExamMaster();
        studentExamMaster.setStudent(student);
        studentExamMaster.setStatus("INPROGRESS");
        studentExamMaster.setExamMaster(examMaster);
        studentExamMaster=studentExamMasterRepository.save(studentExamMaster);
        for(ExamMasterBankMapping mapping:examMaster.getExamMasterBankMappings()){
            for(ExamBank examBank:mapping.getQuestions()){
                StudentExamDetails studentExamDetails=new StudentExamDetails();
                studentExamDetails.setQuestion(examBank.getQuestion());
                studentExamDetails.setStudentExamMaster(studentExamMaster);
                studentExamDetailsRepository.save(studentExamDetails);
            }
        }
        return studentExamMasterRepository.save(studentExamMaster);
    }
}
