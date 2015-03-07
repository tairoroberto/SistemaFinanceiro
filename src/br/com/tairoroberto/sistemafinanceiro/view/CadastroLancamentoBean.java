package br.com.tairoroberto.sistemafinanceiro.view;

import br.com.tairoroberto.sistemafinanceiro.repository.Lancamentos;
import br.com.tairoroberto.sistemafinanceiro.service.GestaoLancamentos;
import br.com.tairoroberto.sistemafinanceiro.service.RegraNegocioException;
import br.com.tairoroberto.sistemafinanceiro.util.Repositorios;
import br.com.tairoroberto.sistemafinanceiro.model.Lancamento;
import br.com.tairoroberto.sistemafinanceiro.model.Pessoa;
import br.com.tairoroberto.sistemafinanceiro.model.TipoLancamento;
import br.com.tairoroberto.sistemafinanceiro.repository.Pessoas;
import br.com.tairoroberto.sistemafinanceiro.util.FacesUtil;
import org.hibernate.Session;

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

    private Repositorios repositorios = new Repositorios();
    private List<Pessoa> pessoas = new ArrayList<Pessoa>();
    private Lancamento lancamento = new Lancamento();

    @PostConstruct
    public void init(){
        Pessoas pessoas = this.repositorios.getPessoas();

        this.pessoas = pessoas.todas();
    }

    public void lancamentoPagoModificado(ValueChangeEvent event){
        this.lancamento.setPago((Boolean)event.getNewValue());
        this.lancamento.setDataPagamento(null);
        //pula todas as validações e rederiza tela
        FacesContext.getCurrentInstance().renderResponse();
    }

    public void cadastrar() {
        //classe que contem as regras de negocio
        GestaoLancamentos gestaoLancamentos = new GestaoLancamentos(this.repositorios.getLacamentos());

        try {
            gestaoLancamentos.salvar(lancamento);

            this.lancamento = new Lancamento();
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO,"Cadastro efetuado com sucesso!");
        } catch (RegraNegocioException e) {
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR,e.getMessage());
        }
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
