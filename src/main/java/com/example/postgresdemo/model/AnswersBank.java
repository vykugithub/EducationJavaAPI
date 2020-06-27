package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "qid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private QuestionBank question;

    private String text;

    private boolean is_correct;

}
