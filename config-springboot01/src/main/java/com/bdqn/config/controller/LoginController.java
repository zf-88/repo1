package com.bdqn.config.controller;

import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author zf
 * @create 2020-02-16 21:49
 */
@Controller
public class LoginController {
    @RequestMapping("/login")

    public  String login(
            @RequestParam("username") String username,
            @RequestParam("password")String password, Model model, HttpSession session){

        if (username.equals("zhoufan")&&password.equals("123456")){
session.setAttribute("loginUser",username);
            return "redirect:main.html";
        }else {

            model.addAttribute("msg","用户名或密码错误！");

        }
        return "indexT";
    }

    @GetMapping("/logout")
    public  String logout(HttpSession session){
            session.invalidate();
            return  "redirect:/";

    }
}
