package com.hoffmann.betolabets.domain.dto;

import com.hoffmann.betolabets.domain.entitys.UserEntity;
import com.hoffmann.betolabets.domain.enums.UserRole;

public record UserDto(Long usuarioID, String nome, String apelido, String cpf, String senha, String celular,
                      String email, UserRole role) {

    public UserDto(UserEntity user) {
        this(user.getUsuarioID(), user.getNome(), user.getApelido(), user.getCpf(), user.getSenha(),
                user.getCelular(), user.getEmail(), user.getRole());
    }
}
