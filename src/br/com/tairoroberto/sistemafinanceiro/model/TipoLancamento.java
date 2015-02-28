package br.com.tairoroberto.sistemafinanceiro.model;

import java.io.Serializable;

public enum TipoLancamento implements Serializable {
	RECEITA("Receita"),
	DESPESA("Despesa");
	
	private String descricao;

	private TipoLancamento(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
