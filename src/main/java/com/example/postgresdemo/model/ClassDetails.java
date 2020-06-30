package com.example.postgresdemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "class_details")
@Getter
@Setter
public class ClassDetails extends AuditModel {
    @Id
    @GeneratedValue(generator = "class_generator")
    @SequenceGenerator(
            name = "class_generator",
            sequenceName = "class_sequence",
            initialValue = 1000
    )
    private Long cid;

    @Size(min = 3, max = 100)
    private String name;

    @OneToMany(mappedBy = "classDetails", cascade = {CascadeType.ALL})
    private List<SubjectDetails> subjects;

    @OneToMany(mappedBy = "classDetails", cascade = {CascadeType.ALL})
    private List<Student> students;

}
