package com.techelevator.controller;

import com.techelevator.dao.JdbcMovieDao;
import com.techelevator.dao.MovieDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Movie;
import com.techelevator.model.User;
import com.techelevator.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class MovieController {

//    @Autowired
//    private JdbcMovieDao movieDao;
    private final MovieDao movieDao;
    private final MovieService movieService;
    private final UserDao userDao;

    @Autowired
    public MovieController(MovieService movieService, MovieDao movieDao, UserDao userDao) {
        this.movieService = movieService;
        this.movieDao = movieDao;
        this.userDao= userDao;
    }

    // Movie Service / API methods:

    @RequestMapping(value = "/genre/{movieGenre}", method = RequestMethod.GET)
    public Movie[] getMoviesByGenre(@PathVariable("movieGenre") String movieGenre) {
        Movie[] movies = movieService.getMoviesByGenre(movieGenre);

        return movies;
    }

    //JdbcMovieDao / database methods:

    @RequestMapping(path = "/movies/add", method = RequestMethod.POST)
    public void addMovie(@RequestBody Movie movie) {

        System.out.println("hello?");
        System.out.println(movie);

        movieDao.addMovie(movie);
    }

    @RequestMapping(path = "/movies/{movieId}", method = RequestMethod.GET)
    public Movie getMovieById (@PathVariable String movieId) {
        Movie movie = movieDao.getMovieById(movieId);
        if(movie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found.");
        } else {
            return movie;
        }
    }

    @RequestMapping(path = "/movies/watched", method = RequestMethod.GET) // Add this new method
    public List<Movie> getWatchedMovies() {
        List<Movie> watchedMovies = movieDao.getWatchedMovies();
        if (watchedMovies == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No watched movies found.");
        } else {
            return watchedMovies;
        }
    }

    @RequestMapping(path = "/movies/want-to-watch", method = RequestMethod.GET) // Add this new method
    public List<Movie> getWantToWatchMovies() {
        List<Movie> wantToWatchMovies = movieDao.getWantToWatchMovies();
        if (wantToWatchMovies == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No want to watch movies found.");
        } else {
            return wantToWatchMovies;
        }
    }

    //method to get Movie list for all of "user" genres
    @RequestMapping(value = "/movies/preferences", method = RequestMethod.GET)
    public Movie[] getMoviesByPreferences() {

        //get user info for "user"
        User userOne = userDao.getUserById(1);

        //use new userDao method to build array of genres that are listed as "true"
        String[] preferredGenres = userDao.getPreferredGenres(userOne);

        //use new MovieService method to cycle through array of preferences, call API for each, and load movies into array list, then randomize it
        Movie[] allMoviesByPreferences = movieService.getMoviesByPreferences(preferredGenres);

        return allMoviesByPreferences;
    }

}