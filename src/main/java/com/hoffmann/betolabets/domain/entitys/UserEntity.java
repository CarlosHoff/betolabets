package com.hoffmann.betolabets.domain.entitys;


import com.hoffmann.betolabets.domain.enums.UserRole;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "USERS")
public class UserEntity implements UserDetails {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SQ_USERS")
    @SequenceGenerator(sequenceName = "SQ_USERS", allocationSize = 1, name = "SQ_USERS")
    private Long usuarioID;

    @Column(length = 50, name = "NOME", nullable = false)
    private String nome;

    @Column(length = 50, name = "APELIDO", nullable = false)
    private String apelido;

    @Column(length = 14, name = "CPF", nullable = false)
    private String cpf;

    @Column(name = "SENHA", nullable = false)
    private String senha;

    @Column(length = 11, name = "CELULAR", nullable = false)
    private String celular;

    @Column(length = 100, name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(length = 100, name = "ROLE")
    private UserRole role;

    public Long getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Long usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
