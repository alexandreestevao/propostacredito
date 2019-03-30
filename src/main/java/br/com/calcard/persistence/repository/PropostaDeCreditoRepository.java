package br.com.calcard.persistence.repository;

import br.com.calcard.persistence.model.PropostaDeCredito;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PropostaDeCreditoRepository extends CrudRepository<PropostaDeCredito, Integer> {

    Optional<PropostaDeCredito> findByCpf(String cpf);

}
