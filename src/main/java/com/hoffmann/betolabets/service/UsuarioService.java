package com.hoffmann.betolabets.service;

import com.hoffmann.betolabets.domain.entitys.Usuario;
import com.hoffmann.betolabets.domain.enums.UserRole;
import com.hoffmann.betolabets.domain.request.UsuarioRequest;
import com.hoffmann.betolabets.domain.response.UsuarioResponse;
import com.hoffmann.betolabets.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUsuario(UsuarioRequest request) {
        Usuario usuario = new Usuario();
        usuario.setNome(request.name());
        usuario.setApelido(request.apelido());
        usuario.setCpf(request.cpf());
        usuario.setCelular(request.celular());
        usuario.setEmail(request.email());
        usuario.setSenha(passwordEncoder.encode(request.senha()));
        usuario.setRole(UserRole.ADMIN);

        usuarioRepository.save(usuario);
    }

    public UsuarioResponse buscaUsuario(String email) {
        Usuario usuario = usuarioRepository.buscarUsuarioPorEmail(email);
        return new UsuarioResponse(usuario.getUsuarioID(), usuario.getNome(), usuario.getApelido(), usuario.getCpf(), usuario.getCelular(), usuario.getEmail());
    }
}
