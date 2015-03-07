package br.com.tairoroberto.sistemafinanceiro.repository;

import br.com.tairoroberto.sistemafinanceiro.model.Lancamento;

import java.util.List;

/**
 * Created by tairo on 02/03/15.
 */
public interface Lancamentos {

    public List<Lancamento> todos();
    public Lancamento porCodigo(Integer codigo);
    public void cadastrar(Lancamento lancamento);
    public void deletar(Lancamento lancamento);
    public void editar(Lancamento lancamento);
    public Lancamento comDadosIguais(Lancamento lancamento);
}
