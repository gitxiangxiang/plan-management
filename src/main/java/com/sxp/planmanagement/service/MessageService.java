package com.sxp.planmanagement.service;

import com.sxp.planmanagement.dao.MessageDao;
import com.sxp.planmanagement.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author sxp
 * @create 2019-07-06 23:41
 **/
@Service
public class MessageService {

    @Autowired
    MessageDao messageDao;

    /**
     * 获取指定时间前的私聊信息
     * @param date
     * @param receiverId
     * @param page
     * @param size
     * @return
     */
    public List<Message> getPrivateMessageByDateBefore(Date date,int receiverId,int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        return messageDao.findByDateAfterAndReceiveUserIdIsAndTypeIs(date,receiverId,1,pageable).getContent();
    }

    /**
     * 获取指定时间前未读的私聊信息，最多100条
     * @param date
     * @param receiverId
     * @return
     */
    public List<Message> getNotReadPrivateMessageByDateBefore(Date date,int receiverId){
        Pageable pageable = PageRequest.of(0,100);
        return messageDao.findByDateAfterAndReceiveUserIdIsAndTypeIs(date,receiverId,1,pageable).getContent();
    }

    /**
     * 获取指定时间前的群聊信息
     * @param date
     * @param receiverId
     * @param page
     * @param size
     * @return
     */
    public List<Message> getPublicMessageByDateBefore(Date date,int receiverId,int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        return messageDao.findByDateAfterAndReceiveUserIdIsAndTypeIs(date,receiverId,0,pageable).getContent();
    }

    public void SetHaveRead(Date date,int sender,int receiver){
        messageDao.updateMessageStatusToHasRead(date,sender,receiver);
    }

}
