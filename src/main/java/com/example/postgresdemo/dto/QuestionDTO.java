package com.example.postgresdemo.dto;

import lombok.Data;

import java.util.Set;

@Data
public class QuestionDTO {

    private String textDesc;
    private String cid;
    private String sid;
    private Long qid;
    private Set<AnswerDTO> answers;

}
