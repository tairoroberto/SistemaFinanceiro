package br.com.tairoroberto.sistemafinanceiro.model;

import java.io.Serializable;

/**
 * Created by tairo on 28/02/15.
 */
public enum TipoPessoa implements Serializable{
    FISICA("Fisica"),
    JURIDICA("Juridica");

    private String descricaoTipo;

    TipoPessoa(String descricaoTipo) {
        this.descricaoTipo = descricaoTipo;
    }

    public String getDescricaoTipo() {
        return descricaoTipo;
    }
}
