package com.hoffmann.betolabets.domain.dto;

import com.hoffmann.betolabets.domain.entitys.BetEntity;

public record BetsDto(Long apostaID, Long dezenaUm, Long dezenaDois, Long dezenaTres, Long dezenaQuatro,
                      Long dezenaCinco, Long dezenaSeis, Long dezenaSete, Long dezenaOito, Long dezenaNove,
                      Long dezenaDez) {

    public static BetsDto fromEntity(BetEntity bet) {
        return new BetsDto(
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
        );
    }
}
