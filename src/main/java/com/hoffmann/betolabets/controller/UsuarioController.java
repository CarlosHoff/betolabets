package com.hoffmann.betolabets.controller;

import com.hoffmann.betolabets.domain.request.UsuarioRequest;
import com.hoffmann.betolabets.domain.response.UsuarioResponse;
import com.hoffmann.betolabets.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastro")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity cadastraUsuario(
            @RequestBody UsuarioRequest request) {
        usuarioService.createUsuario(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public UsuarioResponse buscaUsuario(
            @RequestParam String email) {
        return usuarioService.buscaUsuario(email);
    }
}
