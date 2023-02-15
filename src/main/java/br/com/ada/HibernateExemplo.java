package br.com.ada;

import br.com.ada.entities.Gato;
import br.com.ada.entities.Produto;
import br.com.ada.entities.Venda;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class HibernateExemplo {

    public static void main(String[] args) {
        Session session = obterSessao();

        List<Produto> produtos = session.createQuery("from Produto").getResultList();

        produtos.forEach(produto -> {
            System.out.println(produto.getDescricao());
        });

    }

    private static Session obterSessao() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Gato.class);
        configuration.addAnnotatedClass(Produto.class);
        configuration.addAnnotatedClass(Venda.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        return session;
    }

    private static void deleteGato(Session session) {
        Query query = session.createQuery("from Gato where id = :id");
        query.setParameter("id", 4);
        Gato gato = (Gato) query.getSingleResult();

        session.delete(gato);

        session.beginTransaction();
        session.getTransaction().commit();
    }

    private static void updateGato(Session session) {
        Gato novoGato = readGato(session, 21);
        novoGato.setNome("Mario");

        session.update(novoGato);
        session.beginTransaction();
        session.getTransaction().commit();
    }

    private static Gato readGato(Session session, Integer id) {
        Gato gato =  (Gato) session
                .createQuery("from Gato where id = :id")
                .setParameter("id", id).getSingleResult();
        return gato;
    }

    private static void createGato(Session session) {
        Gato mirosmar = new Gato();
        mirosmar.setNome("Luigi");
        mirosmar.setDataNascimento(new Date());
        mirosmar.setIdDono(2);

        session.save(mirosmar);

        session.beginTransaction();
        session.getTransaction().commit();

    }

    private static void readGato(Session session) {
        List<Gato> gatos = session.createQuery("from Gato").getResultList();

        gatos.forEach(gato -> {
            System.out.printf("nome do gato: %s", gato.getNome());
            System.out.println();
        });
    }



}
