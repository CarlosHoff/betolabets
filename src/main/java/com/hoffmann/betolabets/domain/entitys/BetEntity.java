package com.hoffmann.betolabets.domain.entitys;

import com.hoffmann.betolabets.domain.request.BetRequest;
import jakarta.persistence.*;

@Entity
@Table(name = "APOSTA")
public class BetEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SQ_APOSTA")
    @SequenceGenerator(sequenceName = "SQ_APOSTA", allocationSize = 1, name = "SQ_APOSTA")
    private Long apostaID;

    @Column(name = "DEZENA_UM")
    private Long dezenaUm;

    @Column(name = "DEZENA_DOIS")
    private Long dezenaDois;

    @Column(name = "DEZENA_TRES")
    private Long dezenaTres;

    @Column(name = "DEZENA_QUATRO")
    private Long dezenaQuatro;

    @Column(name = "DEZENA_CINCO")
    private Long dezenaCinco;

    @Column(name = "DEZENA_SEIS")
    private Long dezenaSeis;

    @Column(name = "DEZENA_SETE")
    private Long dezenaSete;

    @Column(name = "DEZENA_OITO")
    private Long dezenaOito;

    @Column(name = "DEZENA_NOVE")
    private Long dezenaNove;

    @Column(name = "DEZENA_DEZ")
    private Long dezenaDez;

    @ManyToOne
    @JoinColumn(name = "USERS")
    private UserEntity usuario;

    public Long getApostaID() {
        return apostaID;
    }

    public void setApostaID(Long apostaID) {
        this.apostaID = apostaID;
    }

    public Long getDezenaUm() {
        return dezenaUm;
    }

    public void setDezenaUm(Long dezenaUm) {
        this.dezenaUm = dezenaUm;
    }

    public Long getDezenaDois() {
        return dezenaDois;
    }

    public void setDezenaDois(Long dezenaDois) {
        this.dezenaDois = dezenaDois;
    }

    public Long getDezenaTres() {
        return dezenaTres;
    }

    public void setDezenaTres(Long dezenaTres) {
        this.dezenaTres = dezenaTres;
    }

    public Long getDezenaQuatro() {
        return dezenaQuatro;
    }

    public void setDezenaQuatro(Long dezenaQuatro) {
        this.dezenaQuatro = dezenaQuatro;
    }

    public Long getDezenaCinco() {
        return dezenaCinco;
    }

    public void setDezenaCinco(Long dezenaCinco) {
        this.dezenaCinco = dezenaCinco;
    }

    public Long getDezenaSeis() {
        return dezenaSeis;
    }

    public void setDezenaSeis(Long dezenaSeis) {
        this.dezenaSeis = dezenaSeis;
    }

    public Long getDezenaSete() {
        return dezenaSete;
    }

    public void setDezenaSete(Long dezenaSete) {
        this.dezenaSete = dezenaSete;
    }

    public Long getDezenaOito() {
        return dezenaOito;
    }

    public void setDezenaOito(Long dezenaOito) {
        this.dezenaOito = dezenaOito;
    }

    public Long getDezenaNove() {
        return dezenaNove;
    }

    public void setDezenaNove(Long dezenaNove) {
        this.dezenaNove = dezenaNove;
    }

    public Long getDezenaDez() {
        return dezenaDez;
    }

    public void setDezenaDez(Long dezenaDez) {
        this.dezenaDez = dezenaDez;
    }

    public UserEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UserEntity usuario) {
        this.usuario = usuario;
    }
}
