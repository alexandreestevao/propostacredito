package br.com.calcard.persistence.service.interfaces;

import br.com.calcard.persistence.model.PropostaDeCredito;
import br.com.calcard.persistence.service.exceptions.DataIntegrityException;
import br.com.calcard.persistence.service.exceptions.UnicidadeCpfException;
import org.springframework.stereotype.Component;

@Component
public interface PropostaDeCreditoInterface {

    PropostaDeCredito salvar(PropostaDeCredito propostaDeCredito) throws DataIntegrityException, UnicidadeCpfException;

    PropostaDeCredito buscarPorCpf(String cpf);

}
