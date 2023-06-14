<template>

  <div class="carousel-container">

    <h2>Want To Watch</h2>

    <div class="carousel-and-buttons">

        <img id="left-caret" src=caret-left.svg class="prev-btn" @click="prevImage(2)"/>
        
        <div class="carousel">
            
            <div class="images" v-for="movie in wantToWatchMovies" :key="movie.movie_id">
                <h3 class="movie-title">{{ movie.movie_title }}</h3>
                <div class="img-box">
                    <img class="poster" :src="getMoviePoster(movie.img_url)" :alt="movie.movie_title" />
                    <!-- <img class="poster" :src="movie.img_url" :alt="movie.movie_title" /> -->
                </div>
            </div>
            
        </div>
        
        <img id="right-caret" src=caret-right.svg class="next-btn" @click="nextImage(2)"/>
    
    </div>

    <h2>Previously Watched</h2>

    <div class="carousel-and-buttons">

      <img id="left-caret2" src=caret-left.svg class="w2w-prev-btn" @click="prevImage(1)"/>
        
      <div class="carousel">
          
          <div class="images" v-for="movie in watchedMovies" :key="movie.movie_id">
            <h3 class="movie-title">{{ movie.movie_title }}</h3>
              <div class="img-box">
                <img class="poster" :src="getMoviePoster(movie.img_url)" :alt="movie.movie_title" />
                <!-- <img class="poster" :src="movie.img_url" :alt="movie.movie_title" /> -->
                   <div class="star-display">
                      <span v-for="n in movie.movie_rating" :key="n">★</span>
                    </div>
                    <div class="avg-rating">
                      <span id="avg">Avg :</span>
                      <span v-for="n in getRandomRating()" :key="n">★</span>
                    </div>
              </div>
          </div>
      </div>
    <img id="right-caret2" src=caret-right.svg class="w2w-next-btn" @click="nextImage(1)"/>
    
  </div>

</div>

</template>

<script>

import MovieService from '../services/MovieService';

export default {
  components:{
    
  },
    data() {
    return {
      watchedMovies: [],
      wantToWatchMovies: [],
      backupPosterUrl: "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xUuHj3CgmZQ9P2cMaqQs4J0d4Zc.jpg"
    };
  },

  created() {
    this.fetchWatchedMovies(); 
    this.fetchWantToWatchMovies();
    this.fetchRatings();
  },
  
  methods: {
     getRandomRating() {
    return Math.floor(Math.random() * 5) + 1;
  },
     fetchWatchedMovies(){
        MovieService.getWatchedMovies()
        .then(response => {
            if(response.status == 200){
                this.watchedMovies = response.data;
            }
        })
      },

     fetchWantToWatchMovies() {
        MovieService.getWantToWatchMovies()
        .then(response => {
            if(response.status == 200){
            this.wantToWatchMovies = response.data;
            }
        })
     },

    prevImage(carouselNumber) {
        if (carouselNumber === 1) {
            this.watchedMovies.unshift(this.watchedMovies.pop());
        } else if (carouselNumber === 2) {
            this.wantToWatchMovies.unshift(this.wantToWatchMovies.pop());
        }
    },
    nextImage(carouselNumber) {
      if (carouselNumber === 1) {
        this.watchedMovies.push(this.watchedMovies.shift());
      } else if (carouselNumber === 2) {
        this.wantToWatchMovies.push(this.wantToWatchMovies.shift());
      }
    },
    getMoviePoster(imgUrl) {
      if (imgUrl && imgUrl !== "https://image.tmdb.org/t/p/originalnull") {
        return imgUrl;
      } else {
        return this.backupPosterUrl;
      }
    }
  }
};
</script>

<style scoped>

.avg-rating{
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
  gap: 5px;
  color: grey;
  width: 90%;
  margin: 0 auto;
}

#avg {
  font-size: 1.0rem;
  font-family: 'Kodchasan', sans-serif;;
  font-weight: 100;
  color: whitesmoke;
  text-align: center;
}

.star-display{
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  gap: 5px;
  padding: 1rem;
  color:  whitesmoke;
}
span{
  font-size: 24px;
}
.carousel-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  margin: auto;
  padding: 0;
  text-align: center;
}

.carousel-and-buttons {
  width: 70%;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  gap: 20px;
}

.carousel {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
  overflow: hidden; 
  margin: auto;
  height: 100%;
  width: 100%; 
  gap: 60px;
}

.images {
  display: flex;
  width: auto;
  min-height: 400px;
  margin: 0;
  padding: 0;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  text-align: center;
}

@keyframes carousel-scroll {
  0% {
    transform: translateX(0);
  }
  100% {
    transform: translateX(-100%); 
  }
}

.img-box {
  padding: 10px;
  margin: 10px;
  
}

.img-box img {
  max-height: 300px;
  max-width: 300px;
  display: block;
  box-shadow: 0px 0px 15px 2px #F84AA7;
  border-radius: 10px;
}

.prev-btn,
.next-btn {
  padding: 5px 10px;
}

h2 {

  font-size: 2.4rem;
  font-family: 'Kodchasan', sans-serif;;
  font-weight: 100;
  color: whitesmoke;
  text-align: center;
  margin-top: 5%;

}

.movie-title {

  color: whitesmoke;
  font-family: 'Kodchasan', sans-serif;
  font-weight: normal;
  display: flex;
  justify-content: center; 
  align-items: center; 
  font-size: 1.2rem;
  margin: 2% auto;

}

#left-caret:hover, #right-caret:hover {
filter: drop-shadow( 0px 0px 9px rgb(245,245,245, 0.9));
}

#left-care2:hover, #right-caret2:hover {
filter: drop-shadow( 0px 0px 9px rgb(245,245,245, 0.9));
}

#left-caret2, #right-caret2 {

  margin-bottom: 80px;

}

@media screen and (max-width: 450px){
.prev-btn[data-v-0293a3a9][data-v-0293a3a9], .next-btn[data-v-0293a3a9][data-v-0293a3a9] {
    padding: .5rem;
}
  .carousel-and-buttons[data-v-0293a3a9] {
    width: 100%;
  }
}

@media screen and (min-width: 451px) and (max-width: 767px) {
    .carousel-and-buttons[data-v-0293a3a9] {
    width: 100%;
    
}
.prev-btn[data-v-0293a3a9], .next-btn[data-v-0293a3a9] {
    padding: 1rem 2rem;
}

}

</style>
