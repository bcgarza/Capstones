package com.techelevator.dao;

import com.techelevator.model.Movie;
import com.techelevator.model.User;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMovieDao implements MovieDao {

    private JdbcTemplate template;
    public JdbcMovieDao(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean addMovie(Movie movie) {

        String movieId = movie.getMovieId();
        String movieTitle = movie.getMovieTitle();
        String movieGenre = movie.getMovieGenre();
        boolean isAlreadyWatched = movie.isAlreadyWatched();
        int movieRating = movie.getMovieRating();
        boolean isWantToWatch = movie.isWantToWatch();
        String imageURL = movie.getImageURL();

        String addMovieSql = "INSERT INTO movies (movie_id, movie_title, movie_genre, already_watched, movie_rating, want_to_watch, img_url) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";

        try {
            template.update(addMovieSql, movieId, movieTitle, movieGenre, isAlreadyWatched, movieRating, isWantToWatch, imageURL);
            return true;
        } catch (DataAccessException e) {
            String errorMessage = "Failed to add movie to database: " + e.getMessage();
            System.out.println(errorMessage);
            return false;
        }
    }

    @Override
    public Movie getMovieById(String movieId) {

        String getMovieByIdSql = "SELECT movie_id, movie_title, movie_genre, already_watched, movie_rating, want_to_watch, img_url " +
                "FROM movies WHERE movie_id = ?;";

        try {
            SqlRowSet rowSet = template.queryForRowSet(getMovieByIdSql, movieId);
            if(rowSet.next()) {
                return mapRowToMovie(rowSet);
            }
        } catch (DataAccessException e) {
            String errorMessage = "Failed to fetch movie from database: " + e.getMessage();
        }

        return null;
    }

    //added these methods for the profile section of the page. 
    @Override
    public List<Movie> getWatchedMovies() {
        String getWatchedMoviesSql = "SELECT movie_id, movie_title, movie_genre, already_watched, movie_rating, want_to_watch, img_url " +
                "FROM movies WHERE already_watched = true;";

        List<Movie> watchedMovies = new ArrayList<>();

        try {
            SqlRowSet rowSet = template.queryForRowSet(getWatchedMoviesSql);
            while (rowSet.next()) {
                Movie movie = mapRowToMovie(rowSet);
                watchedMovies.add(movie);
            }
        } catch (DataAccessException e) {
            String errorMessage = "Failed to fetch watched movies from database: " + e.getMessage();
        }

        return watchedMovies;
    }

    @Override
    public List<Movie> getWantToWatchMovies() {
        String getWantToWatchMoviesSql = "SELECT movie_id, movie_title, movie_genre, already_watched, movie_rating, want_to_watch, img_url " +
                "FROM movies WHERE want_to_watch = true;";

        List<Movie> wantToWatchMovies = new ArrayList<>();

        try {
            SqlRowSet rowSet = template.queryForRowSet(getWantToWatchMoviesSql);
            while (rowSet.next()) {
                Movie movie = mapRowToMovie(rowSet);
                wantToWatchMovies.add(movie);
            }
        } catch (DataAccessException e) {
            String errorMessage = "Failed to fetch want-to-watch movies from database: " + e.getMessage();
        }

        return wantToWatchMovies;
    }

    public Movie mapRowToMovie (SqlRowSet result) {
        Movie movie = new Movie();
        movie.setMovieId(result.getString("movie_id"));
        movie.setMovieTitle(result.getString("movie_title"));
        movie.setMovieGenre(result.getString("movie_genre"));
        movie.setAlreadyWatched(result.getBoolean("already_watched"));
        movie.setMovieRating(result.getInt("movie_rating"));
        movie.setWantToWatch(result.getBoolean("want_to_watch"));
        movie.setImageURL(result.getString("img_url"));
        return movie;
    }

}
