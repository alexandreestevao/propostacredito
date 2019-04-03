package br.com.calcard.persistence.service.analise;

import br.com.calcard.persistence.model.PropostaDeCredito;
import br.com.calcard.persistence.model.enums.EstadoCivil;

import java.math.BigDecimal;

public class RegraDez implements RegraDeCreditoInterface {

    public static final String REPROVADO_PELA_POLITICA_DE_CREDITO = "Reprovado pela política de crédito";

    @Override
    public Boolean RegraAplicavel(PropostaDeCredito propostaDeCredito) {

        Integer idade = propostaDeCredito.getIdade();
        EstadoCivil estadoCivil = propostaDeCredito.getEstadoCivil();
        Integer dependentes = propostaDeCredito.getDependentes();
        BigDecimal rendaMensal = propostaDeCredito.getRenda();

        return idade >= 16 && rendaMensal.intValue() >= 1000 && rendaMensal.intValue() <= 2000 && dependentes >= 1 &&
                dependentes < 3 && (estadoCivil == EstadoCivil.DIVORCIADO || estadoCivil == EstadoCivil.VIÚVO);
    }

    @Override
    public void AplicarRegra(PropostaDeCredito propostaDeCredito) {
        propostaDeCredito.setResultado(false);
        propostaDeCredito.setLimiteDeCredito(REPROVADO_PELA_POLITICA_DE_CREDITO);
    }

}
