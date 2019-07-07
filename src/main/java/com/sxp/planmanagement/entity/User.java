package com.sxp.planmanagement.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author sxp
 * @create 2019-07-04 21:58
 **/
@Data
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String userName;
    private String password;
    private boolean online;
    private int role;

}
