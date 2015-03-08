package br.com.tairoroberto.sistemafinanceiro.repository.infra;

import br.com.tairoroberto.sistemafinanceiro.model.Pessoa;
import br.com.tairoroberto.sistemafinanceiro.repository.Pessoas;
import br.com.tairoroberto.sistemafinanceiro.util.FacesUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import java.util.List;

/**
 * Created by tairo on 02/03/15.
 */
public class PessoasHibernate implements Pessoas {
    private Session session;

    public PessoasHibernate(Session session) {
        this.session = session;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Pessoa> todas() {
        return session.createCriteria(Pessoa.class)
                .addOrder(Order.asc("nome"))
                .list();
    }

    @Override
    public Pessoa porCodigo(Integer codigo) {
        return (Pessoa) session.get(Pessoa.class, codigo);
    }

    @Override
    public void cadastrar(Pessoa pessoa) {
        session.merge(pessoa);
    }

    @Override
    public void deletar(Pessoa pessoa) {
        session.delete(pessoa);
    }

    @Override
    public void editar(Pessoa pessoa) {

    }
}
