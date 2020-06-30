package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "exam_bank")
@Getter
@Setter
public class ExamBank extends AuditModel {
    @Id
    @GeneratedValue(generator = "eb_generator")
    @SequenceGenerator(
            name = "eb_generator",
            sequenceName = "eb_generator",
            initialValue = 1000
    )
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "qid")
    //@JsonIgnore
    private QuestionBank question;


    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "emid")
    @JsonIgnore
    private ExamMasterBankMapping examMasterBankMapping;

    private boolean isActive;

}
