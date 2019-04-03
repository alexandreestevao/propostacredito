package br.com.calcard.persistence.service.analise;

import br.com.calcard.persistence.model.PropostaDeCredito;

import java.math.BigDecimal;

public class RegraOito implements RegraDeCreditoInterface {

    public static final String SUPERIOR_2000 = "Superior 2000";

    @Override
    public Boolean RegraAplicavel(PropostaDeCredito propostaDeCredito) {

        Integer idade = propostaDeCredito.getIdade();
        Integer dependentes = propostaDeCredito.getDependentes();
        BigDecimal rendaMensal = propostaDeCredito.getRenda();

        return idade >= 16 && rendaMensal.intValue() >= 8000 && rendaMensal.intValue() <= 10000 && dependentes <= 1;
    }

    @Override
    public void AplicarRegra(PropostaDeCredito propostaDeCredito) {
        propostaDeCredito.setResultado(true);
        propostaDeCredito.setLimiteDeCredito(SUPERIOR_2000);
    }
}
