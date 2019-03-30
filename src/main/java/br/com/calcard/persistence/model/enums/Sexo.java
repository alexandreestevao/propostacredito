package br.com.calcard.persistence.model.enums;

public enum Sexo {

    MASCULINO(1, "Masculino"),
    FEMININO(2, "Feminino");

    private int codigo;
    private String nome;

    Sexo(Integer id, String nome) {
        this.codigo = id;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public static Sexo toEnum(Integer codigo) {

        if(codigo == null) {
            return null;
        }

        for(Sexo x : Sexo.values()) {
            if(codigo.equals(x.getCodigo())){
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido :" + codigo);
    }
}