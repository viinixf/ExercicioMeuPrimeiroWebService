/*
 * ExercicioDois
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.exercicioDois.ExercicioDois;

import br.com.exerciciodois.ExercicioDois.Pessoa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/* Serve para informar ao Spring Web MVC que essa será uma classe da camada controller */
@RestController

/*Serve para informar qual a rota padrão para esse controller que no caso será a rota*/
@RequestMapping("/pessoas")

/*ControllerPessoa será responsável por receber e tratar as requisições dos métodos HTTP */
public class ControllerPessoa {

    /* Serve para marcar o ponto de injeção na classe */
    @Autowired
    private PessoaRepository repository;

    /*Rota responsável por listar todos os clientes cadastrados no banco*/
    @GetMapping
    public List<Pessoa> listar() {
        return repository.findAll();
    }
    /*Rota responsável por listar clientes por ID*/
    @GetMapping("/{id}")
    public Pessoa buscaPorId(@PathVariable Long id) {
        var pessoaOptional = repository.findById(id);
        if (pessoaOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return pessoaOptional.get();
    }

    /*Método HTTP responsável deletar por id*/
    @DeleteMapping("/{id}") // Excluir recurso
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirPorId(@PathVariable Long id) {
        var pessoaOptional = repository.findById(id);
        if (pessoaOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.delete(pessoaOptional.get());
    }

    /*Método utilizado para adicionar uma nova pessoa na lista*/
    @PostMapping
    /*Servirá para finalizar todo o processamento de cadastro com status 201*/
    @ResponseStatus(code = HttpStatus.CREATED)
    public Pessoa cadastrar(@RequestBody Pessoa pessoa) {
        return repository.save(pessoa);
    }

    //Método utilizado para atualizar informações da pessoa
    @PutMapping("{id}")
    public Pessoa atualizarPorId(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        var pessoaOptional = repository.findById(id);
        if (pessoaOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        pessoa.setId(id);
        return repository.save(pessoa);
    }
}
