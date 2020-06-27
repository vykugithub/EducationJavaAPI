package com.example.postgresdemo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "subject_details")
@Data
public class SubjectDetails extends AuditModel {
    @Id
    @GeneratedValue(generator = "subject_generator")
    @SequenceGenerator(
            name = "subject_generator",
            sequenceName = "subject_sequence",
            initialValue = 1000
    )
    private Long sid;

    @Size(min = 3, max = 100)
    private String name;

}
