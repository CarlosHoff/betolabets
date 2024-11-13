package com.hoffmann.betolabets.controller;

import com.hoffmann.betolabets.domain.request.UserRegisterRequest;
import com.hoffmann.betolabets.domain.response.ProfileResponse;
import com.hoffmann.betolabets.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("register")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/insertUser")
    public ResponseEntity cadastraUsuario(
            @RequestBody UserRegisterRequest request) {
        usuarioService.createUsuario(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/searchUser")
    public ProfileResponse buscaUsuario(
            @RequestParam String email) {
        return usuarioService.buscaUsuario(email);
    }
}
