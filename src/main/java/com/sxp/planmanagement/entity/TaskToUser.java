package com.sxp.planmanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author sxp
 * @create 2019-07-07 23:40
 **/
@Data
@NoArgsConstructor
@Entity(name = "tasktouser")
public class TaskToUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "projectid")
    private int projectId;

    /**
     * 0表示全体成员
     */
    @Column(name = "userid")
    private int userId;
    @Column(name = "taskid")
    private int taskId;

    @Column(name = "taskname")
    private String taskName;
    @Column
    private int role;

    public TaskToUser(int projectId, int userId, int taskId, String taskName) {
        this.projectId = projectId;
        this.userId = userId;
        this.taskId = taskId;
        this.taskName = taskName;
    }
}
