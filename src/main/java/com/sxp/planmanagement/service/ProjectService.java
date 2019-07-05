package com.sxp.planmanagement.service;

import com.sxp.planmanagement.entity.Project;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sxp
 * @create 2019-07-05 10:13
 **/
@Service
public class ProjectService {

    public List<Project> getProjectByUserName(String userName){
        List<Project> projects = new LinkedList<>();
        Project project1 = new Project();
        project1.setProjectName("第一个项目");
        Project project2 = new Project();
        project2.setProjectName("第二个项目");
        Project project3 = new Project();
        project3.setProjectName("第三个项目");

        projects.add(project1);
        projects.add(project2);
        projects.add(project3);

        return projects;
    }
}
