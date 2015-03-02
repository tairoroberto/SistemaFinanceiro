package br.com.tairoroberto.sistemafinanceiro.view;

import br.com.tairoroberto.sistemafinanceiro.model.Lancamento;
import br.com.tairoroberto.sistemafinanceiro.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ConsultaLancamentoBean implements Serializable {
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();

	@PostConstruct
	public void inicializar(){
        Session session = HibernateUtil.getSession();

        this.lancamentos = session.createCriteria(Lancamento.class)
                .addOrder(Order.desc("dataVencimento"))
                .list();

        session.close();
	}
	
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}	
}
