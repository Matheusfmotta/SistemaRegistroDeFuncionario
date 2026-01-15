/*
========================================================
Converte (Entity ↔ DTO)
Uso do mapstruct para evitar código manual repetitivo
========================================================
*/
package dev.matheus.sistemaRegistro.funcionarios;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") //"spring" permite usar @AutoWired
public interface FuncionarioMapper {
    FuncionarioMapper INSTANCE = Mappers.getMapper(FuncionarioMapper.class);

    //Conversão Model para DTO (toDTO)
    FuncionarioDTO toDTO(FuncionarioModel funcionarioModel);

    //Conversão DTO para o Model (toModel)
    FuncionarioModel toModel(FuncionarioDTO funcionarioDTO);
}
