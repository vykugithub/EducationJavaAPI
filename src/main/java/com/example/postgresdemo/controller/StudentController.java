package com.example.postgresdemo.controller;

import com.example.postgresdemo.dto.StudentDTO;
import com.example.postgresdemo.mappers.StudentMapper;
import com.example.postgresdemo.model.ExamMaster;
import com.example.postgresdemo.model.Student;
import com.example.postgresdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<StudentDTO> getStudents(Pageable pageable) {
        Page<Student> list = studentRepository.findAll(pageable);
        return list.stream().map(StudentMapper.INSTANCE::objToDto).collect(Collectors.toList());
    }

    @PostMapping("/students")
    public Student createStudent(@Valid @RequestBody StudentDTO  studentDTO) {
        Student student = StudentMapper.INSTANCE.dtoToObj(studentDTO);
//        for (ExamMasterBankMapping mapping : examMaster.getExamMasterBankMappings()) {
//            mapping.setExamMaster(examMaster);
//        }
        return studentRepository.save(student);
    }
}
