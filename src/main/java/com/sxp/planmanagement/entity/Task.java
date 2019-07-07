package com.sxp.planmanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author sxp
 * @create 2019-07-05 9:09
 **/
@Data
@Entity(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "userid")
    private int userId;
    @Column(name = "projectid")
    private int projectId;
    @Column(name = "taskname")
    private String taskName;
    @Column(name = "describetext")
    private String description;
    @Column(name = "finishdate")
    private Date finishDate;
    @Column(name = "completestatus")
    private int completeStatus=0;
    @Column
    private String leader;

}
