package bhaawan.project.ProjectManagement.controllers;

import bhaawan.project.ProjectManagement.models.UserModel;
import bhaawan.project.ProjectManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String greet(){
        return "Hello World !!!";
    }

    @GetMapping("/get/all")
    public List<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/auth/register")
    public void registerUser(@RequestBody UserModel user){
        userService.registerUser(user);
    }



}
