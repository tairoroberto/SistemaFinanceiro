package br.com.tairoroberto.sistemafinanceiro.view;

import br.com.tairoroberto.sistemafinanceiro.model.RamoAtividade;
import br.com.tairoroberto.sistemafinanceiro.repository.RamosAtividades;
import br.com.tairoroberto.sistemafinanceiro.service.GestaoRamosAtividades;
import br.com.tairoroberto.sistemafinanceiro.util.FacesUtil;
import br.com.tairoroberto.sistemafinanceiro.util.Repositorios;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tairo on 08/03/15.
 */

@ManagedBean
@ViewScoped
public class ConsultaRamoAtividadeBean {
    Repositorios repositorios = new Repositorios();
    List<RamoAtividade> ramoAtividades = new ArrayList<RamoAtividade>();
    RamoAtividade ramoAtividadeSelecionada;

    @PostConstruct
    public void inicializar() {
        RamosAtividades ramosAtividades = this.repositorios.getRamosAtividates();
        this.ramoAtividades = ramosAtividades.todas();
    }

    public  void deletar(){
        try{
            GestaoRamosAtividades gestaoRamosAtividades = new GestaoRamosAtividades(this.repositorios.getRamosAtividates());
            gestaoRamosAtividades.deletar(this.ramoAtividadeSelecionada);
            this.inicializar();
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Atividade deletada com sucesso!");
        }catch (Exception e){
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR,"Não foi possível deletar :"+ e.getMessage());
        }
    }

    public List<RamoAtividade> getRamoAtividades() {
        return ramoAtividades;
    }

    public RamoAtividade getRamoAtividadeSelecionada() {
        return ramoAtividadeSelecionada;
    }

    public void setRamoAtividadeSelecionada(RamoAtividade ramoAtividadeSelecionada) {
        this.ramoAtividadeSelecionada = ramoAtividadeSelecionada;
    }
}
