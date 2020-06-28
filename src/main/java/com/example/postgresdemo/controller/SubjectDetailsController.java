package com.example.postgresdemo.controller;

import com.example.postgresdemo.model.SubjectDetails;
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

    @PostMapping("/subjects")
    public SubjectDetails createSubject(@Valid @RequestBody SubjectDetails subjectDetails) {
        return subjectDetailsRepository.save(subjectDetails);
    }

}
