package com.example.aestheticClinic.interfaces.rest.controllers;

import com.example.aestheticClinic.application.dto.CreateNewUserDto;
import com.example.aestheticClinic.application.server.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signupuser")
    public ResponseEntity createNewUserController(@RequestBody @Valid CreateNewUserDto createNewUserDto){
        userService.execute(createNewUserDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
