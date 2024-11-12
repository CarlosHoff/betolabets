package com.hoffmann.betolabets.service;

import com.hoffmann.betolabets.domain.entitys.Usuario;
import com.hoffmann.betolabets.domain.enums.UserRole;
import com.hoffmann.betolabets.domain.request.UserRegisterRequest;
import com.hoffmann.betolabets.domain.response.ProfileResponse;
import com.hoffmann.betolabets.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUsuario(UserRegisterRequest request) {
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

    public ProfileResponse buscaUsuario(String email) {
        Usuario usuario = usuarioRepository.buscarUsuarioPorEmail(email);
        return new ProfileResponse(usuario.getNome(), usuario.getApelido(), usuario.getCelular(), usuario.getEmail());
    }
}
