/*
========================================================
1)Service → regras de negócio, a lógica.

2)Orquestra o Repository e o Mapper.
#Repository para buscar dados no banco.
#Mapper para converter Model ↔ DTO.

3)para um service funcionar ele precisa dos dois em forma de (objeto) e um (construtor)
com esses dois objetos declarados (usado lombok abaixo).

4)A partir disso é feita a criação dos métodos que devem usar tanto o Repository quanto o Mapper
#Return funcionarioRepository -> dados do banco em formato entity
#Steam -> percorrer a lista um por um
#Precisa converter a entity para no lugar dela retornar o DTO
#Map(funcionarioMapper::toDTO) -> Para cada FuncionarioModel(entity) transforma em FuncionarioDTO
#.toList() -> Juntar todos resultados em uma lista
========================================================
*/
package dev.matheus.sistemaRegistro.funcionarios;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioMapper funcionarioMapper;

    //BUSCAR TODOS USUÁRIOS E MOSTRAR EM LISTA
    public List<FuncionarioDTO> listarUsuariosCadastrados(){
        return funcionarioRepository.findAll()
                .stream()
                .map(funcionarioMapper::toDTO)
                .toList();
    }

    // #BUSCAR 1 USUÁRIO PELO SEU ID
    public FuncionarioDTO listarUsuarioPorId(Long id){
        FuncionarioModel funcionario = funcionarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Funcionario não encontrado"));
        return funcionarioMapper.toDTO(funcionario);
    }
}
