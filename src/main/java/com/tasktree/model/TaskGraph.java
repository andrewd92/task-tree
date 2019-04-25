package com.tasktree.model;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Date;
import java.util.Set;

@NodeEntity
@Data
public class TaskGraph {
    @Id
    @GeneratedValue
    private Long id;

    private Long taskId;

    private String title;

    private boolean done = false;

    private Date date;

    @Relationship(type = "HAS")
    public Set<TaskGraph> children;
}
