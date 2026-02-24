/*
========================================================
CONTROLLER RECEBE AS REQUISIÇÕES HTTP E ENCAMINHA PARA O SERVICE QUE RETORNA UMA RESPOSTA.
CONTROLLER TEM CONTATO COM O SERVICE, O SPRING CONVERTE AUTOMATICAMENTE OS DADOS QUE RETORNAM DO SERVICE EM JSON.
========================================================
*/
package dev.matheus.sistemaRegistro.funcionarios;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/funcionarios") //PREFIXO DOS MÉTODOS DA CLASSE ABAIXO
@Tag(
        name = "Funcionários",
        description = "Endpoints responsáveis pelo gerenciamento de funcionários (CRUD)"
)
public class FuncionarioController {

    //OBJETO SERVICE
    private final FuncionarioService funcionarioService;

    //MOSTRAR EM LISTA TODOS USUÁRIOS
    @Operation(
            summary = "Listar todos os funcionários",
            description = "Retorna uma lista com todos os funcionários cadastrados no sistema."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de funcionários retornada com sucesso")
    })
    @GetMapping
    public List<FuncionarioDTO> listarUsuariosCadastrados(){
        return funcionarioService.listarUsuariosCadastrados();
    }

    //BUSCAR USUÁRIO POR ID
    @Operation(
            summary = "Buscar funcionário por ID",
            description = "Retorna os dados de um funcionário específico a partir do seu identificador."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Funcionário encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado")
    })
    @GetMapping("/{id}")
    public FuncionarioDTO listarUsuarioPorId(@PathVariable Long id){
        return funcionarioService.listarUsuarioPorId(id);
    }

    //DELETAR POR ID
    @Operation(
            summary = "Excluir funcionário",
            description = "Remove um funcionário do sistema a partir do seu ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Funcionário removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado")
    })
    @DeleteMapping("/{id}")
    public void deletarUsuarioPorId(@PathVariable Long id){
        funcionarioService.deletarUsuarioPorId(id);
    }

    //CRIAR USUÁRIO
    @Operation(
            summary = "Criar novo funcionário",
            description = "Cria um novo funcionário no sistema com base nos dados informados."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Funcionário criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para criação do funcionário")
    })
    @PostMapping
    public FuncionarioDTO criarUsuario(@RequestBody FuncionarioDTO dto){
        return funcionarioService.criarUsuario(dto);
    }

    //ATUALIZAR TODAS INFORMAÇÕES DO USUÁRIO
    @Operation(
            summary = "Atualizar funcionário (PUT)",
            description = "Atualiza todas as informações de um funcionário existente. " +
                    "Os dados enviados substituem completamente os dados atuais."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Funcionário atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado")
    })
    @PutMapping("/{id}")
    public FuncionarioDTO atualizarUsuario(
            @PathVariable Long id,
            @RequestBody FuncionarioDTO dto){
        return funcionarioService.atualizarUsuario(id, dto);
    }

    //ATUALIZAR PARCIALMENTE AS INFORMAÇÕES DO USUÁRIO
    @Operation(
            summary = "Atualizar funcionário parcialmente (PATCH)",
            description = "Atualiza apenas os campos informados do funcionário. " +
                    "Campos não enviados permanecem inalterados."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Funcionário atualizado parcialmente com sucesso"),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado")
    })
    @PatchMapping("/{id}")
    public FuncionarioDTO atualizarUsuarioParcial(
            @PathVariable Long id,
            @RequestBody FuncionarioDTO dto) {

        return funcionarioService.atualizarUsuarioParcial(id, dto);
    }
}
