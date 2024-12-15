
# Projeto CITEL

Desenvolvi uma API para realizar as tarefas solicitadas.
Esta API faz o consumo de um banco de dados MySQL.

# Banco de dados
O banco de dados selecionado foi o MySQL e o script de criação encontra-se nos arquivos.
O banco é composto por uma única tabela que armazena as informações das pessoas.

```sql
CREATE DATABASE pessoal
create table Pessoa(
nome text,
cpf varchar(100) PRIMARY KEY,
rg text,
data_nascimento date,
sexo text,
mae text,
pai text,
email text,
cep,
endereco text,
numero int,
bairro text,
cidade text,
estado char(2),
telefone_fixo text,
celular text,
altura decimal(10,2),
peso SMALLINT,
tipo_sanguineo char(3)

);
```

Após a criação do banco, realizei o insert dos dados que vieram em formato JSON. Esta etapa adicionou 300 registros na tabela.

# Implementação da API

A implementação da API iniciou-se definindo as camadas do projeto. Segui a separação do modelo MVC, na qual os controllers lidam com as requisições HTTP, os Services implementam a lógica de negócio e os Repositories fazem o acesso a base de dados.

# FrontEnd

# Melhorias

Desenvolvendo o projeto pensei em alguns pontos que poderiam ser melhorados:
- Chave Primaria da tabela
Notei a necessidade de implementar uma chave primária que fosse um campo numérico, pois utilizei a chave primária como String. Em um cenário real deveria transformar o campo CPF (chave primária candidata) no tipo numérico e utiliza-lo como PK. Outra possibilidade seria implementar uma estratégia de geração de Ids, comumente utilizada em projetos.

- Melhor organização dos arquivos
Mesmo implementando o modelo MVC tive problemas devido a quantidade de arquivos que foram gerados. No final do projeto notei que se adotasse a abordagem de arquitetura VSA (vertical slice architecture) em conjunto com o MVC obteria uma melhor organização e simplicidade do projeto.

- Normalização dos Dados
Apesar de uma única tabela ter sido capaz de lidar com os dados, o melhor seria aplicar as regras de normalização de dados para separar as informações.  

- Tratamento de Erros (404, 500, etc)
Um ponto bastante importante que pensei após a finalização dos endpoints foi no tratamento de erros. Uma melhoria seria implementar as respostas para erros do tipo 404 (not found) e 500 (internal server error) para tratar os retornos para a aplicação.
