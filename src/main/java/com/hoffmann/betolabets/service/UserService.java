package com.hoffmann.betolabets.service;

import com.hoffmann.betolabets.domain.entitys.UserEntity;
import com.hoffmann.betolabets.domain.enums.UserRole;
import com.hoffmann.betolabets.domain.request.UserRegisterRequest;
import com.hoffmann.betolabets.domain.response.ProfileResponse;
import com.hoffmann.betolabets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUsuario(UserRegisterRequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setNome(request.name());
        userEntity.setApelido(request.apelido());
        userEntity.setCpf(request.cpf());
        userEntity.setCelular(request.celular());
        userEntity.setEmail(request.email());
        userEntity.setSenha(passwordEncoder.encode(request.senha()));
        userEntity.setRole(UserRole.ADMIN);

        userRepository.save(userEntity);
    }

    public ProfileResponse buscaUsuario(Long userID) {
        UserEntity userEntity = userRepository.findById(userID).orElseThrow();
        return new ProfileResponse(userEntity.getNome(), userEntity.getApelido(), userEntity.getCelular(), userEntity.getEmail());
    }
}
