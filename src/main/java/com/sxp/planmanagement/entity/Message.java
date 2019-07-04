package com.sxp.planmanagement.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author sxp
 * @create 2019-07-04 21:43
 **/
@Data
public class Message {

    private int id;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 发送者
     */
    private String sendUserId;

    /**
     * 接受者
     */
    private String receiveUserId;

    /**
     * 发送时间
     */
    private Date date;

    /**
     * 群发（0）还是私聊（1）
     */
    private int type;

    /**
     * 是否已读(0:未读，1:已读)
     */
    private Boolean read;

}
