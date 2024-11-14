package com.hoffmann.betolabets.repository;

import com.hoffmann.betolabets.domain.entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserDetails findByEmail(String username);
    @Query("SELECT u FROM UserEntity u WHERE u.email = :email")
    UserEntity buscarUsuarioPorEmail(@Param("email") String email);

}
