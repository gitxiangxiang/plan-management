package com.sxp.planmanagement.service;

import com.sxp.planmanagement.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sxp
 * @create 2019-07-07 0:16
 **/
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public int getUserIdByUserName(String userName){
        return userDao.findByUserNameIs(userName).getId();
    }
}
