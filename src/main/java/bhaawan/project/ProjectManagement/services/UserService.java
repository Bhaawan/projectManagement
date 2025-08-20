package bhaawan.project.ProjectManagement.services;

import bhaawan.project.ProjectManagement.models.UserModel;
import bhaawan.project.ProjectManagement.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void registerUser(UserModel user){
        userRepo.save(user);
    }

    public List<UserModel> getAllUsers(){
        return userRepo.findAll();
    }

}
