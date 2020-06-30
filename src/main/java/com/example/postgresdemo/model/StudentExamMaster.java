package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "student_exam_master")
@Getter
@Setter
public class StudentExamMaster extends AuditModel {
    @Id
    @GeneratedValue(generator = "sem_generator")
    @SequenceGenerator(
            name = "sem_generator",
            sequenceName = "sem_generator",
            initialValue = 1000
    )
    private Long sem_id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "stu_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Student student;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "em_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ExamMaster examMaster;

    private boolean isActive;
    private String status;
    private Long timeSpent;

}
