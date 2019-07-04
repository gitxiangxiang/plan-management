package com.sxp.planmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author sxp
 * @create 2019-07-04 22:59
 **/
@Controller
public class PermissionController {

    @RequestMapping("/tologin")
    public String login(String userName, String password, HttpSession session){
        session.setAttribute("userName",userName);
        return "index";
    }
}
