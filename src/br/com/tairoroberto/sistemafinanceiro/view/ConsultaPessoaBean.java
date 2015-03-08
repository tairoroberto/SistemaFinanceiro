package br.com.tairoroberto.sistemafinanceiro.view;

import br.com.tairoroberto.sistemafinanceiro.model.Pessoa;
import br.com.tairoroberto.sistemafinanceiro.repository.Pessoas;
import br.com.tairoroberto.sistemafinanceiro.service.GestaoPessoas;
import br.com.tairoroberto.sistemafinanceiro.util.FacesUtil;
import br.com.tairoroberto.sistemafinanceiro.util.Repositorios;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class ConsultaPessoaBean {
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
    private Pessoa pessoaSelecionada;
    private Repositorios repositorios = new Repositorios();
	
	@PostConstruct
	public void inicializar() {
        Pessoas pessoas = this.repositorios.getPessoas();
        this.pessoas = pessoas.todas();
	}

    public  void deletar(){
        try{
            GestaoPessoas gestaoPessoas = new GestaoPessoas(this.repositorios.getPessoas());
            gestaoPessoas.deletar(this.pessoaSelecionada);
            this.inicializar();
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO,"Pessoa deletada com sucesso!");
        }catch (Exception e){
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR,"Não foi possível deletar :"+ e.getMessage());
        }

    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public Pessoa getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
    }
}
