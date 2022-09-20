package org.example;

import org.example.model.Principal;
import org.example.model.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(School.class)
                .addAnnotatedClass(Principal.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Principal principal = session.get(Principal.class,4);
            session.remove(principal);
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }
}
