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

    private User user;

    private String title;

    private boolean done;

    private Date dateStart;

    private Date dateEnd;

    @Relationship(type = "HAS")
    public Set<TaskGraph> children;

    public TaskGraph(Task task) {
        taskId = task.getId();
        user = task.getUser();
        title = task.getTitle();
        done = task.isDone();
        dateStart = task.getDateStart();
        dateEnd = task.getDateEnd();
    }
}
