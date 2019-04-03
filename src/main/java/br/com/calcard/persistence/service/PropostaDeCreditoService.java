package br.com.calcard.persistence.service;

import br.com.calcard.persistence.model.PropostaDeCredito;
import br.com.calcard.persistence.repository.PropostaDeCreditoRepository;
import br.com.calcard.persistence.service.analise.AnaliseDeCredito;
import br.com.calcard.persistence.service.exceptions.DataIntegrityException;
import br.com.calcard.persistence.service.exceptions.ObjectNotFoundException;
import br.com.calcard.persistence.service.exceptions.UnicidadeCpfException;
import br.com.calcard.persistence.service.interfaces.PropostaDeCreditoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropostaDeCreditoService implements PropostaDeCreditoInterface {

    private PropostaDeCreditoRepository propostaDeCreditoRepository;

    @Autowired
    PropostaDeCreditoService(PropostaDeCreditoRepository propostaDeCreditoRepository) {
        this.propostaDeCreditoRepository = propostaDeCreditoRepository;
    }

    public List<PropostaDeCredito> buscaTodos() {
        List<PropostaDeCredito> resultado = propostaDeCreditoRepository.buscaTodos();
        if(resultado == null) {
            throw new ObjectNotFoundException("Registro(s) não encontrado(s): " + PropostaDeCredito.class.getName());
        }
        return resultado;
    }

    @Override
    public PropostaDeCredito buscarPorCpf(String cpf) {
        Optional<PropostaDeCredito> resultado = propostaDeCreditoRepository.findByCpf(cpf);
        return resultado.orElseThrow(() -> new ObjectNotFoundException(
                "Registro não encontrado: " + cpf + ", tipo: " + PropostaDeCredito.class.getName()
        ));
    }

    @Override
    public PropostaDeCredito salvar(PropostaDeCredito propostaDeCredito) throws DataIntegrityException, UnicidadeCpfException {

        Optional<PropostaDeCredito> proposta = propostaDeCreditoRepository.findByCpf(propostaDeCredito.getCpf());

        if (proposta.isPresent()) {
            throw new UnicidadeCpfException("Já existe proposta cadastrada com o CPF '"+ propostaDeCredito.getCpf() +"'");
        }

        propostaDeCredito.setId(null);
        AnaliseDeCredito.analiseDeCredito(propostaDeCredito);
        return propostaDeCreditoRepository.save(propostaDeCredito);

    }

}