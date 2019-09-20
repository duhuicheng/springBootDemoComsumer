package com.SpringBoot.Consumer.controller;

import com.SpringBoot.Consumer.pojo.UserRole;
import com.SpringBoot.Consumer.until.ConsumerUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/test22")
    @ResponseBody
    public String test(){
//        List<UserRole> list = consumerUntil.getResponseBody("demo", HttpMethod.POST,"/demo/test",null);
        ConsumerUntil consumerUntil=new ConsumerUntil();
        //String temp=consumerUntil.getResponseBody("demo","/demo/test");
        String temp=restTemplate.getForObject("http://demo/demo/test",String.class);

        return temp;
    }
}
