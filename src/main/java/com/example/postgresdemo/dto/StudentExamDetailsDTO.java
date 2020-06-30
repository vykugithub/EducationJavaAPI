package com.example.postgresdemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentExamDetailsDTO {
    private Long stu_id;
    private Long eid;
    private Long qid;
    private Long sed_id;
    private String answerText;
}
