package com.sxp.planmanagement.service;

import com.sxp.planmanagement.dao.UserDao;
import com.sxp.planmanagement.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * @author sxp
 * @create 2019-07-05 10:56
 **/
@Service
public class PermissionService {

    @Autowired
    UserDao userDao;

    public String getPassword(String userName){
        return userDao.findByUserNameIs(userName).getPassword();
    }

    public User findByUserName(String userName){
        return userDao.findByUserNameIs(userName);
    }

    public boolean login(String userName,String password,HttpSession session){
        try{
            if(password.equals(this.getPassword(userName))){
                session.setAttribute("userName",userName);
//            session.setAttribute("userRole",0);
                this.isOnline(session);
                return true;
            }
        }catch (Exception e){
            System.out.println(userName+" 用户不存在");
        }
        return false;
    }

    public void isOnline(HttpSession session){
        Thread online = new Thread(new Online(session));
    }
}


class Online implements Runnable {

    private HttpSession session;

    Online(HttpSession session){
        this.session = session;
    }

    @Override
    public void run() {
        try {
            while(true){
                if(session.getAttribute("userName") != null)
                    Thread.sleep(60*1000);
                else {

                    return;
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}