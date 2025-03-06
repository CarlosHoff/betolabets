package com.hoffmann.betolabets.service;

import com.hoffmann.betolabets.domain.dto.BetsDto;
import com.hoffmann.betolabets.domain.entitys.BetEntity;
import com.hoffmann.betolabets.domain.entitys.UserEntity;
import com.hoffmann.betolabets.domain.request.BetRequest;
import com.hoffmann.betolabets.domain.response.BetResponse;
import com.hoffmann.betolabets.repository.BetRepository;
import com.hoffmann.betolabets.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class BetService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BetRepository betRepository;

    public void cadastraApostas(BetRequest request, Long usuarioID) {
        UserEntity usuario = userRepository.findById(usuarioID)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + usuarioID));

        for (List<Long> numeroAposta : request.numeros()) {
            if (numeroAposta == null || numeroAposta.size() != 10) {
                throw new IllegalArgumentException("Cada aposta deve conter exatamente 10 números.");
            }

            BetEntity betEntity = getBetEntity(numeroAposta, usuario);

            betRepository.save(betEntity);
        }
    }

    public BetResponse buscaAposta(Long userID) {
        List<BetEntity> listBets = betRepository.findByUsuarioUsuarioID(userID);

        List<BetsDto> betsDtoList = listBets.stream()
                .map(BetsDto::fromEntity)
                .toList();

        return new BetResponse(userID, betsDtoList);
    }



    private static BetEntity getBetEntity(List<Long> longList, UserEntity usuario) {
        if (longList == null || longList.size() < 10) {
            throw new IllegalArgumentException("A lista deve conter 10 números.");
        }

        BetEntity betEntity = new BetEntity();
        List<Consumer<Long>> setters = List.of(
                betEntity::setDezenaUm, betEntity::setDezenaDois, betEntity::setDezenaTres,
                betEntity::setDezenaQuatro, betEntity::setDezenaCinco, betEntity::setDezenaSeis,
                betEntity::setDezenaSete, betEntity::setDezenaOito, betEntity::setDezenaNove,
                betEntity::setDezenaDez
        );

        IntStream.range(0, 10).forEach(i -> setters.get(i).accept(longList.get(i)));

        betEntity.setUsuario(usuario);
        return betEntity;
    }

}
