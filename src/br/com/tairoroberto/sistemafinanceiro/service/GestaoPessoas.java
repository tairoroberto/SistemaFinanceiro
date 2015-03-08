package br.com.tairoroberto.sistemafinanceiro.service;

import br.com.tairoroberto.sistemafinanceiro.model.Pessoa;
import br.com.tairoroberto.sistemafinanceiro.repository.Pessoas;

/**
 * Created by tairo on 08/03/15.
 */
public class GestaoPessoas {

    private Pessoas pessoas;

    public GestaoPessoas(Pessoas pessoas) {
        this.pessoas = pessoas;
    }

    public void salvar(Pessoa pessoa){
        this.pessoas.cadastrar(pessoa);
    }

    public void deletar(Pessoa pessoa){
        this.pessoas.deletar(pessoa);
    }

}
