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

            Director director = session.get(Director.class,5);
            List<Movie> movies = director.getMovies();

            for (Movie movie: movies) {
                session.remove(movie);
            }

            director.getMovies().clear();
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
