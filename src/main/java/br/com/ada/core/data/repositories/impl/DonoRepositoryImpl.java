package br.com.ada.core.data.repositories.impl;

import br.com.ada.core.data.entities.Dono;
import br.com.ada.core.data.entities.Gato;
import br.com.ada.core.data.entities.Produto;
import br.com.ada.core.data.entities.Venda;
import br.com.ada.core.data.repositories.DonoRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DonoRepositoryImpl implements DonoRepository {

    private Session session = obterSessao();

    @Override
    public Dono findById(Integer id) {
        return (Dono) session.createQuery("from Dono where id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

    private static Session obterSessao() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Gato.class);
        configuration.addAnnotatedClass(Produto.class);
        configuration.addAnnotatedClass(Venda.class);
        configuration.addAnnotatedClass(Dono.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        return session;
    }
}
