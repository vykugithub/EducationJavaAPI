package com.example.postgresdemo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student_exam_details")
@Getter
@Setter
public class StudentExamDetails {
    @Id
    @GeneratedValue(generator = "sem_generator")
    @SequenceGenerator(
            name = "sem_generator",
            sequenceName = "sem_generator",
            initialValue = 1000
    )
    @Column(name="sed_id")
    private Long sedId;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "qid")
    //@JsonIgnore
    private QuestionBank question;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "sem_id")
    //@JsonIgnore
    private StudentExamMaster studentExamMaster;

    private boolean isAnswered;
    private boolean isVisited;
    private String answerText;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "start_ts", nullable = false, updatable = false)
//    @CreatedDate
//    private Date startTs;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "end_ts", nullable = false, updatable = false)
//    @CreatedDate
//    private Date endTs;
}
