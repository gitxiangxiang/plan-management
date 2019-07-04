package com.sxp.planmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sxp
 * @create 2019-07-04 21:13
 **/
@RestController
public class MessageController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping("/helloSocket")
    public String index(){
        return "/hello/index";
    }
    @MessageMapping("/change-notice")
    @SendTo("/topic/notice")
    public String receiveAndSendMessage(String value){
        return value;
    }
}
