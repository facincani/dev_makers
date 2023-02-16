package br.com.ada.core.data.config;

import br.com.ada.core.data.entities.Dono;
import br.com.ada.core.data.entities.Gato;
import br.com.ada.core.data.entities.Produto;
import br.com.ada.core.data.entities.Venda;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager {

    public static Session session = obterSessao();

    private SessionManager(){}


    public static Session obterSessao() {
        if (session == null) {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Gato.class);
            configuration.addAnnotatedClass(Produto.class);
            configuration.addAnnotatedClass(Venda.class);
            configuration.addAnnotatedClass(Dono.class);

            SessionFactory sessionFactory = configuration.buildSessionFactory();

            Session session = sessionFactory.openSession();
            return session;
        }else{
            return session;
        }
    }

}
