package org.example;

import org.example.model.Actor;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {

        Configuration configuration = new Configuration().addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);


        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // try with resources (можно без finally)
        try (sessionFactory){
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();


            Actor actor = session.get(Actor.class, 2);
            Movie movieToRemove = actor.getMovies().get(0);

            actor.getMovies().remove(0); // либо по объекту
            movieToRemove.getActors().remove(actor); // Нужен hashcode и equals

            // Добавление фильма к существующему актеру
//            Movie movie = new Movie("Reservoir Dogs", 1992);
//            Actor actor = session.get(Actor.class, 1);
//
//            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
//
//            actor.getMovies().add(movie);
//
//            session.persist(movie);

//            Movie movie = session.get(Movie.class, 1);
//            System.out.println(movie.getActors());
//            Movie movie = new Movie("Pulp fiction", 1994);
//            Actor actor1 = new Actor("Harvy Keitel",81);
//            Actor actor2 = new Actor("Samuel L. Jackson",72);
//
//            // Arrays.asList() - изменяемый, но не расширяемый
//            // List.of - неизменяемый список
//            movie.setActors(new ArrayList<>(List.of(actor1,actor2)));
//
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//
//            session.persist(movie);
//
//            session.persist(actor1);
//            session.persist(actor2);

            session.getTransaction().commit();
        }

    }
}
