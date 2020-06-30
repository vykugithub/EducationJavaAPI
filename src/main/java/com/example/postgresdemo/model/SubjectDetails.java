package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "subject_details")
@Getter
@Setter
public class SubjectDetails extends AuditModel {
    @Id
    @GeneratedValue(generator = "subject_generator")
    @SequenceGenerator(
            name = "subject_generator",
            sequenceName = "subject_sequence",
            initialValue = 1000
    )
    private Long sid;

    @Size(min = 3, max = 100)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ClassDetails classDetails;

}
