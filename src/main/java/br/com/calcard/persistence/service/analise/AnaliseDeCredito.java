package br.com.calcard.persistence.service.analise;

import br.com.calcard.persistence.model.PropostaDeCredito;
import br.com.calcard.persistence.model.enums.EstadoCivil;
import br.com.calcard.persistence.model.enums.Estados;
import br.com.calcard.persistence.model.enums.Sexo;

import java.math.BigDecimal;

public class AnaliseDeCredito {

    public static final String ENTRE_100_500 = "Entre 100 - 500";
    public static final String ENTRE_500_1000 = "Entre 500 - 1000";
    public static final String ENTRE_1000_1500 = "Entre 1000 - 1500";
    public static final String SUPERIOR_2000 = "Superior 2000";
    public static final String ENTRE_1500_2000 = "Entre 1500 - 2000";
    public static final String RENDA_BAIXA = "Renda baixa";
    public static final String REPROVADO_PELA_POLÍTICA_DE_CRÉDITO = "Reprovado pela política de crédito";

    public static PropostaDeCredito analiseDeCredito(PropostaDeCredito propostaDeCredito) {

        String nome = propostaDeCredito.getNome();
        Integer idade = propostaDeCredito.getIdade();
        Sexo sexo = propostaDeCredito.getSexo();
        EstadoCivil estadoCivil = propostaDeCredito.getEstadoCivil();
        Estados estado = propostaDeCredito.getEstado();
        Integer dependentes = propostaDeCredito.getDependentes();
        BigDecimal rendaMensal = propostaDeCredito.getRenda();


        final boolean b = idade >= 16 && rendaMensal.intValue() >= 501 && rendaMensal.intValue() <= 1000 &&
                dependentes.equals(0);
        final boolean b1 = idade >= 16 && rendaMensal.intValue() >= 1001 && rendaMensal.intValue() <= 2500 &&
                dependentes.equals(0);
        final boolean b2 = idade >= 16 && rendaMensal.intValue() >= 1001 && rendaMensal.intValue() <= 2500 &&
                dependentes >= 1 && dependentes < 3;
        final boolean b3 = idade >= 16 && rendaMensal.intValue() >= 2501 && rendaMensal.intValue() <= 5000 &&
                dependentes >= 1 && dependentes <= 3;
        final boolean b4 = idade >= 16 && rendaMensal.intValue() >= 5001 && rendaMensal.intValue() <= 8000 &&
                dependentes >= 1 && dependentes <= 3;
        final boolean b5 = idade >= 16 && rendaMensal.intValue() >= 5001 && rendaMensal.intValue() <= 8000 &&
                dependentes >= 4 && dependentes < 6;
        final boolean b6 = idade >= 16 && rendaMensal.intValue() >= 5001 && rendaMensal.intValue() <= 8000 &&
                dependentes == 3;
        final boolean b7 = idade >= 16 && rendaMensal.intValue() >= 8001 && rendaMensal.intValue() <= 10000 &&
                dependentes <= 1;
        final boolean b8 = rendaMensal.intValue() <= 500;
        final boolean b9 = idade >= 45 && rendaMensal.intValue() >= 1000 && rendaMensal.intValue() <= 2000 &&
                dependentes >= 1 && dependentes < 3 && (estadoCivil == EstadoCivil.DIVORCIADO ||
                estadoCivil == EstadoCivil.VIÚVO);

        if (b) {
            propostaDeCredito.setResultado(true);
            propostaDeCredito.setLimiteDeCredito(ENTRE_100_500);
            return propostaDeCredito;
        } else if (b1) {
            propostaDeCredito.setResultado(true);
            propostaDeCredito.setLimiteDeCredito(ENTRE_500_1000);
            return propostaDeCredito;
        } else if (b2) {
            propostaDeCredito.setResultado(true);
            propostaDeCredito.setLimiteDeCredito(ENTRE_100_500);
            return propostaDeCredito;
        } else if (b3) {
            propostaDeCredito.setResultado(true);
            propostaDeCredito.setLimiteDeCredito(ENTRE_1000_1500);
            return propostaDeCredito;
        } else if (b4) {
            propostaDeCredito.setResultado(true);
            propostaDeCredito.setLimiteDeCredito(SUPERIOR_2000);
            return propostaDeCredito;
        } else if (b5) {
            propostaDeCredito.setResultado(true);
            propostaDeCredito.setLimiteDeCredito(ENTRE_1000_1500);
            return propostaDeCredito;
        } else if (b6) {
            propostaDeCredito.setResultado(true);
            propostaDeCredito.setLimiteDeCredito(ENTRE_1500_2000);
            return propostaDeCredito;
        } else if (b7) {
            propostaDeCredito.setResultado(true);
            propostaDeCredito.setLimiteDeCredito(SUPERIOR_2000);
            return propostaDeCredito;
        } else if (b8) {
            propostaDeCredito.setResultado(false);
            propostaDeCredito.setLimiteDeCredito(RENDA_BAIXA);
            return propostaDeCredito;
        } else if (b9) {
            propostaDeCredito.setResultado(false);
            propostaDeCredito.setLimiteDeCredito(REPROVADO_PELA_POLÍTICA_DE_CRÉDITO);
            return propostaDeCredito;
        }

        return propostaDeCredito;

    }

}
