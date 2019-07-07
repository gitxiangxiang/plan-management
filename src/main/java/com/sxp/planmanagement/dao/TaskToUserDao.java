package com.sxp.planmanagement.dao;

import com.sxp.planmanagement.entity.TaskToUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author sxp
 * @create 2019-07-07 23:49
 **/
public interface TaskToUserDao extends JpaRepository<TaskToUser,Integer> {

    List<TaskToUser> findByProjectIdIsAndUserIdIs(int projectId,int userId);
    List<TaskToUser> findByTaskIdIs(int taskId);

}
