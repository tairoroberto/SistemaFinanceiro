package br.com.tairoroberto.sistemafinanceiro.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ConsultaClienteFornecedorBean {
	private List<String> clienteFornecedor = new ArrayList<String>();
	
	@PostConstruct
	public void inicializar() {
		for (int i = 0; i < 10; i++) {
			clienteFornecedor.add("");
		}
	}
	
	public List<String> getClienteFornecedor() {
		return clienteFornecedor;
	}	
}
