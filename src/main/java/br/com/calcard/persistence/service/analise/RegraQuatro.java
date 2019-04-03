package br.com.calcard.persistence.service.analise;

import br.com.calcard.persistence.model.PropostaDeCredito;

import java.math.BigDecimal;

public class RegraQuatro implements RegraDeCreditoInterface {

    public static final String ENTRE_1000_1500 = "Entre 1000 - 1500";

    @Override
    public Boolean RegraAplicavel(PropostaDeCredito propostaDeCredito) {
        Integer idade = propostaDeCredito.getIdade();
        Integer dependentes = propostaDeCredito.getDependentes();
        BigDecimal rendaMensal = propostaDeCredito.getRenda();

        return idade >= 16 && rendaMensal.intValue() >= 2500 && rendaMensal.intValue() <= 5000 && dependentes >= 1 &&
                dependentes <= 3;
    }

    @Override
    public void AplicarRegra(PropostaDeCredito propostaDeCredito) {
        propostaDeCredito.setResultado(true);
        propostaDeCredito.setLimiteDeCredito(ENTRE_1000_1500);
    }
}
