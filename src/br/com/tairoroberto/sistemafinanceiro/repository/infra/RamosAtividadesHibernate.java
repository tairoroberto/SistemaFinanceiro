package br.com.tairoroberto.sistemafinanceiro.repository.infra;

import br.com.tairoroberto.sistemafinanceiro.model.RamoAtividade;
import br.com.tairoroberto.sistemafinanceiro.repository.RamosAtividades;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import java.util.List;

/**
 * Created by tairo on 02/03/15.
 */
public class RamosAtividadesHibernate implements RamosAtividades {

    private Session session;

    public RamosAtividadesHibernate(Session session) {
        this.session = session;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<RamoAtividade> todas() {
        return  session.createCriteria(RamoAtividade.class)
                .addOrder(Order.asc("descricao"))
                .list();
    }

    @Override
    public RamoAtividade porCodigo(Integer codigo) {
        return (RamoAtividade) session.get(RamoAtividade.class, codigo);
    }

    @Override
    public void cadastrar(RamoAtividade ramoAtividade) {
        session.merge(ramoAtividade);
    }

    @Override
    public void deletar(RamoAtividade ramoAtividade) {
        session.delete(ramoAtividade);
    }

    @Override
    public void editar(RamoAtividade ramoAtividade) {

    }
}
