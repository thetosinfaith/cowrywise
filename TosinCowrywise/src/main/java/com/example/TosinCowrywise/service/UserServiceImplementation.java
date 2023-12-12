package com.example.TosinCowrywise.service;

import com.example.TosinCowrywise.data.models.User;
import com.example.TosinCowrywise.data.repository.UserRepository;
import com.example.TosinCowrywise.dto.requests.CreateAccountRequest;
import com.example.TosinCowrywise.dto.requests.LoginRequest;
import com.example.TosinCowrywise.dto.responses.CreateAccountResponse;
import com.example.TosinCowrywise.dto.responses.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImplementation implements UserServiceInterface{
    @Autowired
    private UserRepository userRepository;


    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest request) {
        User newUser = new User();

        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(request.getPassword());
        newUser.setAccountNumber(generateAccountNumber());

        User savedUser = userRepository.save(newUser);

        CreateAccountResponse response = new CreateAccountResponse();
        response.setMessage("Account created successfully.\n Your account number is "+savedUser.getAccountNumber());
        return response;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        Optional<User> foundUser = userRepository.findByEmail(request.getEmail());


        if(foundUser.isEmpty()){
            throw new RuntimeException("Bad login details");
        }

        if(!foundUser.get().getPassword().equals(request.getPassword())){
            throw new RuntimeException("Bad login details");
        }

        LoginResponse response = new LoginResponse();

        response.setMessage("You're logged in!");

        return response;
    }

    private String generateAccountNumber(){
        Random random = new Random();

        String accountNumber = "";

        while (accountNumber.length() < 9){
            long number = random.nextInt(999999999);
            accountNumber = String.valueOf(number);
        }
        return accountNumber;
    }

}
