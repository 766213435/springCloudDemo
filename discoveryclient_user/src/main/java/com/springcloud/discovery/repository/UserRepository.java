package com.springcloud.discovery.repository;

import com.springcloud.discovery.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jiangmh
 * @company GeekPlus
 * @create 2019-11-14 17:08
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
