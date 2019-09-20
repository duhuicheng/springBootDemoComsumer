package com.SpringBoot.Consumer.until;

import javafx.beans.binding.StringBinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;

@Component
public class ConsumerUntil{

    @Autowired
    private RestTemplate restTemplate;

    private final Logger logger= LoggerFactory.getLogger(getClass());


    public String getResponseBody(String applicationName, String uri){
        if (applicationName == null||applicationName.isEmpty()){
            logger.error("applicationName为空！");
            return null;
        }
        if (uri==null||uri.isEmpty()){
            logger.error("uri为空！");
            return null;
        }
        String url="http://"+applicationName+""+uri;
        String response=restTemplate.getForObject("http://demo/demo/test",String.class);
                //restTemplate.getForObject(url, String.class);
        return response;
    }

}
