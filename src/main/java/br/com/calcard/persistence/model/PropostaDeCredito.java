package br.com.calcard.persistence.model;

import br.com.calcard.persistence.model.enums.EstadoCivil;
import br.com.calcard.persistence.model.enums.Estados;
import br.com.calcard.persistence.model.enums.Sexo;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class PropostaDeCredito implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 2, max = 150, message = "O tamanho deve ser entre 2 e 150 caracteres.")
    private String nome;

    @NotEmpty(message = "CPF é obrigatório")
    private String cpf;

    @NotNull(message = "Idade é obrigatório")
    private Integer idade;

    @NotNull(message = "Sexo é obrigatório")
    private Integer sexo;

    @NotNull(message = "Estado civil é obrigatório")
    private Integer estadoCivil;

    @NotNull(message = "Estado é obrigatório")
    private Integer estado;

    @NotNull(message = "Número de dependentes é obrigatório")
    private Integer dependentes;

    @NotNull(message = "Renda é obrigatório")
    private BigDecimal renda;

    public PropostaDeCredito() {
    }

    public PropostaDeCredito(String nome, String cpf, Integer idade, Sexo sexo, EstadoCivil estadoCivil, Estados estado, Integer dependentes, BigDecimal renda) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = (sexo == null) ? null : sexo.getCodigo();
        this.estadoCivil = (estadoCivil == null) ? null : estadoCivil.getCodigo();
        this.estado = (estado == null) ? null : estado.getCodigo();
        this.dependentes = dependentes;
        this.renda = renda;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Sexo getSexo() {
        return Sexo.toEnum(sexo);
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return EstadoCivil.toEnum(estadoCivil);
    }

    public void setEstadoCivil(Integer estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Estados getEstado() {
        return Estados.toEnum(estado);
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public int getDependentes() {
        return dependentes;
    }

    public void setDependentes(Integer dependentes) {
        this.dependentes = dependentes;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropostaDeCredito that = (PropostaDeCredito) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PropostaDeCredito{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                ", sexo=" + sexo +
                ", estadoCivil=" + estadoCivil +
                ", estado=" + estado +
                ", dependentes=" + dependentes +
                ", renda=" + renda +
                '}';
    }
}
