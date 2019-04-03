package br.com.calcard.persistence.service.analise;

import br.com.calcard.persistence.model.PropostaDeCredito;
import br.com.calcard.persistence.model.enums.EstadoCivil;
import br.com.calcard.persistence.model.enums.Estados;
import br.com.calcard.persistence.model.enums.Sexo;

import java.math.BigDecimal;

public class RegraDois implements RegraDeCreditoInterface {

    public static final String ENTRE_500_1000 = "Entre 500 - 1000";

    @Override
    public Boolean RegraAplicavel(PropostaDeCredito propostaDeCredito) {

        String nome = propostaDeCredito.getNome();
        Integer idade = propostaDeCredito.getIdade();
        Sexo sexo = propostaDeCredito.getSexo();
        EstadoCivil estadoCivil = propostaDeCredito.getEstadoCivil();
        Estados estado = propostaDeCredito.getEstado();
        Integer dependentes = propostaDeCredito.getDependentes();
        BigDecimal rendaMensal = propostaDeCredito.getRenda();

        return idade >= 16 && rendaMensal.intValue() >= 1000 && rendaMensal.intValue() <= 2500 &&
                dependentes.equals(0);
    }

    @Override
    public void AplicarRegra(PropostaDeCredito propostaDeCredito) {

        propostaDeCredito.setResultado(true);
        propostaDeCredito.setLimiteDeCredito(ENTRE_500_1000);

    }
}
