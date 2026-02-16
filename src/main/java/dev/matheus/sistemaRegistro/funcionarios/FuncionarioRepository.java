/*
========================================================
Repository → somente acesso ao banco e nenhuma regra de negócio

Repository.findAll()/ Repository.findById(id)/ Repository.delete()
========================================================
*/
package dev.matheus.sistemaRegistro.funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel,Long> {
}
