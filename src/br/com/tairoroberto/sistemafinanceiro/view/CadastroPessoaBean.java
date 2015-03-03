package br.com.tairoroberto.sistemafinanceiro.view;

import br.com.tairoroberto.sistemafinanceiro.model.Pessoa;
import br.com.tairoroberto.sistemafinanceiro.model.RamoAtividade;
import br.com.tairoroberto.sistemafinanceiro.model.TipoPessoa;
import br.com.tairoroberto.sistemafinanceiro.repository.Pessoas;
import br.com.tairoroberto.sistemafinanceiro.repository.RamosAtividades;
import br.com.tairoroberto.sistemafinanceiro.util.FacesUtil;
import br.com.tairoroberto.sistemafinanceiro.util.Repositorios;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tairo on 28/02/15.
 */
@ManagedBean
@ViewScoped
public class CadastroPessoaBean {
    private Repositorios repositorios = new Repositorios();
    private Pessoa pessoa = new Pessoa();
    private List<RamoAtividade> ramosAtividadeses = new ArrayList<RamoAtividade>();


    @PostConstruct
    public void init(){
        RamosAtividades ramosAtividades = this.repositorios.getRamosAtividates();

        this.ramosAtividadeses = ramosAtividades.todas();

    }

    public void verificaTipo(ValueChangeEvent event){
        this.pessoa.setTipo((TipoPessoa) event.getNewValue());
        this.pessoa.setDataNascimento(null);

        //pula todasa as validações e rederiza tela
        FacesContext.getCurrentInstance().renderResponse();
    }

    public void cadastrar() {
        Pessoas pessoas = this.repositorios.getPessoas();
        pessoas.cadastrar(this.pessoa);

        this.pessoa = new Pessoa();
        String msg = "Cadastro efetuado com sucesso!";

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,msg,msg));
    }

    public TipoPessoa[] getTiposPessoas(){
        return TipoPessoa.values();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public List<RamoAtividade> getRamosAtividadeses() {
        return ramosAtividadeses;
    }
}
