package br.com.tairoroberto.sistemafinanceiro.view;

import br.com.tairoroberto.sistemafinanceiro.model.Pessoa;
import br.com.tairoroberto.sistemafinanceiro.model.RamoAtividade;
import br.com.tairoroberto.sistemafinanceiro.model.TipoPessoa;
import br.com.tairoroberto.sistemafinanceiro.repository.Pessoas;
import br.com.tairoroberto.sistemafinanceiro.repository.RamosAtividades;
import br.com.tairoroberto.sistemafinanceiro.service.GestaoPessoas;
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
        GestaoPessoas gestaoPessoas = new GestaoPessoas(this.repositorios.getPessoas());
        gestaoPessoas.salvar(this.pessoa);

        FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO,"Cadastro efetuado com sucesso!");
        this.pessoa = new Pessoa();
    }

    public boolean isEditando(){
        return this.pessoa.getCodigo() != null;
    }

    public TipoPessoa[] getTiposPessoas(){
        return TipoPessoa.values();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    //para não retornar nullo devemos instanciar uma nova pessoa senão irá gerar uma NullPointerException
    public void setPessoa(Pessoa pessoa) throws CloneNotSupportedException {
        this.pessoa = pessoa;
        if (this.pessoa == null){
            this.pessoa = new Pessoa();
        }else{
            //retorna um clone para evitar erro no hibernate
            this.pessoa = (Pessoa) pessoa.clone();
        }
    }

    public List<RamoAtividade> getRamosAtividadeses() {
        return ramosAtividadeses;
    }
}
