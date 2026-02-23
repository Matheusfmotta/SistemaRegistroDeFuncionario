/*
========================================================
CONTROLLER RECEBE AS REQUISIÇÕES HTTP E ENCAMINHA PARA O SERVICE QUE RETORNA UMA RESPOSTA.
CONTROLLER TEM CONTATO COM O SERVICE, O SPRING CONVERTE AUTOMATICAMENTE OS DADOS QUE RETORNAM DO SERVICE EM JSON.
========================================================
*/
package dev.matheus.sistemaRegistro.funcionarios;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/funcionarios") //PREFIXO DOS MÉTODOS DA CLASSE ABAIXO
public class FuncionarioController {

    //OBJETO SERVICE
    private final FuncionarioService funcionarioService;

    //MOSTRAR EM LISTA TODOS USUÁRIOS
    @GetMapping
    public List<FuncionarioDTO> listarUsuariosCadastrados(){
        return funcionarioService.listarUsuariosCadastrados();
    }

    //BUSCAR USUÁRIO POR ID
    @GetMapping("/{id}")
    public FuncionarioDTO listarUsuarioPorId(@PathVariable Long id){
        return funcionarioService.listarUsuarioPorId(id);
    }

    //DELETAR POR ID
    @DeleteMapping("/{id}")
    public void deletarUsuarioPorId(@PathVariable Long id){
         funcionarioService.deletarUsuarioPorId(id);
    }

    //CRIAR USUÁRIO
    @PostMapping
    public FuncionarioDTO criarUsuario(@RequestBody FuncionarioDTO dto){
        return funcionarioService.criarUsuario(dto);
    }

    //ATUALIZAR TODAS INFORMAÇÕES DO USUÁRIO
    @PutMapping("/{id}")
    public FuncionarioDTO atualizarUsuario(@PathVariable Long id, @RequestBody FuncionarioDTO dto){
        return funcionarioService.atualizarUsuario(id, dto);
    }

    //ATUALIZAR PARCIALMENTE AS INFORMAÇÕES DO USUÁRIO
    @PatchMapping("/{id}")
    public FuncionarioDTO atualizarUsuarioParcial(
            @PathVariable Long id,
            @RequestBody FuncionarioDTO dto) {

        return funcionarioService.atualizarUsuarioParcial(id, dto);
    }
}
