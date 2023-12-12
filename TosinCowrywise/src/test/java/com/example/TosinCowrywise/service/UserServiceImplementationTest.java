package com.example.TosinCowrywise.service;

import com.example.TosinCowrywise.dto.requests.CreateAccountRequest;
import com.example.TosinCowrywise.dto.requests.LoginRequest;
import com.example.TosinCowrywise.dto.responses.CreateAccountResponse;
import com.example.TosinCowrywise.dto.responses.LoginResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplementationTest {
    @Autowired
    private UserServiceInterface implementation;

    @Test
    void createAccount() {
        CreateAccountRequest request = new CreateAccountRequest();
        request.setFirstName("Tosin");
        request.setLastName("Faith");
        request.setEmail("thetosinfaith@gmail.com");
        request.setPassword("password");

        CreateAccountResponse response = implementation.createAccount(request);
        assertNotNull(response);
        assertEquals("Account created successfully",response.getMessage());
    }

    @Test
    void login() {
        CreateAccountRequest registerAccount = new CreateAccountRequest();
        registerAccount.setFirstName("Tosin");
        registerAccount.setLastName("Faith");
        registerAccount.setEmail("hellotosinfaith@gmail.com");
        registerAccount.setPassword("password");

        CreateAccountResponse response = implementation.createAccount(registerAccount);
        assertNotNull(response);
        assertEquals("Account created successfully",response.getMessage());

        LoginRequest request = new LoginRequest();
        request.setEmail("hellotosinfaith@gmail.com");
        request.setPassword("password");

        LoginResponse loginResponse = implementation.login(request);
        assertNotNull(loginResponse);
        assertEquals("You're logged in!", loginResponse.getMessage());
    }
}