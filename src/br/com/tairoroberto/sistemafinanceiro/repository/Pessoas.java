package br.com.tairoroberto.sistemafinanceiro.repository;

import br.com.tairoroberto.sistemafinanceiro.model.Pessoa;

import java.util.List;

/**
 * Created by tairo on 02/03/15.
 */
public interface Pessoas {

    public List<Pessoa> todas();
    public Pessoa porCodigo(Integer codigo);
    public void cadastrar(Pessoa pessoa);
    public void deletar(Pessoa pessoa);
    public void editar(Pessoa pessoa);

}
