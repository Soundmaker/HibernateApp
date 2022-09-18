package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    @ManyToOne
    @JoinColumn(name = "director_id" , referencedColumnName = "director_id")
    private Director creator;

    @Column(name ="name")
    private String name;

    @Column(name ="year_of_production")
    private String yearOfProduct;
    public Movie() {
    }

    public Movie(String name, String yearOfProduct,Director creator) {
        this.name = name;
        this.yearOfProduct = yearOfProduct;
        this.creator = creator;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfProduct() {
        return yearOfProduct;
    }

    public void setYearOfProduct(String yearOfProduct) {
        this.yearOfProduct = yearOfProduct;
    }

    public Director getCreator() {
        return creator;
    }

    public void setCreator(Director creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
                ", yearOfProduct='" + yearOfProduct + '\'' +
                '}';
    }
}
