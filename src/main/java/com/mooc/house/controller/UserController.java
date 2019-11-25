package com.mooc.house.controller;

import com.mooc.house.common.model.User;
import com.mooc.house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/selectUsers")
    @ResponseBody
    public List<User> selectUsers(){
        return userService.selectUsers();
    }

    @RequestMapping("/hello")
    public String hello(Model model){
        List<User> users = userService.selectUsers();
        model.addAttribute("user",users.get(0));
        return "hello";
    }
    @RequestMapping("/index")
    public String index(Model model){
        return "homepage/index";
    }
}
