package br.com.tairoroberto.sistemafinanceiro.view;

import br.com.tairoroberto.sistemafinanceiro.model.Lancamento;
import br.com.tairoroberto.sistemafinanceiro.model.Pessoa;
import br.com.tairoroberto.sistemafinanceiro.model.TipoLancamento;
import br.com.tairoroberto.sistemafinanceiro.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tairo on 27/02/15.
 */
@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

    private List<Pessoa> pessoas = new ArrayList<Pessoa>();
    private Lancamento lancamento = new Lancamento();

    @PostConstruct
    public void init(){
        Session session = HibernateUtil.getSession();

        this.pessoas = session.createCriteria(Pessoa.class)
                .addOrder(Order.asc("nome"))
                .list();

        session.close();
    }

    public void lancamentoPagoModificado(ValueChangeEvent event){
        this.lancamento.setPago((Boolean)event.getNewValue());
        this.lancamento.setDataPagamento(null);
        //pula todas as validações e rederiza tela
        FacesContext.getCurrentInstance().renderResponse();
    }

    public void cadastrar() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.merge(this.lancamento);

        transaction.commit();
        session.close();

        this.lancamento = new Lancamento();

        String msg = "Cadastro efetuado com sucesso!";

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,msg,msg));
    }


    public Lancamento getLancamento() {
        return lancamento;
    }

    public TipoLancamento[] getTiposLancamentos() {
        return TipoLancamento.values();
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }
}
