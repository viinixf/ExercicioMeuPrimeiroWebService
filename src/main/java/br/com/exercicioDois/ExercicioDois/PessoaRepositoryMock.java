package br.com.exercicioDois.ExercicioDois;

import java.util.List;
import org.springframework.stereotype.Component;
import br.com.exerciciodois.ExercicioDois.EntidadePessoa;

/**
 * Descrição da classe.
 */
@Component
public class PessoaRepositoryMock extends PessoaMock {

    public PessoaRepositoryMock() {
        super();
    }

    /**
     * Retorna a lista de pessoas
     *
     * @return {@code List<EntidadePessoa>}
     */
    @Override
    public List<EntidadePessoa> getAll() {
        return getListaDePessoas();
    }

    /**
     * Deleta uma pessoa
     *
     * @param pessoa
     * @return
     */
    @Override
    public EntidadePessoa delete(EntidadePessoa pessoa) {
        return deleteRegistros(pessoa);
    }

    /**public EntidadePessoa atualizar(EntidadePessoa pessoa){
        return alteraLista(pessoa);
    }*/

    @Override
    public EntidadePessoa insert(EntidadePessoa pessoa) {
        return addPessoa(pessoa);
    }

}
