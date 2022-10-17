package br.com.exercicioDois.ExercicioDois;
import br.com.exerciciodois.ExercicioDois.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
