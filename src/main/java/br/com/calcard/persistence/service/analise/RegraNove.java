package br.com.calcard.persistence.service.analise;

import br.com.calcard.persistence.model.PropostaDeCredito;

import java.math.BigDecimal;

public class RegraNove implements RegraDeCreditoInterface {

    public static final String RENDA_BAIXA = "Renda baixa";

    @Override
    public Boolean RegraAplicavel(PropostaDeCredito propostaDeCredito) {
        BigDecimal rendaMensal = propostaDeCredito.getRenda();

        return rendaMensal.intValue() <= 500;
    }

    @Override
    public void AplicarRegra(PropostaDeCredito propostaDeCredito) {
        propostaDeCredito.setResultado(false);
        propostaDeCredito.setLimiteDeCredito(RENDA_BAIXA);
    }
}
