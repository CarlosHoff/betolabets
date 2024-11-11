package com.hoffmann.betolabets.domain.request;

import java.io.Serializable;


public record UsuarioRequest(String name, String apelido, String email, String celular,
                             String cpf, String senha) implements Serializable {
}