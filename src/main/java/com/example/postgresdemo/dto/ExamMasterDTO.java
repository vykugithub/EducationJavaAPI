package com.example.postgresdemo.dto;

import com.example.postgresdemo.model.ClassDetails;
import com.example.postgresdemo.model.ExamMasterBankMapping;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ExamMasterDTO {

    private Long eid;
    private String name;
    private String description;
    private Integer duration;
    private Integer negMarking;
    private Long cid;
    private List<ExamMasterBankMapping> examMasterBankMappings;
}
