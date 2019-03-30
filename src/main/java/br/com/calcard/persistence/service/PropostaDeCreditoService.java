package br.com.calcard.persistence.service;

import br.com.calcard.persistence.model.PropostaDeCredito;
import br.com.calcard.persistence.repository.PropostaDeCreditoRepository;
import br.com.calcard.persistence.service.exceptions.DataIntegrityException;
import br.com.calcard.persistence.service.interfaces.PropostaDeCreditoInterface;
import org.springframework.beans.factory.annotation.Autowired;

public class PropostaDeCreditoService implements PropostaDeCreditoInterface {

    @Autowired
    PropostaDeCreditoRepository propostaDeCreditoRepository;


    @Override
    public PropostaDeCredito salvar(PropostaDeCredito propostaDeCredito) throws DataIntegrityException {
        propostaDeCredito.setId(null);
        return propostaDeCreditoRepository.save(propostaDeCredito);
    }

    @Override
    public PropostaDeCredito buscarPorCpf(String cpf) {
        return null;
    }
}
