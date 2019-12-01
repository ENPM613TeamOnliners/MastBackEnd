package com.mast.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.http.HttpStatus;
import java.util.HashMap;
import com.mast.data.UserType;
import com.mast.model.User;
import java.util.Map;
import java.util.List;
import com.mast.data.dynamodb.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;


@RestController
@EnableWebMvc
public class PingController {
    
    
    @Autowired
    UserRepository repository;
    
    @RequestMapping(path = "/ping", method = RequestMethod.GET)
    public Map<String, String> ping() {
        Map<String, String> pong = new HashMap<>();
        pong.put("pong", "Hello, World!");
        return pong;
    }
    
    @GetMapping(path = "/user")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<User> getUser() {
        List<User> result = (List<User>) repository.findAll();
        return result;
    }
}
