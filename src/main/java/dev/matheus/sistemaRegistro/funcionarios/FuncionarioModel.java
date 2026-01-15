/*
========================================================
Entity (Model) → representação do banco.
Representa a tabela tb_info_funcionarios, só o backend pode conhecer essa camada e
nunca deve vazar para o mundo externo.
========================================================
*/
package dev.matheus.sistemaRegistro.funcionarios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_info_funcionarios")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class FuncionarioModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String setor;
    private String cargo;
    private String email;
    private String telefone;
}
