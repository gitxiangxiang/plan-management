package com.sxp.planmanagement.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sxp.planmanagement.entity.Project;
import com.sxp.planmanagement.entity.Task;
import com.sxp.planmanagement.entity.TaskToUser;
import com.sxp.planmanagement.entity.UserToProject;
import com.sxp.planmanagement.service.ProjectService;
import com.sxp.planmanagement.service.TaskService;
import com.sxp.planmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author sxp
 * @create 2019-07-05 9:01
 **/
@Controller
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;
    @Autowired
    ObjectMapper mapper;

    public void getProjectMember(HttpSession session, Model model){
        int projectId = (int) session.getAttribute("projectId");
        Map<String, Object> map = userService.findByProjectId(projectId);
        model.addAttribute("users",map.get("users"));
    }

    @RequestMapping("/per-project")
    public String projectDetail(int projectId,Model model, HttpSession session){
        Project project = projectService.findById(projectId);
        session.setAttribute("projectName",project.getProjectName());
        session.setAttribute("projectId",projectId);
        List<Task> tasks = taskService.showTaskInProject(projectId);
        model.addAttribute("tasks",tasks);
        getProjectMember(session,model);
        return "per-project";
    }

    @RequestMapping("/per-project2")
    public String projectDetail(Model model, HttpSession session){
        Object projectId = session.getAttribute("projectId");
        if (projectId == null) return "redirect:/";
//        Project project = projectService.findById((Integer) projectId);
        List<Task> tasks = taskService.showTaskInProject((Integer) projectId);
        model.addAttribute("tasks",tasks);
        getProjectMember(session,model);
        return "per-project";
    }

    @RequestMapping("/newProject")
    public String newProject(Project project,HttpSession session){
        String userName = (String) session.getAttribute("userName");
        if(userName == null) return "redirect:/login";
        project.setManager(userService.getUserIdByUserName(userName));
        project.setCreateDate(new Date());
        projectService.NewProject(project);
        return "redirect:/";
    }

    @RequestMapping("/")
    public String index(HttpSession session, Model model){
        String userName = (String) session.getAttribute("userName");
        if(userName == null) return "redirect:/login";
        int userId = userService.getUserIdByUserName(userName);
        List<Project> projects = projectService.ViewMyProject(userId);
        model.addAttribute("projects", projects);
        List<TaskToUser> taskToUsers = taskService.showMyTask(userId);
        model.addAttribute("taskToUsers", taskToUsers);
        System.out.println("用户 "+userName+" 检索项目");
        System.out.println(projects);
        System.out.println(taskToUsers);
        return "index";
    }

    @ResponseBody
    @RequestMapping("/getProjectCode")
    public String getProjectCode(HttpSession session){
        return projectService.getProjectHashCode((Integer) session.getAttribute("projectId"));
    }

    @ResponseBody
    @RequestMapping("/getProjectByCode")
    public String getProjectByCode(String code) throws JsonProcessingException {
        Project project = projectService.getProjectByHashcode(code);
        return mapper.writeValueAsString(project);
    }

    @ResponseBody
    @RequestMapping("/requestJoinProject")
    public String requestJoinProject(int projectId, HttpSession session) {
        int userId = userService.getUserIdByUserName((String) session.getAttribute("userName"));
        if(projectService.findByPidAndUid(projectId,userId) != null) {
            return "{\"status\":\"您已在此项目中！\"}";
        }
        UserToProject userToProject = new UserToProject(projectId,userId, new Date(),0,2);
        projectService.SaveOneUserToProject(userToProject);
        return "{\"status\":\"成功加入项目！\"}";
    }
}
