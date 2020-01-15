package com.qf.controller;

import com.qf.beans.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class LoginController {

    @RequestMapping("login")
    public String login(User user, Model model){

        // 现在通过shiro来实现认证
        Subject currentUser = SecurityUtils.getSubject();

        if (null == currentUser){
            return "error";
        }

        if (!currentUser.isAuthenticated()){
            //认证需要我们shiro实体类
            UsernamePasswordToken token = new UsernamePasswordToken(user.getAcount(),user.getApass());
            token.setRememberMe(true); //记住我

            //去做登录
            try {
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                model.addAttribute("errorMsg", "用户不存在");
                return "login";
            } catch (IncorrectCredentialsException ice) {
                model.addAttribute("errorMsg", "密码错误");
                return "login";
            } catch (LockedAccountException lae) {
                model.addAttribute("errorMsg", "账户被锁定");
                return "login";
            } catch (AuthenticationException ex) { // 用户名或者密码错误
                model.addAttribute("errorMsg", "用户名或者密码错误");
                return "login";
            }
        }
        model.addAttribute("errorMsg", "系统繁忙，请稍后再试");
        return "login";

    }

    //shiro登出的一种方式
    @RequestMapping("logout")
    public String logout() { //这个就是shiro的登出方式
        SecurityUtils.getSubject().logout();
        return "login";
    }

}
