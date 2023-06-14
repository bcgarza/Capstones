<template>

  <div>
    <h1 id="movie-title">{{ movie.movie_title }}</h1> 
     <div class="img-box">
      <img class="movie-poster" :src="movie.img_url" />
    </div>

  </div>

</template>

<script>

export default {
    props: {
        movie: Object
    },
    computed: {
    posterUrl() {
      if (this.movie.img_url === "https://image.tmdb.org/t/p/originalnull" || this.movie.img_url === null) {
        return ("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xUuHj3CgmZQ9P2cMaqQs4J0d4Zc.jpg"); 
      } else {
        return this.movie.img_url;
      }
    }
  }
}

</script>

<style scoped>

.img-box {
  height: 450px;
  width: 300px;
  display: flex;
  justify-content: center;
  align-items: center;
  margin: auto;
  overflow: hidden;
  box-shadow: 0px 0px 20px 2px #F84AA7;
  border-radius: 10px;
}

#movie-title {
  color: white;
  font-family: 'Kodchasan', sans-serif;
  font-weight: normal;
  display: flex;
  justify-content: center; 
  align-items: center; 
  font-size: 2.4rem;
  margin: 2% auto;
}

/* .movie-poster {
  max-height: 800px;
  max-width: 300px;
  display: block;
  box-shadow: 0px 0px 20px 2px #F84AA7;
  margin: 10px;
  border-radius: 10px;
} */

.movie-poster {
  height: 100%;
  width: 100%;;
  object-fit: cover;
}

</style>