package com.blog.demo.dto;

import lombok.Data;
import org.apache.naming.factory.SendMailFactory;

@Data
public class AuthRequest {
    private String username;
    private String password;
    private String email;
}

