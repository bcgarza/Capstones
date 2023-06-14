<template>

    <section class="carousel">
      <div>
          <movie-card />
      </div>
    </section>

</template>

<script>

import MovieCard from '../components/MovieCard.vue';

export default {
  name: "carousel",
  components: {
    MovieCard
  }
};

</script>

<style>

.carousel {

  display: flex;
  justify-content: center;
  align-items: center;
  margin: auto;
  width: auto;
  height: auto;
}

</style>