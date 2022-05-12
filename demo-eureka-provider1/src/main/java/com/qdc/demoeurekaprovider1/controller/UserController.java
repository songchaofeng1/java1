package com.qdc.demoeurekaprovider1.controller;

import com.qdc.demoeurekaprovider1.pojo.User;
import com.qdc.demoeurekaprovider1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //亲后端分离，企业级开发，返回json
//@Controller  //返回具体的页面
@RequestMapping(value = "/user")
public class UserController {

    @Value("${spring.cloud.client.ip-address}")
    String ipaddr;

    @Value("${server.port}")
    int port;




    @Autowired
    UserService userService;

    //addUser方法在接受前端传过来的数据也是json格式
    //把json格式转化为user对象
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public boolean updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public boolean deleteUser(@RequestParam(value = "username",required = true) String name){
        return userService.deleteUser(name);
    }

    @RequestMapping(value = "/deatils",method = RequestMethod.GET)
    public User selectUserById(@RequestParam(value = "userid",required = true) String id){
        return userService.selectUserById(id);
    }
    @RequestMapping(value = "/userall",method = RequestMethod.GET)
    public List<User> select(){
        return userService.selectAll();

    }

    @RequestMapping(value = "/sayHi",method = RequestMethod.GET)
    public String hello(@RequestParam(value = "sleep_seconds",required = true)int sleep_seconds) throws InterruptedException{
        System.out.println("休眠时间"+sleep_seconds);
        Thread.sleep(sleep_seconds*1000);
        return "Hello,我在"+ipaddr+":"+port;


    }



}
