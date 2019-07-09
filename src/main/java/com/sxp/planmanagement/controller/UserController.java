package com.sxp.planmanagement.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sxp.planmanagement.entity.User;
import com.sxp.planmanagement.entity.UserToProject;
import com.sxp.planmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sxp
 * @create 2019-07-09 9:45
 **/
@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    ObjectMapper mapper;

    public void getProjectMember(HttpSession session, Model model){
        int projectId = (int) session.getAttribute("projectId");
        Map<String, Object> map = userService.findByProjectId(projectId);
        model.addAttribute("userToProjects",map.get("userToProjects"));
        model.addAttribute("users",map.get("users"));
    }

    @RequestMapping("/selectMemForTask")
    public String selectMemForTask(HttpSession session) throws JsonProcessingException {
        int projectId = (int) session.getAttribute("projectId");
        Map<String, Object> map = userService.findByProjectId(projectId);
        return mapper.writeValueAsString(map);
    }

}
