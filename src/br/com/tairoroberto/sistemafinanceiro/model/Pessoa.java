package br.com.tairoroberto.sistemafinanceiro.model;

import java.io.Serializable;
import java.util.Date;

public class Pessoa implements Serializable {
	private Integer codigo;
	private String nome;
    private TipoPessoa tipo;
    private String email;
    private RamoAtividade ramoAtividade;
    private Date dataNascimento;

    public Pessoa() {
    }

    public Pessoa(Integer codigo, String nome, TipoPessoa tipo, String email, RamoAtividade ramoAtividade, Date dataNascimento) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.email = email;
        this.ramoAtividade = ramoAtividade;
        this.dataNascimento = dataNascimento;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RamoAtividade getRamoAtividade() {
        return ramoAtividade;
    }

    public void setRamoAtividade(RamoAtividade ramoAtividade) {
        this.ramoAtividade = ramoAtividade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
