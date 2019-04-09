package br.com.calcard.persistence.service;

import java.io.*;

public class EscreverLerTxt {

    public void escreverTxt() {

        try {

            FileOutputStream arquivo = new FileOutputStream("arquivo.txt");
            PrintWriter escrever = new PrintWriter(arquivo);

            escrever.println("Um resultado vindo do banco de dados");
            escrever.println("Outro resultado vindo do banco de dados");
            escrever.println("Mais um resultado vindo do banco de dados");

            escrever.close();
            arquivo.close();

        } catch(Exception e) {

            System.out.println("Erro ao escrever arquivo.");

        }

    }

    public void lerTxt() {

        try {

            FileInputStream arquivo = new FileInputStream("arquivo.txt");
            InputStreamReader input = new InputStreamReader(arquivo);
            BufferedReader br = new BufferedReader(input);

            String linha;

            do {

                linha = br.readLine();

                if(linha != null) {
                    String[] texto = linha.split(";");
                    System.out.println("-------CABEÇALHO-------");
                    for (int i=0; i<texto.length; i++) {
                        System.out.println("texto lido = " + texto[i]);
                    }
                }

            } while(linha != null);

        } catch(Exception e) {

            System.out.println("Erro ao ler arquivo.");

        }

    }

}
