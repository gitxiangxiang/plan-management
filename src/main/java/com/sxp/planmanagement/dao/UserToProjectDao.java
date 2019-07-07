package com.sxp.planmanagement.dao;

import com.sxp.planmanagement.entity.UserToProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author sxp
 * @create 2019-07-06 23:03
 **/
public interface UserToProjectDao extends JpaRepository<UserToProject, Integer> {

    List<UserToProject> findByUserIdIs(int userId);

}
