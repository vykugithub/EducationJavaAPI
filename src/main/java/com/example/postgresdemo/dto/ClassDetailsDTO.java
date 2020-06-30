package com.example.postgresdemo.dto;

import com.example.postgresdemo.model.SubjectDetails;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClassDetailsDTO {
    private Long cid;
    private String name;
//    private List<SubjectDetails> subjects;
}
