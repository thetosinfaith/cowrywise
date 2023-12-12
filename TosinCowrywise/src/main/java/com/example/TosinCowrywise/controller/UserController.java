package com.example.TosinCowrywise.controller;
import com.example.TosinCowrywise.dto.requests.CreateAccountRequest;
import com.example.TosinCowrywise.dto.requests.LoginRequest;
import com.example.TosinCowrywise.dto.responses.CreateAccountResponse;
import com.example.TosinCowrywise.dto.responses.LoginResponse;
import com.example.TosinCowrywise.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Response entity
//  ? means wildcard
//ResponseEntity is a datatype that is specially made for controllers

//I need to read about http methods
//ok.body is a follow-come.



@RestController
@RequestMapping("/api/v1/user")
//Defines the entrypoint of my api
public class UserController {

    @Autowired //You won't have to use the new keyword; just create the class and object.
    private UserServiceInterface userServiceInterface;
    private UserServiceInterface userService;

    //Response entity is the data type

    //Any data coming from frontend is always a JSON format - Javascript Object Notation
    //We have to find a way to convert the JSON to java class and we use one annotation to do that
    //The name of the annotation is @RequestBody, if you don't put the annotation you'll have an error.
    
    @PostMapping("/register")
    public ResponseEntity<CreateAccountResponse> registerUser(@RequestBody CreateAccountRequest request) {
        CreateAccountResponse response = userServiceInterface.createAccount(request);
        return ResponseEntity.ok().body(response);

    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest request){
        LoginResponse response = userServiceInterface.login(request);
        return ResponseEntity.ok().body(response);
    }



}
