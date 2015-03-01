package br.com.tairoroberto.sistemafinanceiro.service;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.tairoroberto.sistemafinanceiro.model.Pessoa;

public class GestaoPessoas implements Serializable {
	private static  HashMap<Integer, Pessoa> pessoas = new HashMap<Integer,Pessoa>();
	
	static {
		pessoas.put(1, new Pessoa(1,"João da Silva",null,null,null,null));
		pessoas.put(2, new Pessoa(2,"Lava-jato Água e Sabão Ltda",null,null,null,null));
		pessoas.put(3, new Pessoa(3,"Sebastião Mnedes de Souza",null,null,null,null));
	}
	
	public List<Pessoa> listarTodas() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.addAll(GestaoPessoas.pessoas.values());
		return pessoas; 
	}
	
	public Pessoa buscarPorCodico(Integer codigo) {
		return pessoas.get(codigo); 
	}
}
