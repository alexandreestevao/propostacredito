package br.com.calcard.persistence.service.analise;

import br.com.calcard.persistence.model.PropostaDeCredito;

import java.math.BigDecimal;

public class RegraUm implements RegraDeCreditoInterface {

    public static final String ENTRE_100_500 = "Entre 100 - 500";

    @Override
    public Boolean RegraAplicavel(PropostaDeCredito propostaDeCredito) {
        Integer idade = propostaDeCredito.getIdade();
        Integer dependentes = propostaDeCredito.getDependentes();
        BigDecimal rendaMensal = propostaDeCredito.getRenda();

        return idade >= 16 && rendaMensal.intValue() >= 500 && rendaMensal.intValue() <= 1000 && dependentes.equals(0);

    }

    @Override
    public void AplicarRegra(PropostaDeCredito propostaDeCredito) {
        propostaDeCredito.setResultado(true);
        propostaDeCredito.setLimiteDeCredito(ENTRE_100_500);
    }
}
