package br.com.tairoroberto.sistemafinanceiro.service;

import br.com.tairoroberto.sistemafinanceiro.model.RamoAtividade;
import br.com.tairoroberto.sistemafinanceiro.repository.RamosAtividades;

/**
 * Created by tairo on 08/03/15.
 */
public class GestaoRamosAtividades {

    private RamosAtividades ramosAtividades;

    public GestaoRamosAtividades(RamosAtividades ramosAtividades) {
        this.ramosAtividades = ramosAtividades;
    }

    public void cadastar(RamoAtividade ramoAtividade){
        this.ramosAtividades.cadastrar(ramoAtividade);
    }

    public void deletar(RamoAtividade ramoAtividade){
        this.ramosAtividades.deletar(ramoAtividade);
    }
}
