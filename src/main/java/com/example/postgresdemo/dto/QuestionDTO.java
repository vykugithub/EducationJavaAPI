package com.example.postgresdemo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class QuestionDTO {

    private String textDesc;
    private String cid;
    private String sid;
    private Long qid;
    private Set<AnswerDTO> answers;

}
