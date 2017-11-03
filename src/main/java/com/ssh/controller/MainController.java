package com.ssh.controller;

import com.ssh.entity.Person;
import com.ssh.entity.User;
import com.ssh.service.PersonService;
import com.ssh.service.TestService;
import com.ssh.service.UserService;
import com.ssh.util.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.Set;


/**
 * Created by XRog
 * On 2/1/2017.12:36 AM
 */
@Controller
public class MainController {


    @Autowired
    private PersonService personService;
    @Autowired
    private UserService userService;
    String msg;




    @RequestMapping(value = "savePerson", method = RequestMethod.GET)
    @ResponseBody
    public String savePerson() {
        personService.savePerson();
        return "success!";
    }

    @RequestMapping(value = "test2")

    public String test(String name) {
        System.out.println(name);
//        System.out.println(password);
        return "success";
    }

    //
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String name, String password, String code,HttpServletResponse response, HttpServletRequest request) throws Exception {

        List<User> u1 = userService.getUser(name, password);
String str2= (String) request.getSession().getAttribute("str1");
//        Set<String> set= (Set<String>) request.getSession().getAttribute("ls");



        if (u1.size() != 0&&str2.equals(code)) {
            User u = u1.get(0);
            System.out.println(name);
            System.out.println(u.getName());
            System.out.println(password);
            System.out.println(u.getPasssword());

            ModelAndView mav = new ModelAndView("test2");
            request.getSession().setAttribute("user",u);
            return "/views/test2.jsp";
        } else {

            System.out.println(name);

            System.out.println(password);
            msg = "登陆失败";
            request.setAttribute("msg",msg);
            return ("/index.jsp");
        }

    }


        @RequestMapping(value = "/ValiImage")

        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            response.setIntHeader("Expires", -1);
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            BufferedImage img =new Captcha().getImg(request);
            // 将图片输出到浏览器
            ImageIO.write(img, "jpg", response.getOutputStream());

        }}

//        public void doGet(HttpServletRequest request, HttpServletResponse response)
//                throws ServletException, IOException {
//            doGet(request, response);
//        }



