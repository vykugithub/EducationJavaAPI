package com.example.postgresdemo.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "class_details")
@Data
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

}
