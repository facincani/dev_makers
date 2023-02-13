package br.com.ada;

import br.com.ada.entities.Gato;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;

public class HibernateExemplo {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Gato.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Gato mirosmar = new Gato();
        mirosmar.setNome("mirosmar");
        mirosmar.setDataNascimento(new Date());
        mirosmar.setIdDono(2);

        session.save(mirosmar);

    }

    @Deprecated
    private static void readGato(Session session) {
        List<Gato> gatos = session.createQuery("from Gato").getResultList();

        gatos.forEach(gato -> {
            System.out.printf("nome do gato: %s", gato.getNome());
            System.out.println();
        });
    }

}
