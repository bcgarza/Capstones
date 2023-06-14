package com.techelevator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.Movie;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class MovieService {

    private static final String API_BASE_URL = "https://api.themoviedb.org/3/";
    private static final String API_KEY = "07ea57459d13aa2621fd373d9609099c";
    private static final String BEARER_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwN2VhNTc0NTlkMTNhYTI2MjFmZDM3M2Q5NjA5MDk5YyIsInN1YiI6IjY0NzY3MzA2ZDM3MTk3MDBmOWNhNTU5NSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.dEAiGaFj9Hqqp2N5B--xtDyi9QOfNLBMdspf8fwz5Xo";

    private final RestTemplate restTemplate = new RestTemplate();

    private int convertGenreNameToId(String genreName) {
        Map<String, Integer> genreMap = new HashMap<>();

        genreMap.put("action", 28);
        genreMap.put("adventure", 12);
        genreMap.put("animation", 16);
        genreMap.put("comedy", 35);
        genreMap.put("crime", 80);
        genreMap.put("documentary", 99);
        genreMap.put("drama", 18);
        genreMap.put("family", 10751);
        genreMap.put("fantasy", 14);
        genreMap.put("history", 36);
        genreMap.put("horror", 27);
        genreMap.put("music", 10402);
        genreMap.put("mystery", 9648);
        genreMap.put("romance", 10749);
        genreMap.put("scifi", 878);
        genreMap.put("thriller", 53);

        return genreMap.getOrDefault(genreName.toLowerCase(), -1);
    }

    private String buildRequestUrl(int genreId, int page, int perPage) {
        String url = API_BASE_URL + "discover/movie" +
                    "?api_key=" + API_KEY +
                    "&with_original_language=en" +
                    "&sort_by=popularity" +
                    "&page=" + page +
                    "&with_genres=" + genreId +
                    "&per_page=" + perPage;
        return url;
    }

//    private String buildRequestUrl(int genreId, int page, int perPage) {
//        String url = API_BASE_URL + "discover/movie" +
//                "?api_key=" + API_KEY +
//                "&language=en-US" +
//                "&sort_by=release_date.desc" +
//                "&page=" + page +
//                "&with_genres=" + genreId +
//                "&per_page=" + perPage;
//        return url;
//    }

    private HttpHeaders createHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        headers.set("Authorization", "Bearer " + BEARER_TOKEN);
        return headers;
    }

    private int randomPageNumber(int upperLimit, int lowerLimit) {
        Random random = new Random();
        return random.nextInt((upperLimit - lowerLimit) + lowerLimit);
    }

    public Movie[] getMoviesByGenre(String movieGenre) {

        int page = randomPageNumber(50, 1);
        int perPage = 20;

        int genreId = convertGenreNameToId(movieGenre);
        String url = buildRequestUrl(genreId, page, perPage);
        HttpHeaders headers = createHttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response;

        response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    String.class
            );

        System.out.println(response);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(response.getBody());
            JsonNode results = jsonNode.path("results");

            Movie[] movies = new Movie[results.size()];

            for(int i=0; i < results.size(); i++) {
                results.path(i);

                String title = results.path(i).path("title").asText();
                String movieId = results.path(i).path("id").asText();
                String imgURL = results.path(i).path("poster_path").asText();

                Movie movie = new Movie();
                movie.setMovieTitle(title);
                movie.setMovieId(movieId);
                movie.setImageURL("https://image.tmdb.org/t/p/original" + imgURL);

                movies[i] = movie;
            }
            return movies;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Movie[] getMoviesByPreferences(String[] preferences) {

        List<Movie> movieList = new ArrayList<>();

        for(String genre : preferences) {
            Movie[] movies = getMoviesByGenre(genre);
            if(movies != null) {
                movieList.addAll(Arrays.asList(movies));
            }
        }

        Collections.shuffle(movieList);

        return movieList.toArray(new Movie[0]);
    }

}
