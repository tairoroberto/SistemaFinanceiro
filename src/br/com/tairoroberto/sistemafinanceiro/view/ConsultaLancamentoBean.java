package br.com.tairoroberto.sistemafinanceiro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ConsultaLancamentoBean implements Serializable {
	private List<String> lancamentos = new ArrayList<String>();

	@PostConstruct
	public void inicializar(){
		for (int i = 0; i < 20; i++) {
			lancamentos.add("");
		}
	}
	
	public List<String> getLancamentos() {
		return lancamentos;
	}	
}
