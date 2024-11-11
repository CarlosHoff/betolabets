package com.hoffmann.betolabets.controller;

import com.hoffmann.betolabets.domain.request.UsuarioRequest;
import com.hoffmann.betolabets.domain.response.UsuarioResponse;
import com.hoffmann.betolabets.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/cadastraUsuario", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioResponse> cadastraUsuario(
            @RequestBody UsuarioRequest request) {
        usuarioService.createUsuario(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
