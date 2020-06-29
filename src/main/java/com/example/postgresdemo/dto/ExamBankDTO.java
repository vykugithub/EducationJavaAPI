package com.example.postgresdemo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExamBankDTO {
    private Long id;
    private Long qid;
    private Long cid;
    private Long sid;
    private Long emid;
    private boolean isActive;
}
