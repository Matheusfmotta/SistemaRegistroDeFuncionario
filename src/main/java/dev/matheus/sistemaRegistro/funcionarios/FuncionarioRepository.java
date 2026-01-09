package dev.matheus.sistemaRegistro.funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel,Long> {
}
