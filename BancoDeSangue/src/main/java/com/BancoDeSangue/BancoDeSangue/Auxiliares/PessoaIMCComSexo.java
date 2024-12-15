package com.BancoDeSangue.BancoDeSangue.Auxiliares;

import java.math.BigDecimal;

public class PessoaIMCComSexo {

    private String nome;
    private Long idade;
    private Short peso;
    private BigDecimal altura;
    private BigDecimal imc;
    private String sexo;

    public PessoaIMCComSexo(String nome, Long idade, Short peso, BigDecimal altura, BigDecimal imc, String sexo) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.imc = imc;
        this.sexo = sexo;
    }

    public PessoaIMCComSexo() {
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getImc() {
        return imc;
    }

    public void setImc(BigDecimal imc) {
        this.imc = imc;
    }

    public Short getPeso() {
        return peso;
    }

    public void setPeso(Short peso) {
        this.peso = peso;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public Long getIdade() {
        return idade;
    }

    public void setIdade(Long idade) {
        this.idade = idade;
    }
}
