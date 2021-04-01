package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;
    //查询所有用户信息
    @GetMapping({"/queryUserList", "/"})
    public String queryUserList(Model model){
        List<User> user = userMapper.queryUserList();
        model.addAttribute("alluser", user);
        return "showAll";
    }

    //添加用户信息
    @PostMapping("/addUser")
    public String addUser(User user){
        userMapper.addUser(user);
        return "redirect:/queryUserList";
    }

    @GetMapping("/addUser")
    public String toAddUser(User user){
        return "add";
    }

    //按照id查询用户信息
    @PostMapping("/queryUserById")
    public String queryUserById(Model model, int id){
        User user = userMapper.queryUserById(id);
        model.addAttribute("oneuser", user);
        return "showOne";
    }

    @GetMapping("/queryUserById")
    public String toQueryUserById(Model model){
        return "find";
    }


}
