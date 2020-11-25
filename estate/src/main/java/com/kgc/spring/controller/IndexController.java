package com.kgc.spring.controller;

import com.kgc.spring.pojo.User;
import com.kgc.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.PrintWriter;

@Controller
public class IndexController {

    @Resource
    UserService userService;

    @RequestMapping("/register.do")
    public String register() {
        return "register";
    }

    @RequestMapping("doregister.do")
    public String register(String cardid, String name, String password, PrintWriter out){
        User user = new User();
        user.setCardId(cardid);
        user.setName(name);
        user.setPassword(password);
        String gend = cardid.substring(17);
        if (gend != null) {
            int gender = Integer.parseInt(gend);
            if (gender % 2 == 0) {
                user.setGender(0);
            } else {
                user.setGender(1);
            }
        }
        if(userService.addUser(user)>0){
            out.print("<script>alert('注册成功，请登录');location.href='login.do'</script>");
        } else {
            out.print("<script>alert('注册失败，请重新注册');location.href='register.do'</script>");
        }
        return "login";
    }

}
