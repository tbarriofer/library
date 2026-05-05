package com.library.libreria;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneratePass {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("admin123"));
    }
}
