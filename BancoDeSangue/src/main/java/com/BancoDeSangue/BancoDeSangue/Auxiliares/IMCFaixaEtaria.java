package com.BancoDeSangue.BancoDeSangue.Auxiliares;

import java.math.BigDecimal;

public class IMCFaixaEtaria {

    private int idadeMinima;
    private int idadeMaxima;
    BigDecimal mediaIMC;

    public IMCFaixaEtaria(int idadeMinima, BigDecimal mediaIMC, int idadeMaxima) {
        this.idadeMinima = idadeMinima;
        this.mediaIMC = mediaIMC;
        this.idadeMaxima = idadeMaxima;
    }

    public IMCFaixaEtaria() {
    }

    public int getIdadeMinima() {
        return idadeMinima;
    }

    public void setIdadeMinima(int idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    public BigDecimal getMediaIMC() {
        return mediaIMC;
    }

    public void setMediaIMC(BigDecimal mediaIMC) {
        this.mediaIMC = mediaIMC;
    }

    public int getIdadeMaxima() {
        return idadeMaxima;
    }

    public void setIdadeMaxima(int idadeMaxima) {
        this.idadeMaxima = idadeMaxima;
    }
}
