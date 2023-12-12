package com.example.TosinCowrywise.service;

import com.example.TosinCowrywise.dto.requests.CreateAccountRequest;
import com.example.TosinCowrywise.dto.requests.LoginRequest;
import com.example.TosinCowrywise.dto.responses.CreateAccountResponse;
import com.example.TosinCowrywise.dto.responses.LoginResponse;

public interface UserServiceInterface {
    CreateAccountResponse createAccount(CreateAccountRequest request);
    LoginResponse login(LoginRequest request);
}
