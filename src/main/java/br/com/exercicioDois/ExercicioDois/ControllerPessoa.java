/*
 * ExercicioDois
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.exercicioDois.ExercicioDois;

import br.com.exerciciodois.ExercicioDois.EntidadePessoa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Descrição da classe.
 */
//Método GET
@RestController
@RequestMapping("/pessoas")
public class ControllerPessoa {

    @Autowired
    private PessoaRepositoryMock repository;

    @GetMapping
    public List<EntidadePessoa> registroDeDados() {
        return repository.listaMockada();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        List<EntidadePessoa> listaPessoa = repository.listaMockada();
        for (EntidadePessoa pessoa : listaPessoa) {
            if (pessoa.getId().equals(id)) {
                listaPessoa.remove(pessoa.getId());
                return ResponseEntity.ok("Cliente " + pessoa.getNome() + " excluído com sucesso.");
            }
        }
        return ResponseEntity.notFound().build();
    }
}
