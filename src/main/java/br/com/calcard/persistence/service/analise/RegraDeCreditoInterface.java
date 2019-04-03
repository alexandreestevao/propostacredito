package br.com.calcard.persistence.service.analise;

import br.com.calcard.persistence.model.PropostaDeCredito;

public interface RegraDeCreditoInterface {

    Boolean RegraAplicavel(PropostaDeCredito propostaDeCredito);
    void AplicarRegra(PropostaDeCredito propostaDeCredito);

}