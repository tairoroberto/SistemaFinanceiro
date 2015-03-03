package br.com.tairoroberto.sistemafinanceiro.view;

import br.com.tairoroberto.sistemafinanceiro.model.Lancamento;
import br.com.tairoroberto.sistemafinanceiro.repository.Lancamentos;
import br.com.tairoroberto.sistemafinanceiro.util.FacesUtil;
import br.com.tairoroberto.sistemafinanceiro.util.Repositorios;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class ConsultaLancamentoBean implements Serializable {

    private Repositorios repositorios = new Repositorios();
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
    private  Lancamento lancamentoSelecionado;

	@PostConstruct
	public void inicializar(){
        Lancamentos lancamentos = this.repositorios.getLacamentos();
        this.lancamentos = lancamentos.todos();
	}

    public void excluir(){
        if (this.lancamentoSelecionado.isPago()){
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR,
                    "Lançamento já foi pago e não pode ser excluído!");
        }else{
            Lancamentos lacamentos = this.repositorios.getLacamentos();
            lacamentos.deletar(this.lancamentoSelecionado);

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
