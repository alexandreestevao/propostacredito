package br.com.calcard.persistence.service.analise;

import br.com.calcard.persistence.model.PropostaDeCredito;
import br.com.calcard.persistence.model.enums.EstadoCivil;
import br.com.calcard.persistence.model.enums.Estados;
import br.com.calcard.persistence.model.enums.Sexo;

import java.math.BigDecimal;

public class RegraNove implements RegraDeCreditoInterface {

    public static final String RENDA_BAIXA = "Renda baixa";

    @Override
    public Boolean RegraAplicavel(PropostaDeCredito propostaDeCredito) {

        String nome = propostaDeCredito.getNome();
        Integer idade = propostaDeCredito.getIdade();
        Sexo sexo = propostaDeCredito.getSexo();
        EstadoCivil estadoCivil = propostaDeCredito.getEstadoCivil();
        Estados estado = propostaDeCredito.getEstado();
        Integer dependentes = propostaDeCredito.getDependentes();
        BigDecimal rendaMensal = propostaDeCredito.getRenda();

        return rendaMensal.intValue() <= 500;
    }

    @Override
    public void AplicarRegra(PropostaDeCredito propostaDeCredito) {

        propostaDeCredito.setResultado(false);
        propostaDeCredito.setLimiteDeCredito(RENDA_BAIXA);

    }
}
