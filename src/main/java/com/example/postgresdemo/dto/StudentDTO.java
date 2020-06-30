package com.example.postgresdemo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Getter
@Setter
public class StudentDTO {
    private Long stu_id;
    private String name;
    private Long cid;
}
