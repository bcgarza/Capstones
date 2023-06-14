import axios from 'axios';

// const http = axios.create({
//     baseURL : ''
// });

export default { // still needs to have paths updated
    
    addMovie(movie) {
        return axios.post('/movies/add', movie);
    },

    // getMoviesByGenre(movieGenre) {
    //     return axios.get(`/genre/${movieGenre}`);
    // },

    //new method to pull from all preferences
        getMoviesByPreferences() {
        return axios.get('/movies/preferences');
    },

    //do i need to add this for the profile page so i can find the movie by 
    //id in the database and then us the wanttowatch property?
    getMoviesById(id){
        return axios.get(`/movies/${id}`)
    },

    getWatchedMovies(){
        return axios.get(`/movies/watched`)
    },

    getWantToWatchMovies(){
        return axios.get(`/movies/want-to-watch`)
    },
     getRatings(){
         return axios.get(`/movies/movie-rating`)
    }

}




