package com.example.postgresdemo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "answers_bank")
@Data
public class AnswersBank extends AuditModel {
    @Id
    @GeneratedValue(generator = "answers_generator")
    @SequenceGenerator(
            name = "answers_generator",
            sequenceName = "answers_generator",
            initialValue = 1000
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name="qid")
    private QuestionBank question;

    private String text;

    private boolean is_correct;

}
