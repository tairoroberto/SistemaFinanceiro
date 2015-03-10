package br.com.tairoroberto.sistemafinanceiro.view;

import br.com.tairoroberto.sistemafinanceiro.model.RamoAtividade;
import br.com.tairoroberto.sistemafinanceiro.service.GestaoRamosAtividades;
import br.com.tairoroberto.sistemafinanceiro.util.FacesUtil;
import br.com.tairoroberto.sistemafinanceiro.util.Repositorios;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by tairo on 08/03/15.
 */

@ManagedBean
@ViewScoped
public class CadastroRamoAtividadeBean {
    private Repositorios repositorios = new Repositorios();
    RamoAtividade ramoAtividade = new RamoAtividade();

    public void salvar() {
        GestaoRamosAtividades gestaoRamosAtividades = new GestaoRamosAtividades(this.repositorios.getRamosAtividates());
        gestaoRamosAtividades.cadastar(this.ramoAtividade);

        FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Cadastro efetuado com sucesso!");
        this.ramoAtividade = new RamoAtividade();
    }
    public boolean isEditando(){
        return this.ramoAtividade.getCodigo() != null;
    }


    public RamoAtividade getRamoAtividade() {
        return ramoAtividade;
    }

    public void setRamoAtividade(RamoAtividade ramoAtividade) throws CloneNotSupportedException {
        this.ramoAtividade = ramoAtividade;

        if (this.ramoAtividade == null){
            this.ramoAtividade = new RamoAtividade();
        }else{
            //retorna um clone para evitar erro no hibernate
            this.ramoAtividade = (RamoAtividade) ramoAtividade.clone();
        }
    }
}
