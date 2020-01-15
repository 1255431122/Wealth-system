package com.qf.web;


import com.qf.entity.UserEntity;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("index")
    public String index(){
        System.out.println("index");

        return "index";

    }

    @RequestMapping("login")
    public String login(UserEntity user, Model model){

        //调用service 实现登录操作
        UserEntity userEntity = userService.login(user);

        //登录成功
        model.addAttribute("user",userEntity);

        return "success";
    }
}
