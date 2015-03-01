package br.com.tairoroberto.sistemafinanceiro.service;

import br.com.tairoroberto.sistemafinanceiro.model.Pessoa;
import br.com.tairoroberto.sistemafinanceiro.model.RamoAtividade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tairo on 28/02/15.
 */
public class GestaoRamosAtividades implements Serializable {
    private static HashMap<Integer,RamoAtividade> ramosAtividades = new HashMap<Integer, RamoAtividade>();

    static {
        ramosAtividades.put(1, new RamoAtividade(1,"Programador"));
        ramosAtividades.put(2, new RamoAtividade(2,"Web design"));
        ramosAtividades.put(3, new RamoAtividade(3,"gerente de projetos"));
    }

    public List<RamoAtividade> listarTodas() {
        List<RamoAtividade> ramoAtividades = new ArrayList<RamoAtividade>();
        ramoAtividades.addAll(GestaoRamosAtividades.ramosAtividades.values());
        return ramoAtividades;
    }
    public RamoAtividade buscarPorCodico(Integer codigo) {
        return ramosAtividades.get(codigo);
    }
}
