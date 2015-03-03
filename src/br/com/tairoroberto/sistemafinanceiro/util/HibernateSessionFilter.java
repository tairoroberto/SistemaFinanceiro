package br.com.tairoroberto.sistemafinanceiro.util;


import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by tairo on 02/03/15.
 *
 * classe para interceptar as transações com o banco de dados
 */

@WebFilter(servletNames = "Faces Servlet")
public class HibernateSessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            request.setAttribute("session",session);
            filterChain.doFilter(request,response);

            transaction.commit();
        }catch (Exception e){
            //Verifica se trassaction é nula, se não for faz o roolback
            //para retornar os valores de antes da mudança
            if (transaction != null){
                transaction.rollback();
            }
        }finally {
            session.close();
        }
    }

    @Override
    public void destroy() {

    }
}
