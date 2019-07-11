package com.sxp.planmanagement.service;

import com.sxp.planmanagement.dao.TaskDao;
import com.sxp.planmanagement.dao.TaskToUserDao;
import com.sxp.planmanagement.entity.Task;
import com.sxp.planmanagement.entity.TaskToUser;
import com.sxp.planmanagement.entity.User;
import com.sxp.planmanagement.entity.UserToProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author sxp
 * @create 2019-07-07 22:36
 **/
@Service
public class TaskService {

    @Autowired
    TaskDao taskDao;
    @Autowired
    TaskToUserDao taskToUserDao;
    @Autowired
    UserService userService;


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

    public void saveTaskToUser(String users,int projectId,int taskId,String taskName){
        List<TaskToUser> taskToUsers = new LinkedList<>();
        if(users.equals("0")){
            List<UserToProject> userToProjects = userService.getUPbyPid(projectId);
            for (UserToProject userToProject : userToProjects) {
                TaskToUser taskToUser = new TaskToUser(projectId,userToProject.getUserId(),taskId,taskName);
                taskToUsers.add(taskToUser);
            }
        }else {
            String[] userArray = users.split(",");
            System.out.println(Arrays.toString(userArray));
            for (String user : userArray) {
                TaskToUser taskToUser = new TaskToUser(projectId,Integer.parseInt(user),taskId,taskName);
                taskToUsers.add(taskToUser);
            }
        }
        taskToUserDao.saveAll(taskToUsers);
    }

    public List<TaskToUser> showMyTask(int userId){
        return taskToUserDao.findByUserIdIs(userId);
    }
}
