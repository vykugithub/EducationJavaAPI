package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "exam_master_bank_mapping", uniqueConstraints = @UniqueConstraint(columnNames = { "sid", "eid"}))
@Getter
@Setter
public class ExamMasterBankMapping extends AuditModel {
    @Id
    @GeneratedValue(generator = "emb_generator")
    @SequenceGenerator(
            name = "emb_generator",
            sequenceName = "emb_generator",
            initialValue = 1000
    )
    private Long emid;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "sid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    private SubjectDetails subjectDetails;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "eid")
    @JsonIgnore
    private ExamMaster examMaster;

    @OneToMany(mappedBy = "examMasterBankMapping", cascade = {CascadeType.ALL})
    //@Column(nullable = false)
    private List<ExamBank> questions;

}
