package com.hoffmann.betolabets.repository;

import com.hoffmann.betolabets.domain.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface  UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByEmail(String username);
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    Usuario buscarUsuarioPorEmail(@Param("email") String email);

}
