package br.com.tairoroberto.sistemafinanceiro.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by tairo on 01/03/15.
 */
public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ServiceRegistry registry =
                    new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            SESSION_FACTORY = configuration.buildSessionFactory(registry);
        }catch (Throwable e){
            throw new ExceptionInInitializerError(e);

        }
    }

    public static Session getSession(){
        return SESSION_FACTORY.openSession();
    }
}
