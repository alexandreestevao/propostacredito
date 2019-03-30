package br.com.calcard.persistence.repository;

import br.com.calcard.persistence.model.PropostaDeCredito;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropostaDeCreditoRepository extends CrudRepository<PropostaDeCredito, Integer> {

    Optional<PropostaDeCredito> findByCpf(String cpf);

    @Query("select p from PropostaDeCredito p")
    List<PropostaDeCredito> buscaTodos();

}
