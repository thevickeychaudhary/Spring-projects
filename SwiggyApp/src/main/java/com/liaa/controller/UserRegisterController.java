package com.liaa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liaa.dto.ResponseMessage;
import com.liaa.dto.UserRequestDto;
import com.liaa.entity.UserRegister;
import com.liaa.service.UserRegisterService;

@RestController
@RequestMapping("/swiggy")
public class UserRegisterController {

    @Autowired
    private UserRegisterService userRegisterService;

    @PostMapping("/register")
    public ResponseEntity<ResponseMessage> registerUser(@RequestBody UserRequestDto userRequestDto) {
        try {
            if (userRequestDto.getEmail() == null || userRequestDto.getEmail().isEmpty()
                    || userRequestDto.getPassword() == null || userRequestDto.getPassword().isEmpty()) {
                return ResponseEntity.badRequest().body(
                    new ResponseMessage(400, "failure", "Email and password cannot be empty!"));
            }

            UserRegister user = userRegisterService.createdSwiggyRegister(userRequestDto);
            if (user != null) {
                return ResponseEntity.status(201).body(
                    new ResponseMessage(201, "success", "Swiggy user registered successfully!", user));
            } else {
                return ResponseEntity.badRequest().body(
                    new ResponseMessage(400, "failure", "Swiggy user registration failed."));
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                new ResponseMessage(500, "error", "Internal server error"));
        }
    }
}
