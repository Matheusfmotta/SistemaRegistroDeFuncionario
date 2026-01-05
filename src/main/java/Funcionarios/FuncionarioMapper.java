package Funcionarios;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") //"spring" permite usar @AutoWired
public interface FuncionarioMapper {
    FuncionarioMapper INSTANCE = Mappers.getMapper(FuncionarioMapper.class);

    //Conversão Model para DTO
    FuncionarioDTO toDTO(FuncionarioModel funcionarioModel);

    //Conversão DTO para o Model
    FuncionarioModel toModel(FuncionarioDTO funcionarioDTO);
}
