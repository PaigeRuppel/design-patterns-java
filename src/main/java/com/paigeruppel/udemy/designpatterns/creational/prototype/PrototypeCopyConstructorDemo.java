package com.paigeruppel.udemy.designpatterns.creational.prototype;

public class PrototypeCopyConstructorDemo {
    public static void main(String[] args) {
        Actor meryl = new Actor("Meryl Streep", new Movie("Kramer vs Kramer", "1979", "Robert Benton"));
        Actor dustin = new Actor(meryl);
        dustin.name = "Dustin Hoffman";
        System.out.println(meryl);
        System.out.println(dustin);
    }
}


class Movie {
    public String title;
    public String releaseYear;
    public String director;

    public Movie(String title, String releaseYear, String director) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", director='" + director + '\'' +
                '}';
    }
}

class Actor {
    public String name;
    public Movie  movie;

    public Actor(String name, Movie movie) {
        this.name = name;
        this.movie = movie;
    }

    // you can use a copy constructor to overcome the problem of passing references
    public Actor(Actor other) {
        name = other.name;
        movie = other.movie;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", movie=" + movie +
                '}';
    }
}
