package com.BancoDeSangue.BancoDeSangue.Repositories;

import com.BancoDeSangue.BancoDeSangue.Auxiliares.InformacoesDoadoresDeSangue;
import com.BancoDeSangue.BancoDeSangue.Entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, String> {

    @Query(nativeQuery = true, value = "select estado, count(*) as quantidade from pessoal.pessoa group by estado order by 1")
    List<Object[]> getPessoasPorEstado();

    @Query(nativeQuery = true, value = "SELECT nome, data_nasc, TIMESTAMPDIFF(YEAR, data_nasc, CURDATE()) as idade, peso, altura FROM pessoal.pessoa where TIMESTAMPDIFF(YEAR, data_nasc, CURDATE())> :min and TIMESTAMPDIFF(YEAR, data_nasc, CURDATE())<= :max order by idade")
    List<Object[]> getIMCPorIdadeFiltrado(int min, int max);

    @Query(nativeQuery = true, value = "SELECT nome, TIMESTAMPDIFF(YEAR, data_nasc, CURDATE()) as idade, peso, altura, (peso / (altura * altura)) as imc FROM pessoal.pessoa order by idade")
    List<Object[]> getImcPessoa();

    @Query(nativeQuery = true, value = "SELECT nome, TIMESTAMPDIFF(YEAR, data_nasc, CURDATE()) as idade, peso, altura, (peso / (altura * altura)) as imc, sexo FROM pessoal.pessoa order by idade")
    List<Object[]> getImcPessoaComSexo();


    @Query(nativeQuery = true, value = """
            SELECT
                tipo_sanguineo,
                FLOOR(AVG(TIMESTAMPDIFF(YEAR, data_nasc, CURDATE()))) AS media_idade
            FROM
                pessoa
            GROUP BY
                tipo_sanguineo
            """)
    List<Object[]> getmediaIdadePorTipoSanguineo();




    @Query(value = """
        SELECT
            p.nome,
            p.tipo_sanguineo,
            CASE
                WHEN p.tipo_sanguineo = 'O-' THEN 'O-, A-, B-, AB-'
                WHEN p.tipo_sanguineo = 'O+' THEN 'O+, A+, B+, AB+'
                WHEN p.tipo_sanguineo = 'A-' THEN 'A-, AB-'
                WHEN p.tipo_sanguineo = 'A+' THEN 'A+, AB+'
                WHEN p.tipo_sanguineo = 'B-' THEN 'B-, AB-'
                WHEN p.tipo_sanguineo = 'B+' THEN 'B+, AB+'
                WHEN p.tipo_sanguineo = 'AB-' THEN 'AB-'
                WHEN p.tipo_sanguineo = 'AB+' THEN 'AB+'
                ELSE 'N/A'
            END AS pode_doar_para,
            CASE
                WHEN p.tipo_sanguineo = 'O-' THEN 'O-'
                WHEN p.tipo_sanguineo = 'O+' THEN 'O-, O+'
                WHEN p.tipo_sanguineo = 'A-' THEN 'O-, A-'
                WHEN p.tipo_sanguineo = 'A+' THEN 'O-, O+, A-, A+'
                WHEN p.tipo_sanguineo = 'B-' THEN 'O-, B-'
                WHEN p.tipo_sanguineo = 'B+' THEN 'O-, O+, B-, B+'
                WHEN p.tipo_sanguineo = 'AB-' THEN 'O-, A-, B-, AB-'
                WHEN p.tipo_sanguineo = 'AB+' THEN 'O-, O+, A-, A+, B-, B+, AB-, AB+'
                ELSE 'N/A'
            END AS pode_receber_de,
            (
                SELECT COUNT(*)
                FROM pessoal.pessoa p2
                WHERE
                    CASE
                        WHEN p.tipo_sanguineo = 'O-' THEN p2.tipo_sanguineo = 'O-'
                        WHEN p.tipo_sanguineo = 'O+' THEN p2.tipo_sanguineo IN ('O-', 'O+')
                        WHEN p.tipo_sanguineo = 'A-' THEN p2.tipo_sanguineo IN ('O-', 'A-')
                        WHEN p.tipo_sanguineo = 'A+' THEN p2.tipo_sanguineo IN ('O-', 'O+', 'A-', 'A+')
                        WHEN p.tipo_sanguineo = 'B-' THEN p2.tipo_sanguineo IN ('O-', 'B-')
                        WHEN p.tipo_sanguineo = 'B+' THEN p2.tipo_sanguineo IN ('O-', 'O+', 'B-', 'B+')
                        WHEN p.tipo_sanguineo = 'AB-' THEN p2.tipo_sanguineo IN ('O-', 'A-', 'B-', 'AB-')
                        WHEN p.tipo_sanguineo = 'AB+' THEN p2.tipo_sanguineo IN ('O-', 'O+', 'A-', 'A+', 'B-', 'B+', 'AB-', 'AB+')
                        ELSE FALSE
                    END
            ) AS quantidade_doadores
        FROM pessoal.pessoa p
        WHERE p.cpf = :cpf
    """, nativeQuery = true)
    Object[] buscarInformacoesPorCpf(@Param("cpf") String cpf);
}
