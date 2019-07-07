package com.sxp.planmanagement.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author sxp
 * @create 2019-07-07 23:40
 **/
@Data
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

}
