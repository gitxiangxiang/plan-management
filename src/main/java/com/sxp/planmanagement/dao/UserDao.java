package com.sxp.planmanagement.dao;

import com.sxp.planmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sxp
 * @create 2019-07-06 22:58
 **/
public interface UserDao extends JpaRepository<User, Integer> {

    User findByUserNameIs(String userName);

}
