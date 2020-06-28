package com.example.postgresdemo.dto;

import com.example.postgresdemo.model.QuestionBank;
import lombok.Data;

@Data
public class AnswerDTO {

    private Long id;
    private String text;
    private boolean is_correct;
    private QuestionBank question;
}
