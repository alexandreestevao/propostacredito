package br.com.calcard.util.numeros;

public class Numeros {

    public Integer zerosEsquerda(String qtde, Integer numero) {

        /***
         * ex.:
         * qtde = "%015d"
         * se o número for de 5 dígitos, a função colocará 10 zeros a esquerda
         * ex.:
         * 000000000012345
          */

        String var = String.format(qtde, numero);
        return Integer.valueOf(var);

    }

}
