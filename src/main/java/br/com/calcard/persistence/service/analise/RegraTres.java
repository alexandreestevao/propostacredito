package br.com.calcard.persistence.service.analise;

import br.com.calcard.persistence.model.PropostaDeCredito;

import java.math.BigDecimal;

public class RegraTres implements RegraDeCreditoInterface {

    public static final String ENTRE_500_1000 = "Entre 500 - 1000";

    @Override
    public Boolean RegraAplicavel(PropostaDeCredito propostaDeCredito) {
        Integer idade = propostaDeCredito.getIdade();
        Integer dependentes = propostaDeCredito.getDependentes();
        BigDecimal rendaMensal = propostaDeCredito.getRenda();

        return idade >= 16 && rendaMensal.intValue() >= 1000 && rendaMensal.intValue() <= 2500 && dependentes >= 1 &&
                dependentes < 3;
    }

    @Override
    public void AplicarRegra(PropostaDeCredito propostaDeCredito) {
        propostaDeCredito.setResultado(true);
        propostaDeCredito.setLimiteDeCredito(ENTRE_500_1000);
    }
}
