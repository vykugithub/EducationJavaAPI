package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "answers_bank")
@Getter
@Setter
public class AnswersBank extends AuditModel {
    @Id
    @GeneratedValue(generator = "answers_generator")
    @SequenceGenerator(
            name = "answers_generator",
            sequenceName = "answers_generator",
            initialValue = 1000
    )
    private Long id;

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "qid")
    @JsonIgnore
    private QuestionBank question;

    private String text;

    private boolean is_correct;

}
