package com.sxp.planmanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author sxp
 * @create 2019-07-05 9:03
 **/
@Data
@NoArgsConstructor
@Entity(name = "usertoproject")
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
    private int MessageNumNotRead=0;

    private int role;

    public UserToProject(int projectId, int userId, Date lastMessageReadDate, int messageNumNotRead, int role) {
        this.projectId = projectId;
        this.userId = userId;
        this.lastMessageReadDate = lastMessageReadDate;
        MessageNumNotRead = messageNumNotRead;
        this.role = role;
    }
}
