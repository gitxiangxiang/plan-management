package com.sxp.planmanagement.controller;

import com.sxp.planmanagement.entity.Project;
import com.sxp.planmanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sxp
 * @create 2019-07-05 9:01
 **/
@Controller
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping("/per-project")
    public String projectDetail(){
        return "per-project";
    }

    @RequestMapping("/newProject")
    public String newProject(Project project){
        return "redirect:/";
    }

    @RequestMapping("/")
    public String index(HttpSession session, Model model){
        String userName = (String) session.getAttribute("userName");
        if(userName == null) return "login";
        List<Project> projects = projectService.getProjectByUserName(userName);
        model.addAttribute("projects", projects);
        System.out.println("检索项目");
        return "index";
    }
}
