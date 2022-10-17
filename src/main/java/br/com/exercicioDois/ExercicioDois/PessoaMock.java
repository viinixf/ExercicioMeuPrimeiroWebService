package br.com.exercicioDois.ExercicioDois;

import br.com.exerciciodois.ExercicioDois.Pessoa;
import java.util.ArrayList;
import java.util.List;

abstract class PessoaMock {

    private List<Pessoa> listaDePessoas = new ArrayList<>();

    public PessoaMock() {
        this.inicializaLista();
    }

    public List<Pessoa> getListaDePessoas() {
        return listaDePessoas;
    }

    protected Pessoa deleteRegistro(Pessoa pessoa) {
        listaDePessoas.remove(pessoa);
        return pessoa;
    }

    protected Pessoa atualizaCadastro(long id, Pessoa pessoaUpdate) {
        for (Pessoa pessoa : getListaDePessoas()) {
            System.out.println(pessoa.getNome());
            if (pessoa.getId().equals(id)) {
                listaDePessoas.remove(pessoa);
            }
        }
        pessoaUpdate.setId(id);
        listaDePessoas.add(pessoaUpdate);
        return pessoaUpdate;
    }

    protected Pessoa addPessoa(Pessoa pessoa) {
        this.listaDePessoas.add(pessoa);
        return pessoa;
    }

    //Lista de Registros
    protected List<Pessoa> listaMockada() {
        return listaDePessoas;
    }

    public abstract Pessoa insert(Pessoa pessoa);

    public abstract Pessoa delete(Pessoa pessoa);

    public abstract Pessoa atualiza(Long id, Pessoa pessoa);

    public abstract List<Pessoa> getAll();

    private void inicializaLista() {
        this.listaDePessoas.add(new Pessoa(1l, "Fritz", 22, "93494107025", "0259548125"));
        this.listaDePessoas.add(new Pessoa(2l, "Frida", 22, "93494107014", "59984954564"));
    }

}
