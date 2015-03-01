package br.com.tairoroberto.sistemafinanceiro.view;

import br.com.tairoroberto.sistemafinanceiro.model.Lancamento;
import br.com.tairoroberto.sistemafinanceiro.model.Pessoa;
import br.com.tairoroberto.sistemafinanceiro.model.TipoLancamento;
import br.com.tairoroberto.sistemafinanceiro.service.GestaoPessoas;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.ArrayList;
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
        GestaoPessoas gestaoPessoas = new GestaoPessoas();
        this.pessoas = gestaoPessoas.listarTodas();
    }

    public void lancamentoPagoModificado(ValueChangeEvent event){
        this.lancamento.setPago((Boolean)event.getNewValue());
        this.lancamento.setDataPagamento(null);
        //pula todasa as validações e rederiza tela
        FacesContext.getCurrentInstance().renderResponse();
    }

    public void cadastrar() {
        System.out.println("Tipo: " + this.lancamento.getTipo());
        System.out.println("Pessoa: " + this.lancamento.getPessoa().getNome());
        System.out.println("Descrição: " + this.lancamento.getDescricao());
        System.out.println("Valor: " + this.lancamento.getValor());
        System.out.println("Data de vencimento: " + this.lancamento.getDataVencimento());
        System.out.println("Conta paga: " + this.lancamento.isPago());
        System.out.println("Data de pagamento: " + this.lancamento.getDataPagamento());

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
