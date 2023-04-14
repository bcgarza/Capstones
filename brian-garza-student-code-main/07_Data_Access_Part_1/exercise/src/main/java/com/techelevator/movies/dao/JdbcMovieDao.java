package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import com.techelevator.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcMovieDao implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Movie> getMovies() {
        List<Movie> movieList = new ArrayList<>();
        String sql = "Select * From movie;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()){
            Movie movie = mapRowToMovie(result);
            movieList.add(movie);
        }
        return movieList;
    }

    @Override
    public Movie getMovieById(int id) {
        Movie movie = new Movie();
        String sql = "Select * From movie Where movie_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if (result.next()) {
            movie = mapRowToMovie(result);
        }else{
            return null;
        }
        return movie;
    }

    @Override
    public List<Movie> getMoviesByTitle(String title, boolean useWildCard) {
        List<Movie> movieList = new ArrayList<>();
        String sql = "Select * From movie Where title ILike ?;";
        if(useWildCard){
            title = "%"+title+"%";
        }
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, title);
        while(result.next()){
            Movie movie = mapRowToMovie(result);
            movieList.add(movie);
        }
        return movieList;
    }

    @Override
    public List<Movie> getMoviesByDirectorNameBetweenYears(String directorName, int startYear,
           int endYear, boolean useWildCard) {
        List<Movie> movieList = new ArrayList<>();
        String sql = "Select * From movie Where director_id In (Select person_id From person Where (person_name ILike ?)) And (release_date Between ? and ?);";
        if(useWildCard){
            directorName = "%"+directorName+"%";
        }
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, directorName, LocalDate.of(startYear,1,1), LocalDate.of(endYear,12,31));
        while(result.next()){
            Movie movie = mapRowToMovie(result);
            movieList.add(movie);
        }
        return movieList;
    }

    private Movie mapRowToMovie(SqlRowSet rowSet) {
        Movie movie = new Movie();
        movie.setId(rowSet.getInt("movie_id"));
        movie.setTitle(rowSet.getString("title"));
        movie.setOverview(rowSet.getString("overview"));
        movie.setTagline(rowSet.getString("tagline"));
        movie.setPosterPath(rowSet.getString("poster_path"));
        movie.setHomePage(rowSet.getString("home_page"));
        movie.setReleaseDate(rowSet.getDate("release_date").toLocalDate());
        movie.setLengthMinutes(rowSet.getInt("length_minutes"));
        movie.setDirectorId(rowSet.getInt("director_id"));
        movie.setCollectionId(rowSet.getInt("collection_id"));
        return movie;
    }

}
