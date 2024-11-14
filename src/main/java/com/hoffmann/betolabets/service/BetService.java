package com.hoffmann.betolabets.service;

import com.hoffmann.betolabets.domain.dto.UserDto;
import com.hoffmann.betolabets.domain.entitys.BetEntity;
import com.hoffmann.betolabets.domain.request.BetRequest;
import com.hoffmann.betolabets.domain.response.BetResponse;
import com.hoffmann.betolabets.repository.BetRepository;
import com.hoffmann.betolabets.repository.UserRepository;
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

    public void cadastraAposta(BetRequest request, Long usuarioID) {
        BetEntity betEntity = new BetEntity(request);
        betEntity.setUsuario(userRepository.findById(usuarioID).orElseThrow());
        betRepository.save(betEntity);
    }

    public List<BetResponse> buscaAposta(Long userID) {
        List<BetEntity> listBets = betRepository.findByUsuarioUsuarioID(userID);
        return listBets.stream().map((BetEntity bet) -> new BetResponse(bet.getApostaID(), bet.getDezenaUm(),
                        bet.getDezenaDois(), bet.getDezenaTres(), bet.getDezenaQuatro(), bet.getDezenaCinco(),
                        bet.getDezenaSeis(), bet.getDezenaSete(), bet.getDezenaOito(), bet.getDezenaNove(),
                        bet.getDezenaDez(), new UserDto(bet.getUsuario())))
                .collect(Collectors.toList());

    }
}
