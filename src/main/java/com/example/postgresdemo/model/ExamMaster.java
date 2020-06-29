package com.example.postgresdemo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "exam_master")
@Getter
@Setter
public class ExamMaster extends AuditModel {
    @Id
    @GeneratedValue(generator = "em_generator")
    @SequenceGenerator(
            name = "em_generator",
            sequenceName = "em_generator",
            initialValue = 1000
    )
    private Long eid;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    private ClassDetails classDetails;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private Integer duration;

    @Column(nullable = false)
    private Integer negMarking;

    @OneToMany(mappedBy = "examMaster", cascade = {CascadeType.ALL})
    //@Column(nullable = false)
    private List<ExamMasterBankMapping> examMasterBankMappings;

}
