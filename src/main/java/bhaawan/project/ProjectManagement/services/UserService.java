package bhaawan.project.ProjectManagement.services;

import bhaawan.project.ProjectManagement.dto.LoginRequestDTO;
import bhaawan.project.ProjectManagement.models.UserModel;
import bhaawan.project.ProjectManagement.repositories.UserRepo;
import bhaawan.project.ProjectManagement.services.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public void registerUser(UserModel user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    public String loginUser(LoginRequestDTO login){

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            login.getEmail(),
                            login.getPassword()
                    )
            );
        }catch (AuthenticationException e){
            System.out.println("Invalid Credentials "+e);
        }

        var user = userRepo.findByEmail(login.getEmail());

        String token= jwtService.generateToken(user);

        return token;
    }

    public List<UserModel> getAllUsers(){
        return userRepo.findAll();
    }

}
