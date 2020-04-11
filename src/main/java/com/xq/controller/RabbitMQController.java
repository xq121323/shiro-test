package com.xq.controller;

import com.xq.rabbitmq.MQSender;
import com.xq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author Mechrevo
 * @version v1.0
 * 2020/3/13 18:01
 */
@Controller
@RequestMapping("/mq")
public class RabbitMQController {
    @Autowired
    MQSender sender;

    @Autowired
    UserService userService;

    @RequestMapping("/getUser/{id}")
    @ResponseBody
    public Map getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @RequestMapping("/test")
    @ResponseBody
    public Object test(){
        int count = Count.getCount();
        sender.sendMessage(count);
        return count;
    }

    private static class Count{
        private static int count=0;
        private Count(){}
        public static int getCount(){
            return count++;
        }
    }
}
