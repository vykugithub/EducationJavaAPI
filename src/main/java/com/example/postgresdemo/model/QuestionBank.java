package com.example.postgresdemo.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "question_bank")
@Getter @Setter
public class QuestionBank extends AuditModel {
    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_generator",
            initialValue = 1000
    )
    private Long qid;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    private ClassDetails classDetails;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "sid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    private SubjectDetails subjectDetails;

//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER, optional = true)
//    @JoinColumn(name = "qid", nullable = true)
//    private QImage qImage;
//
//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER, optional = true)
//    @JoinColumn(name = "qid", nullable = true)
//    private QText qText;

//    @Lob
//    @Column(nullable = true)
//    private byte[] imageDesc;

    @Column(nullable = true)
    private String textDesc;


    @OneToMany(mappedBy = "question",cascade={CascadeType.ALL})
    //@Column(nullable = false)
    private List<AnswersBank> answersBank;

}
