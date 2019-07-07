package com.sxp.planmanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author sxp
 * @create 2019-07-04 21:43
 **/
@Data
@Entity(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 发送者
     */
    @Column(name = "senduserid")
    private int sendUserId;

    /**
     * 接受者
     */
    @Column(name = "receiveuserid")
    private int receiveUserId;

    /**
     * 发送时间
     */
    private Date date;

    /**
     * 群发（0）还是私聊（1）
     */
    private int type;

    /**
     * 是否已读(false:未读，true:已读)
     */
    private Boolean read;

}
