package com.sxp.planmanagement;

import com.sxp.planmanagement.dao.ProjectDao;
import com.sxp.planmanagement.entity.Project;
import com.sxp.planmanagement.util.HashCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanManagementApplicationTests {

    @Autowired
    ProjectDao projectDao;

    //@Test
    public void contextLoads() {
        List<Project> projects = projectDao.findAll();
        for (Project project : projects) {
            project.setHashcode(HashCode.getHashCode(project.getId()+project.getProjectName()));
            projectDao.save(project);
        }
    }

}
