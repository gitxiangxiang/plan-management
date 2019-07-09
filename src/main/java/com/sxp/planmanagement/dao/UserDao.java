package com.sxp.planmanagement.dao;

import com.sxp.planmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * @author sxp
 * @create 2019-07-06 22:58
 **/
public interface UserDao extends JpaRepository<User, Integer> {

    User findByUserNameIs(String userName);

    List<User> findByIdIn(Set<Integer> ids);
}
