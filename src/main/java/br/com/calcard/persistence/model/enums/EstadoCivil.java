package br.com.calcard.persistence.model.enums;

public enum EstadoCivil {

    CASADO(1, "Casado(a)"),
    DIVORCIADO(2, "Divorciado(a)"),
    SEPARADO(3, "Separado(a)"),
    SOLTEIRO(4, "Solteiro(a)"),
    VIÚVO(5, "Viúvo(a)");

    private Integer codigo;
    private String nome;

    EstadoCivil(Integer id, String nome) {
        this.codigo = id;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public static EstadoCivil toEnum(Integer codigo) {

        if(codigo == null) {
            return null;
        }

        for(EstadoCivil x : EstadoCivil.values()) {
            if(codigo.equals(x.getCodigo())){
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido :" + codigo);
    }

}
