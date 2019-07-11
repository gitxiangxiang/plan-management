package com.sxp.planmanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author sxp
 * @create 2019-07-04 22:57
 **/
@Data
@Entity(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "projectname")
    private String projectName;

    private int manager;

    @Column(name = "describetext")
    private String description;

    @Column(name = "createdate")
    private Date createDate;

    @Column(name = "finishdate")
    private Date finishDate;

    @Column
    private String hashcode;

    @Transient
    private int MessageNumNotRead=0;

}
