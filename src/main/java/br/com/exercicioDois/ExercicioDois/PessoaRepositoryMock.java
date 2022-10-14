package br.com.exercicioDois.ExercicioDois;

import java.util.List;
import org.springframework.stereotype.Component;
import br.com.exerciciodois.ExercicioDois.EntidadePessoa;

/**
 * Descrição da classe.
 */
@Component
public class PessoaRepositoryMock extends PessoaMock {

    @Override
    public List<EntidadePessoa> getAll() {
        return registroDeDados;
    }
    }