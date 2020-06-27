package com.example.postgresdemo.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "qimage_details")
@Data
public class QImage extends AuditModel {
    @Id
    @GeneratedValue(generator = "qimage_generator")
    @SequenceGenerator(
            name = "qimage_generator",
            sequenceName = "qimage_generator",
            initialValue = 1000
    )
    private Long qid;

    @Lob
    private byte[] description;
}
