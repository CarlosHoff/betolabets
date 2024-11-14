package com.hoffmann.betolabets.repository;

import com.hoffmann.betolabets.domain.entitys.BetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetRepository extends JpaRepository<BetEntity, Long> {

    List<BetEntity> findByUsuarioUsuarioID(Long userId);

}
