package com.BancoDeSangue.BancoDeSangue.Services;

import com.BancoDeSangue.BancoDeSangue.Auxiliares.*;
import com.BancoDeSangue.BancoDeSangue.Entities.Pessoa;
import com.BancoDeSangue.BancoDeSangue.Repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> getAll(){
        return this.pessoaRepository.findAll();
    }

    public List<PessoaEstado> getQuantidadePorEstado() {
        List<Object[]> resultados = pessoaRepository.getPessoasPorEstado();
        List<PessoaEstado> listaEstados = new ArrayList<>();

        for (Object[] resultado : resultados) {
            String estado = (String) resultado[0];
            Long quantidade = (Long) resultado[1];
            listaEstados.add(new PessoaEstado(estado, quantidade));
        }

        return listaEstados;
    }


    public List<IMCFaixaEtaria> getMediaIMCFaixaEtaria(){
        List<Object[]> imcPessoas = pessoaRepository.getImcPessoa();
        List<PessoaIMC> listaIMCPessoas = new ArrayList<>();
        List<IMCFaixaEtaria> imcFaixaEtaria = new ArrayList<>();

        for(Object[] obj : imcPessoas){
            String nome = (String) obj[0];
            Long idade = (Long) obj[1];
            Short peso = (Short) obj[2];
            BigDecimal altura = (BigDecimal) obj[3];
            BigDecimal imc = (BigDecimal) obj[4];
            listaIMCPessoas.add(new PessoaIMC(nome,idade,peso, altura, imc));
        }

        // listaIMCPessoas esta com o imc individual de cada pessoa

        int idadeAnalisada = 0;
        for(int i=0; i<listaIMCPessoas.size();i++){

            idadeAnalisada = (int) listaIMCPessoas.get(i).getIdade().intValue() / 10;
            boolean estaDentroDaFaixa = true;
            BigDecimal somatoriaIMC = BigDecimal.ZERO;
            int idadeMin = 0;
            int idadeMax = 0;
            int contador = 0;
            int j = i;
            for(j=i; j<listaIMCPessoas.size() && estaDentroDaFaixa; j++){
                if((listaIMCPessoas.get(j).getIdade().intValue() / 10) == idadeAnalisada){
                    contador++;
                    somatoriaIMC =  somatoriaIMC.add(listaIMCPessoas.get(j).getImc());
                }
                else
                    estaDentroDaFaixa = false;
            }
            idadeMin = listaIMCPessoas.get(i).getIdade().intValue();
            idadeMax = listaIMCPessoas.get(j-2).getIdade().intValue();
            i = j+1;

            imcFaixaEtaria.add(new IMCFaixaEtaria(idadeMin,new BigDecimal(somatoriaIMC.doubleValue() / contador),idadeMax));

        }
        return imcFaixaEtaria;
    }

    public List<PercentualObedidade> getPercentualObesidade(){
        List<Object[]> imcPessoas = pessoaRepository.getImcPessoaComSexo();
        List<PessoaIMCComSexo> listaIMCPessoasComSexo = new ArrayList<>();

        for(Object[] obj : imcPessoas){
            String nome = (String) obj[0];
            Long idade = (Long) obj[1];
            Short peso = (Short) obj[2];
            BigDecimal altura = (BigDecimal) obj[3];
            BigDecimal imc = (BigDecimal) obj[4];
            String sexo = (String) obj[5];
            listaIMCPessoasComSexo.add(new PessoaIMCComSexo(nome,idade,peso,altura,imc,sexo));
        }

        int homemObeso = 0;
        int mulherObeso = 0;
        int homem=0;
        int mulher=0;

        for(int i=0; i<listaIMCPessoasComSexo.size(); i++){
            if (listaIMCPessoasComSexo.get(i).getSexo().equals("Masculino")) homem++;
            if(listaIMCPessoasComSexo.get(i).getSexo().equals("Feminino")) mulher++;
            if(listaIMCPessoasComSexo.get(i).getSexo().equals("Masculino") && listaIMCPessoasComSexo.get(i).getImc().intValue() > 30) homemObeso++;
            if(listaIMCPessoasComSexo.get(i).getSexo().equals("Feminino") && listaIMCPessoasComSexo.get(i).getImc().intValue() > 30) mulherObeso++;
        }

        List<PercentualObedidade> retorno = new ArrayList<>();
        PercentualObedidade retornoMulher = new PercentualObedidade("Feminino",mulher,mulherObeso);
        PercentualObedidade retornoHomem = new PercentualObedidade("Masculino",homem,homemObeso);

        retorno.add(retornoMulher);
        retorno.add(retornoHomem);

        return retorno;
    }

    public List<MediaIdadeTipoSanguineo> getMediaIdadeTipoSanguineo(){

        List<Object[]> mediaIdadePessoas = pessoaRepository.getmediaIdadePorTipoSanguineo();
        List<MediaIdadeTipoSanguineo> mediaIdadePorTipoSanguineo = new ArrayList<>();

        for(Object[] obj : mediaIdadePessoas){
            String tipo_sanguineo = (String) obj[0];
            BigDecimal idade = (BigDecimal) obj[1];

            mediaIdadePorTipoSanguineo.add(new MediaIdadeTipoSanguineo(tipo_sanguineo,idade));
        }

        return mediaIdadePorTipoSanguineo;
    }


    public InformacoesDoadoresDeSangue buscarDoadores(String cpf){

        Object[] consulta = this.pessoaRepository.buscarInformacoesPorCpf(cpf);
        Object[] consulta2 = (Object[]) consulta[0];
        InformacoesDoadoresDeSangue pessoa = new InformacoesDoadoresDeSangue();

        System.out.println((String)consulta2[0]);
        pessoa.setNome((String)consulta2[0]);
        pessoa.setTipo_sanguineo((String) consulta2[1]);
        pessoa.setPode_doar_para((String) consulta2[2]);
        pessoa.setPode_receber_de((String) consulta2[3]);
        pessoa.setQuantidade_doadores((Long) consulta2[4]);

        return pessoa;
    }





}
