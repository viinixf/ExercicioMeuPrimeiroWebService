package br.com.exercicioDois.ExercicioDois;

import br.com.exerciciodois.ExercicioDois.EntidadePessoa;
import java.util.ArrayList;
import java.util.List;


abstract class PessoaMock {

    private List<EntidadePessoa> listaDePessoas = new ArrayList<>();

    private List<EntidadePessoa> adicionaRegistro = new ArrayList<>();

    public PessoaMock() {
        this.inicializaLista();
    }
    public List<EntidadePessoa> getListaDePessoas() {
        return listaDePessoas;
    }

    /*public void setListaDePessoas(List<EntidadePessoa> listaDePessoas) {
        this.listaDePessoas = listaDePessoas;
    }*/

    protected EntidadePessoa deleteRegistros(EntidadePessoa pessoa) {
        listaDePessoas.remove(pessoa);
        return pessoa;
    }

    protected EntidadePessoa alterarCadastro(long id, EntidadePessoa pessoaUpdate){
        for (EntidadePessoa pessoa : getListaDePessoas()) {
            System.out.println(pessoa.getNome());
            if (pessoa.getId().equals(id)) {
                adicionaRegistro.remove(pessoa);
            }
        }
        pessoaUpdate.setId(id);
        adicionaRegistro.add(pessoaUpdate);
        return pessoaUpdate;
    }

    protected EntidadePessoa addPessoa(EntidadePessoa pessoa) {
        this.listaDePessoas.add(pessoa);
        return pessoa;
    }

    //Lista de Registros
    protected List<EntidadePessoa> listaMockada() {
        return listaDePessoas;
    }


    public abstract EntidadePessoa insert(EntidadePessoa pessoa);

    public abstract EntidadePessoa delete(EntidadePessoa pessoa);

    public abstract List<EntidadePessoa> getAll();

    private void inicializaLista() {
        this.listaDePessoas.add(new EntidadePessoa(1l, "Fritz", 22, "93494107025", "0259548125"));
        this.listaDePessoas.add(new EntidadePessoa(2l, "Frida", 22, "93494107014", "59984954564"));
    }

}
