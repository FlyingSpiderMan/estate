package com.kgc.spring.controller;

import com.kgc.spring.pojo.User;
import com.kgc.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("users")
@Controller
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("login.do")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "verify.do",method = RequestMethod.POST,produces="text/html;charset=utf-8")
    @ResponseBody
    public String verify(Model model, @RequestParam("cardid") String cardid, @RequestParam("password") String password, HttpServletResponse response){
        User users= userService.selectUser(cardid);
        if(users==null){
            return "<script>alert('该账号不存在，请先注册！');location.href='login.do';</script>";
        }else if(!users.getPassword().equals(password)){
            return "<script>alert('登录失败，身份证号或密码错误！');location.href='login.do';</script>";
        }else if(users.getStatus()==0){
            return "<script>alert('登录失败，该账号已被冻结！');location.href='login.do';</script>";
        }else{
            String username = users.getName();
            model.addAttribute("username",username);
            return "<script>alert('登录成功！');location.href='index.do?username="+username+"';</script>";
        }
    }
}
