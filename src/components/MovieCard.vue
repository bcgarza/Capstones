<template>

  <div class="card">

    <Movie v-bind:movie="movies[current]"/>

    <div id="rating-box">
        <div id="rating" v-if="show===true">

            <div class="star">

              <!-- Rating form -->
              <form @submit.prevent="" action="">
                
                <!-- Stars container -->
                <div v-for="(star, index) in stars" :key="index" class="stars">
                    <!-- Star icon -->
                    <i v-if="star <= currentRating" class="fas fa-star fa-2x checked" @click="updateCurrentRating(index)"></i>
                    <!-- Empty star icons -->
                    <i v-else class="far fa-star fa-2x" @click="updateCurrentRating(index + 1)"></i>
                </div>

              </form>
              
            </div>

        </div>
    </div>

    <div class="button-directive">

        <!-- Only playing with 'nah' button -- originally only has v-on:click="advance" -->
        <button id="nah" type="button" v-on:click="advance">Nah</button>
        <button id="seen" type="button" v-on:click.prevent="show= !show" v-if="show===false">Saw it Already</button>
        <button type="button" v-if="show===true" v-on:click="addToSeenAlready">Rate</button>  
        <button id="want" type="button" v-on:click="advanceWantWatch">Want to See It</button>

    </div>

  </div>

</template>

<script>

import Movie from '../components/Movie.vue'
import MovieService from '../services/MovieService.js';
// import star from '../components/star.vue';

export default {
  name: 'movie-card',
  components: {
    Movie,
    // star,
  },
  computed: {
    currentMovie() {
      return this.movies[this.$store.state.currentMovieIndex] || null;
    },
  },
  data() {
    return {
      movies: [], 
      current:0,
      show: false,
      selectedRating: 0,
      // Array to store the ratings (out of 5)
      stars: [1, 2, 3, 4, 5],
      // Variable to hold the currently selected rating
      currentRating: 0,
      } 
  },
  methods: {
    addToSeenAlready(){
      this.show = !this.show;
       this.movies[this.current].want_to_watch = false;
       this.movies[this.current].already_watched = true;
       this.movies[this.current].movie_rating = this.currentRating;
       this.currentRating = 0;
        MovieService.addMovie(this.movies[this.current])
        .then(
           (response) => {
             
        if(response.status == 200) {
          this.current++;
          this.currentRating = null;
            }
          }
        )
    },
    // advance() {
    //   this.show = false;
    //   this.current++;
    //   MovieService.addMovie(this.movies[this.current])
    //   .then(
    //     (response) => {
    //   if(response.status == 200) {
    //     this.current++;
    //         }
    //       }
    //     )
    // },
    advance() {
      // Increment the current index
      this.current++;
      this.currentRating = null;
      // Check if all movies have been cycled through
      if (this.current >= this.movies.length) {
        // Fetch new movies from the backend
        MovieService.getMoviesByPreferences().then((response) => {
          if (response.data.length > 0) {
            // Update the movies array with the new batch of movies
            this.movies = response.data;
            this.current = 0; // Reset the current index
            
          }
        });
      }
      this.show = false;
    },
    // advanceWantWatch() {
    //   // added the below line
    //   this.show = false;
    //   this.movies[this.current].want_to_watch = true;
    //   MovieService.addMovie(this.movies[this.current])
    //   .then(
    //   (response) => {
    //     if(response.status == 200) {
    //       this.current++;
    //         }
    //       }
    //     )
    // },
    advanceWantWatch() {
      this.show = false;
      this.movies[this.current].want_to_watch = true;
      this.currentRating = 0;
      MovieService.addMovie(this.movies[this.current]).then((response) => {
        if (response.status == 200) {
          this.advance();
        }
      });
    },
    updateCurrentRating(newRating) {
      this.currentRating = newRating;
    },
  },
  // created() {
  //   MovieService.getMoviesByPreferences()
  //   .then(
  //       (response) => {
  //         console.log(response.data);
  //         this.current = 0;
  //           this.movies = response.data;
  //       }
  //    );
  //  }
  mounted() {
    // Fetch movies from the backend when the component is mounted
    MovieService.getMoviesByPreferences().then((response) => {
      console.log(response)
      if (response.data.length > 0) {
        this.movies = response.data;
      }
    });
  },
};

</script>

<style scoped>

.card {
    border-radius: 10px;
    max-width: 85vw;
    height: 50%;
    margin: 20px 20px 40px 20px;
    display: flex;
    flex-direction: column;
    text-align: center;
    box-shadow: 0px 0px 20px 2px #F84AA7;
}

.card .movie-title {
    font-size: 2.2rem;
    margin: auto;
    padding-top: 5%;
} 

 .movie-poster{

    border-radius: 10px;
    height: 80%;
    width: 30%;

}  

.button-directive {

  display: flex;
  flex-direction: row; 
  justify-content: center;
  margin: auto;
}

button {
  width: 15em;
  position: relative;
  height: 3.5em;
  border: 3px ridge #F84AA7;
  outline: none;
  background-color: transparent;
  color: white;
  transition: 1s;
  border-radius: 0.3em;
  font-size: 16px;
  font-weight: bold;
  margin-top: 20px;
  margin-left: 20px;
  margin-right: 20px;
  
  
}

button::after {
  content: "";
  position: absolute;
  top: -10px;
  left: 3%;
  width: 95%;
  height: 40%;
  background-color: #1B1B3A;
  transition: 0.5s;
  transform-origin: center;
}

button::before {
  content: "";
  transform-origin: center;
  position: absolute;
  top: 80%;
  left: 3%;
  width: 95%;
  height: 40%;
  background-color: #1B1B3A;
  transition: 0.5s;
}

button:hover::before, button:hover::after {
  transform: scale(0)
}

button:hover {
  box-shadow: inset 0px 0px 25px #1479EA;
}

#seen {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 20px;
}

#decide {
  display: flex;
  justify-content: center;
  
}


.container input {
  position: absolute;
  opacity: 0;
  cursor: pointer;
  height: 0;
  width: 0;
}

.container {
  display: flex;
  justify-content: center;
  cursor: pointer;
  font-size: 20px;
  user-select: none;
  transition: 100ms;
  margin: 20px;
}

.checkmark {
  top: 0;
  left: 0;
  height: 3em;
  width: 3em;
  transition: 100ms;
  animation: dislike_effect 400ms ease;
}

.container input:checked ~ .checkmark path {
  fill: #FF5353;
  stroke-width: 0;
}

.container input:checked ~ .checkmark {
  animation: like_effect 400ms ease;
}

.container:hover {
  transform: scale(1.1);
}

@keyframes like_effect {
  0% {
    transform: scale(0);
  }

  50% {
    transform: scale(1.2);
  }

  100% {
    transform: scale(1);
  }
}

@keyframes dislike_effect {
  0% {
    transform: scale(0);
  }

  50% {
    transform: scale(1.2);
  }

  100% {
    transform: scale(1);
  }
}



.card {
    border-radius: 10px;
    width: 90vw;
    height: 100%;
    margin: 20px;
    display: flex;
    flex-direction: column;
    text-align: center;
    font-family: 'Kodchasan', sans-serif;
    box-shadow: 0px 0px 20px 2px #F84AA7;
    padding: 15px;
}

.card .movie-title {
    font-size: 2.4rem;
    margin: auto;
    padding-top: 5%;
} 

 .movie-poster{

    border-radius: 10px;
    height: 80%;
    width: 30%;

}  

.button-directive {

  display: flex;
  flex-direction: row; 
  justify-content: center;
  align-items: center;

}

button {
  width: 15em;
  position: relative;
  height: 3.5em;
  border: 3px ridge #F84AA7;
  outline: none;
  background-color: transparent;
  color: white;
  transition: 1s;
  border-radius: 0.3em;
  font-size: 16px;
  font-weight: bold;
  margin-top: 30px;
  margin-left: 10px;
  margin-right: 10px;
  margin-bottom: 30px;
  font-family: 'Kodchasan', sans-serif;
  
}

button::after {
  content: "";
  position: absolute;
  top: -10px;
  left: 3%;
  width: 95%;
  height: 40%;
  background-color: #1B1B3A;
  transition: 0.5s;
  transform-origin: center;
}

button::before {
  content: "";
  transform-origin: center;
  position: absolute;
  top: 80%;
  left: 3%;
  width: 95%;
  height: 40%;
  background-color: #1B1B3A;
  transition: 0.5s;
}

button:hover::before, button:hover::after {
  transform: scale(0)
}

button:hover {
  box-shadow: inset 0px 0px 25px #1479EA;
}

#seen {
  display: flex;
  justify-content: center;
  align-items: center;
}

#decide {
  display: flex;
  justify-content: center;
  
}


.container input {
  position: absolute;
  opacity: 0;
  cursor: pointer;
  height: 0;
  width: 0;
}

.container {
  display: flex;
  justify-content: center;
  cursor: pointer;
  font-size: 20px;
  user-select: none;
  transition: 100ms;
  margin: 20px;
}

.checkmark {
  top: 0;
  left: 0;
  height: 3em;
  width: 3em;
  transition: 100ms;
  animation: dislike_effect 400ms ease;
}

.container input:checked ~ .checkmark path {
  fill: #FF5353;
  stroke-width: 0;
}

.container input:checked ~ .checkmark {
  animation: like_effect 400ms ease;
}

.container:hover {
  transform: scale(1.1);
}

@keyframes like_effect {
  0% {
    transform: scale(0);
  }

  50% {
    transform: scale(1.2);
  }

  100% {
    transform: scale(1);
  }
}

@keyframes dislike_effect {
  0% {
    transform: scale(0);
  }

  50% {
    transform: scale(1.2);
  }

  100% {
    transform: scale(1);
  }
}

form {
display: flex;
justify-content: center;
align-items: center;
gap: 20px;
margin: 20px auto;
}

i {
  color: whitesmoke;
}

i.fas.fa-star.fa-2x.checked {
color: whitesmoke;
}

label{
  color: whitesmoke;
}

#rating {
  justify-self: flex-end;
}

#rating-box {
height: 50px;
display: flex;
flex-direction: column;
justify-content: center;
align-items: center;
margin: 20px auto 0 auto;
}

</style>