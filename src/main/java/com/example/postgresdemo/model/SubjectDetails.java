package com.example.postgresdemo.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "subject_details")
@Getter @Setter
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
