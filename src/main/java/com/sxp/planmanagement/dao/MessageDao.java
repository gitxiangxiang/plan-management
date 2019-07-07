package com.sxp.planmanagement.dao;

import com.sxp.planmanagement.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * @author sxp
 * @create 2019-07-06 23:36
 **/
public interface MessageDao extends JpaRepository<Message, Integer> {

    Page<Message> findByDateAfterAndReceiveUserIdIsAndTypeIs(Date date, int receiveId, int type, Pageable pageable);

    //设置为已读
    @Query(value = "update message set `read`=true " +
            "where `date`<=?1 and senduserid=?2 and receiveuserid=?3 and `read`=false",nativeQuery = true)
    void updateMessageStatusToHasRead(Date date, int sender,int receicer);

}
