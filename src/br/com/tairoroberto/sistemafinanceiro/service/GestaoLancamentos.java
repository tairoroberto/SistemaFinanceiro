package br.com.tairoroberto.sistemafinanceiro.service;

import br.com.tairoroberto.sistemafinanceiro.model.Lancamento;
import br.com.tairoroberto.sistemafinanceiro.repository.Lancamentos;
import br.com.tairoroberto.sistemafinanceiro.util.FacesUtil;

/**
 * Created by tairo on 07/03/15.
 */
public class GestaoLancamentos {

    private Lancamentos lancamentos;

    public GestaoLancamentos(Lancamentos lancamentos) {
        this.lancamentos = lancamentos;
    }

    //Cadastrar Lancamento
    public void salvar(Lancamento lancamento) throws RegraNegocioException {
        if (existeLacamentoSemelhante(lancamento)){
            throw new RegraNegocioException("existing_entry");
        }
        this.lancamentos.cadastrar(lancamento);
    }

    //verifica se existe lancamento igual na base
    private boolean existeLacamentoSemelhante(Lancamento lancamento) {
        Lancamento lancamentoSemelhante = this.lancamentos.comDadosIguais(lancamento);

        return lancamentoSemelhante != null && !lancamentoSemelhante.equals(lancamento);
    }

    //Excuir lancamento
    public void excluir(Lancamento lancamento) throws RegraNegocioException {
        if (lancamento.isPago()){
            throw new RegraNegocioException("entry_does_not_be_deleted");
        }

        this.lancamentos.deletar(lancamento);

    }
}
