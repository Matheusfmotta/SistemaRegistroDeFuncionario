/*
========================================================
DTO → o que entra e sai da API. Representa os dados que a API expõe.
Informações que podem mudar sem quebrar o banco.
========================================================
*/
package dev.matheus.sistemaRegistro.funcionarios;

public record FuncionarioDTO(Long id, String nome, String setor, String cargo, String email, String telefone){
}
