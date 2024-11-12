package com.hoffmann.betolabets.domain.response;

public record UsuarioResponse(Long usuarioID, String nome, String apelido, String cpf, String celular, String email) {
}
