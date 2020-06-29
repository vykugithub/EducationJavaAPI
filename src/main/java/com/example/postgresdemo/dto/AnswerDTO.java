package com.example.postgresdemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerDTO {

    private Long id;
    private String text;
    private boolean is_correct;
}
