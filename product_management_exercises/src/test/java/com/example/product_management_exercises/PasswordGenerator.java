package com.example.product_management_exercises;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "haubong";
        String encodePassword = encoder.encode(rawPassword);

        System.out.println(encodePassword);
    }
}
