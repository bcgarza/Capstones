package com.techelevator.dao;

import com.techelevator.model.Movie;
import com.techelevator.model.User;

import java.util.List;

public interface MovieDao {

    public boolean addMovie(Movie movie);

    public Movie getMovieById(String movieId);

    public List<Movie> getWatchedMovies(); // Add this method

    public List<Movie> getWantToWatchMovies(); // Add this method

}
