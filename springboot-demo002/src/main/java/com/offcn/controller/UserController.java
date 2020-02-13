package com.offcn.controller;

import com.offcn.po.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    //获取用户的列表
    @GetMapping("/")
    public String findAll(Model model){
        List<User> list = userService.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    //跳转到新增用户
    @RequestMapping("/toAdd")
    public String toAdd(User user){
        return "add";
    }
    //添加用户
    @RequestMapping("/add")
    public String add(User user){
        userService.add(user);
        return "redirect:/user/";
    }
    @RequestMapping("/toEdit/{id}")
    public String toEdit(@PathVariable("id") Long id,Model model){
        User user = userService.findOne(id);
        model.addAttribute("user",user);
        return "Edit";
    }
    @RequestMapping("/edit")
    public String edit(User user){
        userService.update(user);
        return "redirect:/user/";
    }
    //删除
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/user/";
    }
}
