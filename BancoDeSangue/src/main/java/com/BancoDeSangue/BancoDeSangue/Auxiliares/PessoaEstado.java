package com.BancoDeSangue.BancoDeSangue.Auxiliares;

import lombok.*;


public class PessoaEstado {

     private String estado;
     private Long quantidade;

     public PessoaEstado(String estado, Long quantidade) {
          this.estado = estado;
          this.quantidade = quantidade;
     }

     public String getEstado() {
          return estado;
     }

     public void setEstado(String estado) {
          this.estado = estado;
     }

     public Long getQuantidade() {
          return quantidade;
     }

     public void setQuantidade(Long quantidade) {
          this.quantidade = quantidade;
     }
}
