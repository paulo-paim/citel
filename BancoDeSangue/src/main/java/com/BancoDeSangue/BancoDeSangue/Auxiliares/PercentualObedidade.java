package com.BancoDeSangue.BancoDeSangue.Auxiliares;

public class PercentualObedidade {

    private String sexo;
    private int quantidadeTotal;
    private int quantidadeObeso;
    private double percentualObesidade;

    public PercentualObedidade(String sexo, int quantidadeTotal, int quantidadeObeso) {
        this.sexo = sexo;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeObeso = quantidadeObeso;
        this.percentualObesidade = (double) this.quantidadeObeso / this.getQuantidadeTotal();
    }

    public PercentualObedidade() {
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public int getQuantidadeObeso() {
        return quantidadeObeso;
    }

    public void setQuantidadeObeso(int quantidadeObeso) {
        this.quantidadeObeso = quantidadeObeso;
    }

    public double getPercentualObesidade() {
        return percentualObesidade;
    }

    public void setPercentualObesidade(double percentualObesidade) {
        this.percentualObesidade = percentualObesidade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
