/*
 * ExercicioDois
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.exercicioDois.ExercicioDois;

import br.com.exerciciodois.ExercicioDois.Pessoa;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Descrição da classe.
 */
//Método GET
@RestController // Marca a classe como controlador, onde cada método retorna um objeto
@RequestMapping("/pessoas") // Serve para mapear solicitações da web para classe manipuladoras especificas

public class ControllerPessoa {

    @Autowired // Serve para marcar o ponto de injeção na classe.
    private PessoaRepositoryMock repository;

    private List<Pessoa> listaPessoa = new ArrayList<>();

    public ControllerPessoa(PessoaRepositoryMock repository) {
        this.repository = repository;
    }

    @GetMapping // Usada para mapear solicitações HTTP GET em métodos manipuladores especificos
    public List<Pessoa> registroDeDados() {
        return repository.getAll();
    }

    @DeleteMapping("/{id}") // Excluir recurso
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Pessoa excluido = new Pessoa();
        for (Pessoa pessoa : repository.getAll()) {
            System.out.println(pessoa.getNome());
            if (pessoa.getId().equals(id)) {
                excluido = repository.delete(pessoa);
            }
        }
        return ResponseEntity.ok().build();
    }

    //Método utilizado para adicionar uma nova pessoa na lista
    @PostMapping
    public ResponseEntity insert(@RequestBody Pessoa pessoa) {

        pessoa.setId(repository.getAll().size() + 1L);
        repository.insert(pessoa);

        return ResponseEntity.ok(pessoa);
    }

    //Método utilizado para atualizar informações da pessoa
    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable("id") long id, @RequestBody Pessoa pessoa) {
        repository.atualiza(id, pessoa);
        return ResponseEntity.ok(pessoa);
    }
}
