package com.example.postgresdemo.controller;

import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.model.ClassDetails;
import com.example.postgresdemo.repository.ClassDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ClassDetailsController {
    @Autowired
    ClassDetailsRepository classDetailsRepository;

    @GetMapping("/classes")
    public Page<ClassDetails> getClasses(Pageable pageable) {
        return classDetailsRepository.findAll(pageable);
    }

    @GetMapping("/classes/{cid}")
    public ClassDetails getSubject(@PathVariable Long cid) {
        return classDetailsRepository.findById(cid).
                map(subjectDetails -> {
                    return subjectDetails;
                }).orElseThrow(() -> new ResourceNotFoundException("Subject details not found with id " + cid));
    }

    @PostMapping("/classes")
    public ClassDetails createClass(@Valid @RequestBody ClassDetails classDetails) {
        return classDetailsRepository.save(classDetails);
    }

}
