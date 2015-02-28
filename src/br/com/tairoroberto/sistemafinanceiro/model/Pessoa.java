package br.com.tairoroberto.sistemafinanceiro.model;

import java.io.Serializable;

public class Pessoa implements Serializable {
	private Integer codigo;
	private String nome;

	public Pessoa() {
	}

	public Pessoa(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
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

}
