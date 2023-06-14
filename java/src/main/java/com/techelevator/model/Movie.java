package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

    @JsonProperty("movie_id")
    private String movieId;

    @JsonProperty("movie_title")
    private String movieTitle;

    @JsonProperty("movie_genre")
    private String movieGenre;

    @JsonProperty("want_to_watch")
    private boolean wantToWatch;

    @JsonProperty("already_watched")
    private boolean alreadyWatched;

    @JsonProperty("movie_rating")
    private int movieRating;

    @JsonProperty("img_url")
    private String imageURL;

    public Movie() {
    }

    public Movie(String movieTitle, String movieGenre) {
        this.movieTitle = movieTitle;
        this.movieGenre = movieGenre;
    }

    public Movie(String movieId, String movieTitle, String movieGenre, String imageURL) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.movieGenre = movieGenre;
        this.imageURL = imageURL;
    }

    public Movie(String movieId, String movieTitle, String movieGenre, boolean wantToWatch,
                 boolean alreadyWatched, int movieRating, String imageURL) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.movieGenre = movieGenre;
        this.wantToWatch = wantToWatch;
        this.alreadyWatched = alreadyWatched;
        this.movieRating = movieRating;
        this.imageURL = imageURL;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                ", movieGenre='" + movieGenre + '\'' +
                ", wantToWatch=" + wantToWatch +
                ", alreadyWatched=" + alreadyWatched +
                ", movieRating=" + movieRating +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public boolean isWantToWatch() {
        return wantToWatch;
    }

    public void setWantToWatch(boolean wantToWatch) {
        this.wantToWatch = wantToWatch;
    }

    public boolean isAlreadyWatched() {
        return alreadyWatched;
    }

    public void setAlreadyWatched(boolean alreadyWatched) {
        this.alreadyWatched = alreadyWatched;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

}
