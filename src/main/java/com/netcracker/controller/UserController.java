package com.netcracker.controller;

import com.netcracker.entity.User;
import com.netcracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public String getAllUsers(Map<String, Object> model) {
        Iterable<User> users = userRepository.findAll();
        model.put("user", users);
        return "allUsers";
    }

    @GetMapping("/addView")
    public String adMethod() {
        return "addUser";
    }
    @PostMapping("/add")
    public String addUser(@RequestParam String name,@RequestParam String email,
                          @RequestParam int age, Map<String, Object> model) {
        User user = new User(name, age, email);
        userRepository.save(user);
//        Iterable<User> users = userRepository.findAll();
//        model.put("user", users);
        return "redirect:/all";
    }


}
