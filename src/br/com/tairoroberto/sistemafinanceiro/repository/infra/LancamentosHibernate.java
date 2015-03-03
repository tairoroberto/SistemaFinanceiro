package br.com.tairoroberto.sistemafinanceiro.repository.infra;

import br.com.tairoroberto.sistemafinanceiro.model.Lancamento;
import br.com.tairoroberto.sistemafinanceiro.repository.Lancamentos;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import java.util.List;

/**
 * Created by tairo on 02/03/15.
 */
public class LancamentosHibernate implements Lancamentos {

   private Session session;

    public LancamentosHibernate(Session session) {
        this.session = session;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Lancamento> todos() {
        return session.createCriteria(Lancamento.class)
                .addOrder(Order.asc("dataVencimento"))
                .list();
    }

    @Override
    public Lancamento porCodigo(Integer codigo) {
        return (Lancamento) session.get(Lancamento.class, codigo);
    }

    @Override
    public void cadastrar(Lancamento lancamento) {
        session.merge(lancamento);
    }

    @Override
    public void deletar(Lancamento lancamento) {
        session.delete(lancamento);
    }

    @Override
    public void editar(Lancamento lancamento) {

    }

}
