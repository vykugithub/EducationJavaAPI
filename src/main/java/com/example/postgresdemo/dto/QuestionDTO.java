package com.example.postgresdemo.dto;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class QuestionDTO {

    private String textDesc;
    private String cid;
    private String sid;
    private Long qid;
    private Set<AnswerDTO> answers;

}
