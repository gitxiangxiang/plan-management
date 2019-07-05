package com.sxp.planmanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author sxp
 * @create 2019-07-05 9:03
 **/
@Data
@Table(name = "usertoproject")
public class UserToProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "projectid")
    private int projectId;
    @Column(name = "userid")
    private int userId;
    @Column(name = "lastmessagereaddate")
    private Date lastMessageReadDate;
    @Column(name = "messagenumnotread")
    private int MessageNumNotRead;
}
