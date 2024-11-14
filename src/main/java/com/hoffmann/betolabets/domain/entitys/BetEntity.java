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

    @Column(name = "DEZENA_UM_FLAG")
    private Boolean dezenaUmFlag;

    @Column(name = "DEZENA_DOIS")
    private Long dezenaDois;

    @Column(name = "DEZENA_DOIS_FLAG")
    private Boolean dezenaDoisFlag;

    @Column(name = "DEZENA_TRES")
    private Long dezenaTres;

    @Column(name = "DEZENA_TRES_FLAG")
    private Boolean dezenaTresFlag;

    @Column(name = "DEZENA_QUATRO")
    private Long dezenaQuatro;

    @Column(name = "DEZENA_QUATRO_FLAG")
    private Boolean dezenaQuatroFlag;

    @Column(name = "DEZENA_CINCO")
    private Long dezenaCinco;

    @Column(name = "DEZENA_CINCO_FLAG")
    private Boolean dezenaCincoFlag;

    @Column(name = "DEZENA_SEIS")
    private Long dezenaSeis;

    @Column(name = "DEZENA_SEIS_FLAG")
    private Boolean dezenaSeisFlag;

    @Column(name = "DEZENA_SETE")
    private Long dezenaSete;

    @Column(name = "DEZENA_SETE_FLAG")
    private Boolean dezenaSeteFlag;

    @Column(name = "DEZENA_OITO")
    private Long dezenaOito;

    @Column(name = "DEZENA_OITO_FLAG")
    private Boolean dezenaOitoFlag;

    @Column(name = "DEZENA_NOVE")
    private Long dezenaNove;

    @Column(name = "DEZENA_NOVE_FLAG")
    private Boolean dezenaNoveFlag;

    @Column(name = "DEZENA_DEZ")
    private Long dezenaDez;

    @Column(name = "DEZENA_DEZ_FLAG")
    private Boolean dezenaDezFlag;

    @ManyToOne
    @JoinColumn(name = "USERS")
    private UserEntity usuario;

    public BetEntity(BetRequest request) {
        this.dezenaUm = request.numeros().get(0);
        this.dezenaDois = request.numeros().get(1);
        this.dezenaTres = request.numeros().get(2);
        this.dezenaQuatro = request.numeros().get(3);
        this.dezenaCinco = request.numeros().get(4);
        this.dezenaSeis = request.numeros().get(5);
        this.dezenaSete = request.numeros().get(6);
        this.dezenaOito = request.numeros().get(7);
        this.dezenaNove = request.numeros().get(8);
        this.dezenaDez = request.numeros().get(9);
    }

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

    public Boolean getDezenaUmFlag() {
        return dezenaUmFlag;
    }

    public void setDezenaUmFlag(Boolean dezenaUmFlag) {
        this.dezenaUmFlag = dezenaUmFlag;
    }

    public Long getDezenaDois() {
        return dezenaDois;
    }

    public void setDezenaDois(Long dezenaDois) {
        this.dezenaDois = dezenaDois;
    }

    public Boolean getDezenaDoisFlag() {
        return dezenaDoisFlag;
    }

    public void setDezenaDoisFlag(Boolean dezenaDoisFlag) {
        this.dezenaDoisFlag = dezenaDoisFlag;
    }

    public Long getDezenaTres() {
        return dezenaTres;
    }

    public void setDezenaTres(Long dezenaTres) {
        this.dezenaTres = dezenaTres;
    }

    public Boolean getDezenaTresFlag() {
        return dezenaTresFlag;
    }

    public void setDezenaTresFlag(Boolean dezenaTresFlag) {
        this.dezenaTresFlag = dezenaTresFlag;
    }

    public Long getDezenaQuatro() {
        return dezenaQuatro;
    }

    public void setDezenaQuatro(Long dezenaQuatro) {
        this.dezenaQuatro = dezenaQuatro;
    }

    public Boolean getDezenaQuatroFlag() {
        return dezenaQuatroFlag;
    }

    public void setDezenaQuatroFlag(Boolean dezenaQuatroFlag) {
        this.dezenaQuatroFlag = dezenaQuatroFlag;
    }

    public Long getDezenaCinco() {
        return dezenaCinco;
    }

    public void setDezenaCinco(Long dezenaCinco) {
        this.dezenaCinco = dezenaCinco;
    }

    public Boolean getDezenaCincoFlag() {
        return dezenaCincoFlag;
    }

    public void setDezenaCincoFlag(Boolean dezenaCincoFlag) {
        this.dezenaCincoFlag = dezenaCincoFlag;
    }

    public Long getDezenaSeis() {
        return dezenaSeis;
    }

    public void setDezenaSeis(Long dezenaSeis) {
        this.dezenaSeis = dezenaSeis;
    }

    public Boolean getDezenaSeisFlag() {
        return dezenaSeisFlag;
    }

    public void setDezenaSeisFlag(Boolean dezenaSeisFlag) {
        this.dezenaSeisFlag = dezenaSeisFlag;
    }

    public Long getDezenaSete() {
        return dezenaSete;
    }

    public void setDezenaSete(Long dezenaSete) {
        this.dezenaSete = dezenaSete;
    }

    public Boolean getDezenaSeteFlag() {
        return dezenaSeteFlag;
    }

    public void setDezenaSeteFlag(Boolean dezenaSeteFlag) {
        this.dezenaSeteFlag = dezenaSeteFlag;
    }

    public Long getDezenaOito() {
        return dezenaOito;
    }

    public void setDezenaOito(Long dezenaOito) {
        this.dezenaOito = dezenaOito;
    }

    public Boolean getDezenaOitoFlag() {
        return dezenaOitoFlag;
    }

    public void setDezenaOitoFlag(Boolean dezenaOitoFlag) {
        this.dezenaOitoFlag = dezenaOitoFlag;
    }

    public Long getDezenaNove() {
        return dezenaNove;
    }

    public void setDezenaNove(Long dezenaNove) {
        this.dezenaNove = dezenaNove;
    }

    public Boolean getDezenaNoveFlag() {
        return dezenaNoveFlag;
    }

    public void setDezenaNoveFlag(Boolean dezenaNoveFlag) {
        this.dezenaNoveFlag = dezenaNoveFlag;
    }

    public Long getDezenaDez() {
        return dezenaDez;
    }

    public void setDezenaDez(Long dezenaDez) {
        this.dezenaDez = dezenaDez;
    }

    public Boolean getDezenaDezFlag() {
        return dezenaDezFlag;
    }

    public void setDezenaDezFlag(Boolean dezenaDezFlag) {
        this.dezenaDezFlag = dezenaDezFlag;
    }

    public UserEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UserEntity usuario) {
        this.usuario = usuario;
    }
}
