package br.com.exercicioDois.ExercicioDois;

import java.util.List;
import org.springframework.stereotype.Component;
import br.com.exerciciodois.ExercicioDois.Pessoa;

/**
 * Descrição da classe.
 */
//@Component
public class PessoaRepositoryMock extends PessoaMock {

    public PessoaRepositoryMock() {
        super();
    }

    /**
     * Retorna a lista de pessoas
     *
     * @return {@code List<Pessoa>}
     */
    @Override
    public List<Pessoa> getAll() {
        return getListaDePessoas();
    }

    /**
     * Deleta uma pessoa
     *
     * @param pessoa
     * @return
     */
    @Override
    public Pessoa delete(Pessoa pessoa) {
        return deleteRegistro(pessoa);
    }
    @Override
    public Pessoa insert(Pessoa pessoa) {
        return addPessoa(pessoa);
    }

    public Pessoa atualiza(Long id, Pessoa pessoa){
        return atualizaCadastro(id, pessoa);
    }
}
