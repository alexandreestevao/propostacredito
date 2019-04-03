package br.com.calcard.persistence.service.analise;

import br.com.calcard.persistence.model.PropostaDeCredito;

import java.util.Arrays;
import java.util.List;

public class AnaliseDeCredito {

    static List<RegraDeCreditoInterface> regras = Arrays.asList(new RegraUm(), new RegraDois(), new RegraTres(),
            new RegraQuatro(), new RegraCinco(), new RegraSeis(), new RegraSete(), new RegraOito(), new RegraNove(),
            new RegraDez());

    public static PropostaDeCredito analiseDeCredito(PropostaDeCredito propostaDeCredito) {

        for (RegraDeCreditoInterface regra : regras) {
            if (regra.RegraAplicavel(propostaDeCredito)) {
                regra.AplicarRegra(propostaDeCredito);
                break;
            }
        }

        return propostaDeCredito;

    }

}
