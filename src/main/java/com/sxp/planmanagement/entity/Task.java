package com.sxp.planmanagement.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author sxp
 * @create 2019-07-05 9:09
 **/
@Data
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "userid")
    private int userId;
    @Column(name = "projectid")
    private int projectId;
    @Column(name = "describetext")
    private String describe;
    @Column(name = "completestatus")
    private int completeStatus;

}
