package com.bdqn.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * @author zf
 * @create 2020-02-14 12:43
 */
@Controller
public class ControllerOne {

    @RequestMapping("/hello")
    public String hello(Model model){
model.addAttribute("user","<h2>zhansan</h2>");
        model.addAttribute("list", Arrays.asList("zhoufan1","zhoufan2"));
        return  "user";
    }
}
