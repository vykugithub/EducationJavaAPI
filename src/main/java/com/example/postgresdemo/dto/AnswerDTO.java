package com.example.postgresdemo.dto;
import lombok.Getter;
import lombok.Setter;

import com.example.postgresdemo.model.QuestionBank;

@Getter @Setter
public class AnswerDTO {

    private Long id;
    private String text;
    private boolean is_correct;
}
