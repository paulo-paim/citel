package com.BancoDeSangue.BancoDeSangue.Controllers;

import com.BancoDeSangue.BancoDeSangue.Auxiliares.*;
import com.BancoDeSangue.BancoDeSangue.Entities.Pessoa;
import com.BancoDeSangue.BancoDeSangue.Services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/pessoa")
    public ResponseEntity<List<Pessoa>> getPessoa(){
        return new ResponseEntity<List<Pessoa>>(this.pessoaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/teste")
    public String teste(){
        return "TESTE";
    }

//    @GetMapping("/pessoas-por-estado")
//    public Map<String, Long> pessoasPorEstado(){
//        return this.pessoaService.pessoasPorEstado();
//    }

    @GetMapping("/pessoas-por-estado")
    public List<PessoaEstado> pessoasPorEstado(){
        return this.pessoaService.getQuantidadePorEstado();
    }

    @GetMapping("/imc-por-faixa-etaria")
    public List<IMCFaixaEtaria> getImcPorFaixaEtaria(){
        return this.pessoaService.getMediaIMCFaixaEtaria();
    }

    @GetMapping("/percentual-obesidade")
    public List<PercentualObedidade> getPercentualObesidade(){
        return this.pessoaService.getPercentualObesidade();
    }

    @GetMapping("/media-idade-tipo-sanguineo")
    public List<MediaIdadeTipoSanguineo> getIdadeTipoSanguineo(){
        return this.pessoaService.getMediaIdadeTipoSanguineo();
    }

    @GetMapping("/pesquisar-doadores")
    public InformacoesDoadoresDeSangue encontrar(@RequestBody CpfRequest cpf){
        System.out.println(cpf);
        return this.pessoaService.buscarDoadores(cpf.getCpf());
    }
}
