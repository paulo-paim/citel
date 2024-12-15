package com.BancoDeSangue.BancoDeSangue.Auxiliares;

import java.math.BigDecimal;

public class InformacoesDoadoresDeSangue {

    private String nome;
    private String tipo_sanguineo;
    private String pode_doar_para;
    private String pode_receber_de;
    private Long quantidade_doadores;

    public InformacoesDoadoresDeSangue(String nome, String tipo_sanguineo, String pode_receber_de, String pode_doar_para, Long quantidade_doadores) {
        this.nome = nome;
        this.tipo_sanguineo = tipo_sanguineo;
        this.pode_receber_de = pode_receber_de;
        this.pode_doar_para = pode_doar_para;
        this.quantidade_doadores = quantidade_doadores;
    }

    public InformacoesDoadoresDeSangue() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo_sanguineo() {
        return tipo_sanguineo;
    }

    public void setTipo_sanguineo(String tipo_sanguineo) {
        this.tipo_sanguineo = tipo_sanguineo;
    }

    public String getPode_doar_para() {
        return pode_doar_para;
    }

    public void setPode_doar_para(String pode_doar_para) {
        this.pode_doar_para = pode_doar_para;
    }

    public String getPode_receber_de() {
        return pode_receber_de;
    }

    public void setPode_receber_de(String pode_receber_de) {
        this.pode_receber_de = pode_receber_de;
    }

    public Long getQuantidade_doadores() {
        return quantidade_doadores;
    }

    public void setQuantidade_doadores(Long quantidade_doadores) {
        this.quantidade_doadores = quantidade_doadores;
    }
}
