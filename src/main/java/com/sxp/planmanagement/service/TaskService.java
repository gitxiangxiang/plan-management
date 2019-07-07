package com.sxp.planmanagement.service;

import com.sxp.planmanagement.dao.TaskDao;
import com.sxp.planmanagement.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sxp
 * @create 2019-07-07 22:36
 **/
@Service
public class TaskService {

    @Autowired
    TaskDao taskDao;

    public Task addTask(Task task){
        return taskDao.save(task);
    }

    /**
     * 查询整个项目的活动
     * @return
     */
    public List<Task> showTaskInProject(int projectId){
        return taskDao.findByProjectIdIs(projectId);
    }

    public Task findById(int id){
        return taskDao.findById(id);
    }
}
