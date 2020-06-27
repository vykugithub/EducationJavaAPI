package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "question_bank")
@Data
public class QuestionBank extends AuditModel {
    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_generator",
            initialValue = 1000
    )
    private Long qid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ClassDetails classDetails;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private SubjectDetails subjectDetails;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "qid", nullable = true)
    private QImage qImage;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "qid", nullable = true)
    private QText qText;

    @OneToMany(mappedBy = "question",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<AnswersBank> answersBank;

}