package br.com.tairoroberto.sistemafinanceiro.repository;

import br.com.tairoroberto.sistemafinanceiro.model.RamoAtividade;

import java.util.List;

/**
 * Created by tairo on 02/03/15.
 */
public interface RamosAtividades {

    public List<RamoAtividade> todas();
    public RamoAtividade porCodigo(Integer codigo);
    public void cadastrar(RamoAtividade ramoAtividade);
    public void deletar(RamoAtividade ramoAtividade);
    public void editar(RamoAtividade ramoAtividade);
}
