/*
 * ExercicioDois
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.exercicioDois.ExercicioDois;

import br.com.exerciciodois.ExercicioDois.EntidadePessoa;
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

    private List<EntidadePessoa> listaPessoa = new ArrayList<>();

    public ControllerPessoa(PessoaRepositoryMock repository) {
        this.repository = repository;
    }

    @GetMapping // Usada para mapear solicitações HTTP GET em métodos manipuladores especificos
    public List<EntidadePessoa> registroDeDados() {
        return repository.getAll();
    }

    @DeleteMapping("/{id}") // Excluir recurso
    public ResponseEntity<String> delete(@PathVariable Long id) {
        EntidadePessoa excluido = new EntidadePessoa();
        for (EntidadePessoa pessoa : repository.getAll()) {
            System.out.println(pessoa.getNome());
            if (pessoa.getId().equals(id)) {
               excluido = repository.delete(pessoa);
            }
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity insert(@RequestBody EntidadePessoa pessoa) {

        pessoa.setId(repository.getAll().size()+1L);
        repository.insert(pessoa);

        return ResponseEntity.ok(pessoa);

        // pessoa.getNome()

        /*for (EntidadePessoa pessoa : repository.getAll()) {
            System.out.println(pessoa.getId());
            if (pessoa.getId().equals(id)) {
                repository.alteraLista(pessoa);
            }
        }*/
        // return ResponseEntity.notFound().build();
    }
}
