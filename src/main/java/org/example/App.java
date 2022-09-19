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

            Director director = session.get(Director.class,4);
            Movie movie = session.get(Movie.class,1);
            movie.setCreator(director);

            director.getMovies().add(movie);
            movie.getCreator().getMovies().remove(movie);


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
