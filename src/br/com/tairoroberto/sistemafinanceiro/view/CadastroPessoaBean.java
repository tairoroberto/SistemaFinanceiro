package br.com.tairoroberto.sistemafinanceiro.view;

import br.com.tairoroberto.sistemafinanceiro.model.Lancamento;
import br.com.tairoroberto.sistemafinanceiro.model.Pessoa;
import br.com.tairoroberto.sistemafinanceiro.model.RamoAtividade;
import br.com.tairoroberto.sistemafinanceiro.model.TipoPessoa;
import br.com.tairoroberto.sistemafinanceiro.service.GestaoRamosAtividades;

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
    private Pessoa pessoa = new Pessoa();
    private List<RamoAtividade> ramosAtividadeses = new ArrayList<RamoAtividade>();


    @PostConstruct
    public void init(){
        GestaoRamosAtividades gestaoRamosAtividades = new GestaoRamosAtividades();
        this.ramosAtividadeses = gestaoRamosAtividades.listarTodas();
    }

    public void verificaTipo(ValueChangeEvent event){
        this.pessoa.setTipo((TipoPessoa) event.getNewValue());
        this.pessoa.setDataNascimento(null);
        this.pessoa.setRamoAtividade(new RamoAtividade());

        //pula todasa as validações e rederiza tela
        FacesContext.getCurrentInstance().renderResponse();
    }

    public void cadastrar() {
        System.out.println("Nome: " + this.pessoa.getNome());
        System.out.println("Tipo: " + this.pessoa.getTipo().getDescricaoTipo());
        System.out.println("E-mail: " + this.pessoa.getEmail());
        System.out.println("Data de nascimento: " + this.pessoa.getDataNascimento());
        System.out.println("Ramo de atividade: " + this.pessoa.getRamoAtividade().getDescricao());

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
