/*
========================================================
1)Controller recebe requisições HTTP, encaminha para o Service e devolve a resposta.

2)Controller NUNCA: conversa direto com Repository, retorna Entity, converte Model em DTO ou aplica lógica.

3)Controller SEMPRE: conversa com Service.

4)Crie um objeto service e seu construtor (usado lombok abaixo)

5)@RequestMapping geralmente em cima da classe, diz que todos métodos dessa classe vão ter como
prefixo o nome que for colocado lá.

6)@GetMapping Sempre usado nos métodos, ele é um verbo. Em CRUD você nunca da o nome da sua ação, seguindo padrão REST.

7)A classe controller recebe requisições HTTP e o retorno dos métodos é convertido automaticamente em JSON.
#Traduz (HTTP ↔ Service).
========================================================
*/
package dev.matheus.sistemaRegistro.funcionarios;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    //BUSCAR TODOS USUÁRIOS E MOSTRAR EM LISTA
    @GetMapping
    public List<FuncionarioDTO> listarUsuariosCadastrados(){
        return funcionarioService.listarUsuariosCadastrados();
    }

    //BUSCAR 1 USUÁRIO PELO SEU ID
    @GetMapping("/{id}")
    public FuncionarioDTO listarUsuarioPorId(@PathVariable Long id){
        return funcionarioService.listarUsuarioPorId(id);
    }

    //DELETAR POR ID
    @DeleteMapping("/deletar/{id}")
    public void deletarUsuarioPorId(@PathVariable Long id){
         funcionarioService.deletarUsuarioPorId(id);
    }

    @PostMapping
    public FuncionarioDTO criarUsuario(@RequestBody FuncionarioDTO dto){
        return funcionarioService.criarUsuario(dto);
    }
}
