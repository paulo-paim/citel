package com.BancoDeSangue.BancoDeSangue.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "pessoa")
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    public String nome;

    @Id
    public String cpf;

    public String rg;
    public String data_nasc;
    public String sexo;
    public String mae;
    public String pai;
    public String email;
    public String cep;
    public String endereco;
    public int numero;
    public String bairro;
    public String cidade;
    public String estado;
    public String telefone_fixo;
    public String celular;
    public double altura;
    public double peso;
    public String tipo_sanguineo;

}
