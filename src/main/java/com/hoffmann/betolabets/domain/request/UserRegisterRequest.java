package com.hoffmann.betolabets.domain.request;

import java.io.Serializable;


public record UserRegisterRequest(String name, String apelido, String email, String celular,
                                  String cpf, String senha) implements Serializable {
}