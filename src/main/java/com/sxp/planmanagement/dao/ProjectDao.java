package com.sxp.planmanagement.dao;

import com.sxp.planmanagement.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * @author sxp
 * @create 2019-07-06 23:00
 **/
public interface ProjectDao extends JpaRepository<Project ,Integer> {

    List<Project> findByManagerIs(int manager);

    Project findByIdIs(int id);

    List<Project> findByIdIn(Set<Integer> ids);

    Project findByHashcodeIs(String code);
}
