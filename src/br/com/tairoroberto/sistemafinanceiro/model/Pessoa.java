package br.com.tairoroberto.sistemafinanceiro.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable, Cloneable {
	private Integer codigo;
	private String nome;
    private TipoPessoa tipo;
    private String email;
    private Date dataNascimento;
    private RamoAtividade ramoAtividade;

    public Pessoa() {
    }

    public Pessoa(Integer codigo, String nome, String email, Date dataNascimento, RamoAtividade ramoAtividade) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.ramoAtividade = ramoAtividade;
    }

    @Id //id in database
    @GeneratedValue //auto_increment fild in table
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    public TipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "data_nascimento")
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date data_nascimento) {
        this.dataNascimento = data_nascimento;
    }

    @ManyToOne
    @JoinColumn(name = "codigo_ramo_atividade")
    public RamoAtividade getRamoAtividade() {
        return ramoAtividade;
    }

    public void setRamoAtividade(RamoAtividade ramoAtividade) {
        this.ramoAtividade = ramoAtividade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        if (codigo != null ? !codigo.equals(pessoa.codigo) : pessoa.codigo != null) return false;
        if (dataNascimento != null ? !dataNascimento.equals(pessoa.dataNascimento) : pessoa.dataNascimento != null)
            return false;
        if (email != null ? !email.equals(pessoa.email) : pessoa.email != null) return false;
        if (nome != null ? !nome.equals(pessoa.nome) : pessoa.nome != null) return false;
        if (ramoAtividade != null ? !ramoAtividade.equals(pessoa.ramoAtividade) : pessoa.ramoAtividade != null)
            return false;
        if (tipo != pessoa.tipo) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigo != null ? codigo.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (dataNascimento != null ? dataNascimento.hashCode() : 0);
        result = 31 * result + (ramoAtividade != null ? ramoAtividade.hashCode() : 0);
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
