package br.com.exercicioDois.ExercicioDois;

import br.com.exerciciodois.ExercicioDois.EntidadePessoa;
import java.util.ArrayList;
import java.util.List;

//Classe responsável por fazer a simulação do Banco
abstract class PessoaMock {

    //Lista de Registros
    protected final List<EntidadePessoa> registroDeDados = new ArrayList<>();

    protected List<EntidadePessoa> listaMockada() {
        this.registroDeDados.add(new EntidadePessoa(1l, "Fritz", 22, "93494107025", "0259548125"));
        this.registroDeDados.add(new EntidadePessoa(2l, "Frida", 22, "93494107014", "59984954564"));
        return registroDeDados;
    }
    public abstract List<EntidadePessoa> getAll();
}
