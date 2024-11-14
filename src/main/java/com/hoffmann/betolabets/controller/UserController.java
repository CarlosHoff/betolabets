package com.hoffmann.betolabets.controller;

import com.hoffmann.betolabets.domain.annotation.ExtractID;
import com.hoffmann.betolabets.domain.request.UserRegisterRequest;
import com.hoffmann.betolabets.domain.response.ProfileResponse;
import com.hoffmann.betolabets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public ResponseEntity cadastraUsuario(
            @RequestBody UserRegisterRequest request) {
        userService.createUsuario(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ProfileResponse buscaUsuario(
            @ExtractID(userID = "usuarioID") Long userID) {
        return userService.buscaUsuario(userID);
    }
}
