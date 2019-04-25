package com.tasktree.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date created;

    @UpdateTimestamp
    @Column(name = "update_date")
    private Date updated;
}
