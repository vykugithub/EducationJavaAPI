package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "student_details")
@Getter
@Setter
public class Student extends AuditModel {
    @Id
    @GeneratedValue(generator = "student_generator")
    @SequenceGenerator(
            name = "student_generator",
            sequenceName = "student_generator",
            initialValue = 1000
    )
    private Long stu_id;
    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "cid")
    @JsonIgnore
    private ClassDetails classDetails;
}
