package com.example.demo.mapper;


import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> queryUserList(); //查询所有的用户

    User queryUserById(int id); //按id查找用户

    int addUser(User user); //添加一个用户
}
