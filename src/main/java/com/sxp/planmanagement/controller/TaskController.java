package com.sxp.planmanagement.controller;

import com.sxp.planmanagement.dao.UserDao;
import com.sxp.planmanagement.entity.Task;
import com.sxp.planmanagement.service.TaskService;
import com.sxp.planmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author sxp
 * @create 2019-07-07 22:36
 **/
@Controller
public class TaskController {

    @Autowired
    TaskService taskService;
    @Autowired
    UserService userService;

    @RequestMapping("/addTask")
    public String addTask(Task task, HttpSession session){
        task.setProjectId((Integer) session.getAttribute("projectId"));
        task.setUserId(userService.getUserIdByUserName((String) session.getAttribute("userName")));
        taskService.addTask(task);
        return "redirect:/per-project2";
    }

    @RequestMapping("showTask")
    public String taskDetail(int taskId, Model model){
        Task task = taskService.findById(taskId);
        model.addAttribute("task",task);
        return "edit-product";
    }

    public void getProjectMember(HttpSession session, Model model){
        int projectId = (int) session.getAttribute("projectId");
        Map<String, Object> map = userService.findByProjectId(projectId);
        model.addAttribute("users",map.get("users"));
    }

    @RequestMapping("/add-product")
    public String addProduct(HttpSession session, Model model){
        getProjectMember(session,model);
        return "add-product";
    }

}
