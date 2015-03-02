import br.com.tairoroberto.sistemafinanceiro.model.Pessoa;
import br.com.tairoroberto.sistemafinanceiro.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by tairo on 01/03/15.
 */
public class TesteHibernate {
    public static void main(String[] args){
        Session session = HibernateUtil.getSession();

        List<Pessoa> pessoas = session.createCriteria(Pessoa.class).list();

        for (Pessoa pessoa: pessoas){
            System.out.println("Id: " + pessoa.getCodigo());
            System.out.println("Nome: " + pessoa.getNome());
        }
        session.close();
    }
}
