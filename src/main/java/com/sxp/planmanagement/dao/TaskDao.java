package com.sxp.planmanagement.dao;

import com.sxp.planmanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author sxp
 * @create 2019-07-06 23:05
 **/
public interface TaskDao extends JpaRepository<Task, Integer> {

    List<Task> findByUserIdIsAndProjectIdIs(int userId, int projectId);

    List<Task> findByProjectIdIs(int projectId);

    Task findById(int id);

}
