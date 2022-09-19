package org.example;

import org.example.model.Director;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Director director = new Director("Zack zack 2",20);

            Movie movie = new Movie("Nine",1976, director);

            director.setMovies(new ArrayList<>(Collections.singletonList(movie)));

            session.save(director);
            session.save(movie);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
