package com.example.postgresdemo.dto;

import com.example.postgresdemo.model.ClassDetails;
import com.example.postgresdemo.model.ExamBank;
import com.example.postgresdemo.model.SubjectDetails;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ExamMasterBankMappingDTO {

    private Long id;
    private Long sid;
    private List<ExamBank> questions;
    private Long eid;
}
