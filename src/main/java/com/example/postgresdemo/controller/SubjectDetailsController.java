package com.example.postgresdemo.controller;

import com.example.postgresdemo.dto.SubjectDetailsDTO;
import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.mappers.QuestionMapper;
import com.example.postgresdemo.mappers.SubjectDetailsMapper;
import com.example.postgresdemo.model.QuestionBank;
import com.example.postgresdemo.model.SubjectDetails;
import com.example.postgresdemo.repository.ClassDetailsRepository;
import com.example.postgresdemo.repository.SubjectDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class SubjectDetailsController {

    @Autowired
    SubjectDetailsRepository subjectDetailsRepository;

    @Autowired
    ClassDetailsRepository classDetailsRepository;

    @GetMapping("/subjects")
    public Page<SubjectDetails> getSubjects(Pageable pageable) {
        return subjectDetailsRepository.findAll(pageable);
    }

    @GetMapping("/subjects/{sid}")
    public SubjectDetails getSubject(@PathVariable Long sid) {
        return subjectDetailsRepository.findById(sid).get();
        /*map(subjectDetails -> {
            return subjectDetails;
        }).orElseThrow(() -> new ResourceNotFoundException("Subject details not found with id " + sid));*/
    }

    @PostMapping("/subjects/{cid}")
    public SubjectDetails createSubject(@PathVariable Long cid,@Valid @RequestBody SubjectDetailsDTO subjectDetailsDTO) {
        SubjectDetails subjectDetails = SubjectDetailsMapper.INSTANCE.dtoToObj(subjectDetailsDTO);
        return classDetailsRepository.findById(cid).map(classDetails ->{
            subjectDetails.setClassDetails(classDetails);
            return subjectDetailsRepository.save(subjectDetails);
        }).orElseThrow(() -> new ResourceNotFoundException("ClassDetails not found with id " + cid));
    }
}
