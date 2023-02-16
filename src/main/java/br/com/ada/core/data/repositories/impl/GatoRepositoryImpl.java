package br.com.ada.core.data.repositories.impl;

import br.com.ada.core.data.config.SessionManager;
import br.com.ada.core.data.entities.Dono;
import br.com.ada.core.data.entities.Gato;
import br.com.ada.core.data.entities.Produto;
import br.com.ada.core.data.entities.Venda;
import br.com.ada.core.data.repositories.GatoRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GatoRepositoryImpl implements GatoRepository {

    private Session session = SessionManager.obterSessao();

    @Override
    public Gato findById(Integer id) {
        return (Gato) session.createQuery("from Gato where id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public String createGato(Gato gato) {
        session.save(gato);
        session.beginTransaction();
        session.getTransaction().commit();
        return "Criado";
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
