package com.tasktree.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn
    private User user;

    private String title;

    private boolean done = false;

    private Date dateStart;

    private Date dateEnd;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date created;

    @UpdateTimestamp
    @Column(name = "update_date")
    private Date updated;
}
