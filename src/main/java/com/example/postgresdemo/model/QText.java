package com.example.postgresdemo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "qtext_details")
@Data
public class QText extends AuditModel {
    @Id
    @GeneratedValue(generator = "class_generator")
    @SequenceGenerator(
            name = "class_generator",
            sequenceName = "class_sequence",
            initialValue = 1000
    )
    private Long qid;

    private String description;
}
