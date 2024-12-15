package com.BancoDeSangue.BancoDeSangue.Auxiliares;

import java.math.BigDecimal;

public class MediaIdadeTipoSanguineo {

    private String tipo_sanguineo;
    private BigDecimal media_idade;

    public MediaIdadeTipoSanguineo(String tipo_sanguineo, BigDecimal media_idade) {
        this.tipo_sanguineo = tipo_sanguineo;
        this.media_idade = media_idade;
    }

    public MediaIdadeTipoSanguineo() {
    }

    public String getTipo_sanguineo() {
        return tipo_sanguineo;
    }

    public void setTipo_sanguineo(String tipo_sanguineo) {
        this.tipo_sanguineo = tipo_sanguineo;
    }

    public BigDecimal getMedia_idade() {
        return media_idade;
    }

    public void setMedia_idade(BigDecimal media_idade) {
        this.media_idade = media_idade;
    }
}
