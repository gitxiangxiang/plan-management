package com.sxp.planmanagement.service;

import com.sxp.planmanagement.dao.UserDao;
import com.sxp.planmanagement.dao.UserToProjectDao;
import com.sxp.planmanagement.entity.User;
import com.sxp.planmanagement.entity.UserToProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author sxp
 * @create 2019-07-07 0:16
 **/
@Service
public class UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    UserToProjectDao userToProjectDao;

    public int getUserIdByUserName(String userName){
        return userDao.findByUserNameIs(userName).getId();
    }

    /**
     *
     * @param projectId
     * @return
     */
    public Map<String, Object> findByProjectId(int projectId){
        List<UserToProject> userToProjects = userToProjectDao.findByProjectIdIs(projectId);
        Set<Integer> ids = new LinkedHashSet<>();
        for (UserToProject userToProject : userToProjects){
            ids.add(userToProject.getUserId());
        }
        List<User> users = userDao.findByIdIn(ids);
        Map<String,Object> map = new HashMap<>();
        map.put("userToProjects",userToProjects);
        map.put("users",users);
        return map;
    }

    public List<UserToProject> getUPbyPid(int projectId){
        return userToProjectDao.findByProjectIdIs(projectId);
    }

    public User saveUser(User user){
        return userDao.save(user);
    }
}
