package com.example.tabel_master.validator;

import com.example.tabel_master.models.User;
import com.example.tabel_master.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (this.userRepository.existsByEmail(user.getEmail())) {
            errors.rejectValue("email", "Unique","Email already has been taken!");
        }
        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Match","Password and Password Confirmation doesn't match!");
        }
    }
}