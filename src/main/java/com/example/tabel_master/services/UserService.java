package com.example.tabel_master.services;

import com.example.tabel_master.models.User;
import com.example.tabel_master.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    //find all Users
    public List<User> findAllUsers(){
        return this.userRepository.findAll();
    }
    // find user by email
    public User findUserByEmail(String email) {
        return  this.userRepository.findByEmail(email);
    }
    //find user by fullName
    public User findUserByName(String name){
        return this.userRepository.findByName(name);
    }
    // find user by id
    public User findUserById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }
    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            return BCrypt.checkpw(password, user.getPassword());
        }
    }
}
