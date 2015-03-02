package br.com.tairoroberto.sistemafinanceiro.view;

import br.com.tairoroberto.sistemafinanceiro.model.Pessoa;
import br.com.tairoroberto.sistemafinanceiro.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ConsultaPessoaBean {
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	@PostConstruct
	public void inicializar() {
        Session session = HibernateUtil.getSession();

        this.pessoas = session.createCriteria(Pessoa.class)
                .addOrder(Order.asc("nome"))
                .list();

        session.close();
	}

    public List<Pessoa> getPessoas() {
        return pessoas;
    }
}
