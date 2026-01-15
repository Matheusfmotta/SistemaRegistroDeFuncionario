/*
========================================================
Repository → somente acesso ao banco e nenhuma regra de negócio
========================================================
*/
package dev.matheus.sistemaRegistro.funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel,Long> {
}
