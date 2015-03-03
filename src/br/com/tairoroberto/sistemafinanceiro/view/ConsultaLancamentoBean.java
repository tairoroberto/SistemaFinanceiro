package br.com.tairoroberto.sistemafinanceiro.view;

import br.com.tairoroberto.sistemafinanceiro.model.Lancamento;
import br.com.tairoroberto.sistemafinanceiro.util.FacesUtil;
import br.com.tairoroberto.sistemafinanceiro.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ConsultaLancamentoBean implements Serializable {
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
    private  Lancamento lancamentoSelecionado;

	@PostConstruct
	public void inicializar(){
        Session session = HibernateUtil.getSession();

        this.lancamentos = session.createCriteria(Lancamento.class)
                .addOrder(Order.desc("dataVencimento"))
                .list();

        session.close();
	}

    public void excluir(){
        if (this.lancamentoSelecionado.isPago()){
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR,
                    "Lançamento já foi pago e não pode ser excluído!");
        }else{
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.delete(lancamentoSelecionado);
            transaction.commit();
            session.close();

            this.inicializar();
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO,"Lançamento excluido com sucesso!");
        }
    }


	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

    public Lancamento getLancamentoSelecionado() {
        return lancamentoSelecionado;
    }

    public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
        this.lancamentoSelecionado = lancamentoSelecionado;
    }
}
