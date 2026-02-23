/*
========================================================
SERVICE RECEBE OS DADOS JÁ TRATADOS PELO CONTROLLER E APLICAR A LÓGICA E REGRAS DE NEGÓCIO.
SERVICE COORQUESTRA O REPOSITORY(BANCO DE DADOS) E MAPPER(CONVERSÕES)
========================================================
*/
package dev.matheus.sistemaRegistro.funcionarios;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    //OBJETO REPOSITORY
    private final FuncionarioRepository funcionarioRepository;

    //OBJETO MAPPER
    private final FuncionarioMapper funcionarioMapper;

    //BUSCA TODOS USUÁRIOS | CONVERTE PARA DTO | MOSTRA EM LISTA
    public List<FuncionarioDTO> listarUsuariosCadastrados(){
        return funcionarioRepository.findAll()
                .stream()
                .map(funcionarioMapper::toDTO)
                .toList();
    }

    //BUSCAR USUÁRIO PELO ID | CONVERTE PARA DTO
    public FuncionarioDTO listarUsuarioPorId(Long id){
        FuncionarioModel funcionario = funcionarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Funcionario não encontrado"));
        return funcionarioMapper.toDTO(funcionario);
    }

    //DELETA PELO ID
    public void deletarUsuarioPorId(Long id) {
        FuncionarioModel funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));
        funcionarioRepository.delete(funcionario);
    }

    //CRIA USUÁRIO | CONVERTE PARA MODEL | SALVA NO BANCO DE DADOS | CONVERTE PARA DTO
    public FuncionarioDTO criarUsuario(FuncionarioDTO dto){
        FuncionarioModel funcionario = funcionarioMapper.toModel(dto);
        FuncionarioModel salvo = funcionarioRepository.save(funcionario);
        return funcionarioMapper.toDTO(salvo);
    }

    //ALTERA TODOS ATRIBUTOS DO USUÁRIO | CONVERTE PARA MODEL | SALVA NO BANCO DE DADOS | CONVERTE PARA DTO
    public FuncionarioDTO atualizarUsuario(Long id, FuncionarioDTO dto){
        FuncionarioModel existente = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));

        FuncionarioModel atualizado = funcionarioMapper.toModel(dto);
        atualizado.setId(existente.getId());

        FuncionarioModel salvo = funcionarioRepository.save(atualizado);
        return funcionarioMapper.toDTO(salvo);
    }

    //ALTERA O ATRIBUTO SELECIONADO DO USUÁRIO | REGRA DE NEGÓCIO | SALVA NO BANCO DE DADOS | CONVERTE PARA DTO
    public FuncionarioDTO atualizarUsuarioParcial(Long id, FuncionarioDTO dto) {

        FuncionarioModel existente = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));

        if (dto.nome() != null) {
            existente.setNome(dto.nome());
        }
        if (dto.setor() != null) {
            existente.setSetor(dto.setor());
        }
        if (dto.cargo() != null) {
            existente.setCargo(dto.cargo());
        }
        if (dto.email() != null) {
            existente.setEmail(dto.email());
        }
        if (dto.telefone() != null) {
            existente.setTelefone(dto.telefone());
        }

        FuncionarioModel salvo = funcionarioRepository.save(existente);
        return funcionarioMapper.toDTO(salvo);
    }

}
