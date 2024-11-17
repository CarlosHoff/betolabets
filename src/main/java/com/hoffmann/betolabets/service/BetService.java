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
import java.util.stream.Collectors;

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
                .map(bet -> new BetsDto(
                        bet.getApostaID(),
                        bet.getDezenaUm(),
                        bet.getDezenaDois(),
                        bet.getDezenaTres(),
                        bet.getDezenaQuatro(),
                        bet.getDezenaCinco(),
                        bet.getDezenaSeis(),
                        bet.getDezenaSete(),
                        bet.getDezenaOito(),
                        bet.getDezenaNove(),
                        bet.getDezenaDez()
                ))
                .collect(Collectors.toList());

        return new BetResponse(userID, betsDtoList);
    }


    private static BetEntity getBetEntity(List<Long> longList, UserEntity usuario) {
        BetEntity betEntity = new BetEntity();
        betEntity.setDezenaUm(longList.get(0));
        betEntity.setDezenaDois(longList.get(1));
        betEntity.setDezenaTres(longList.get(2));
        betEntity.setDezenaQuatro(longList.get(3));
        betEntity.setDezenaCinco(longList.get(4));
        betEntity.setDezenaSeis(longList.get(5));
        betEntity.setDezenaSete(longList.get(6));
        betEntity.setDezenaOito(longList.get(7));
        betEntity.setDezenaNove(longList.get(8));
        betEntity.setDezenaDez(longList.get(9));
        betEntity.setUsuario(usuario);
        return betEntity;
    }
}
