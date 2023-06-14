<template>

  <div class="home">
    <Header />
    <div>
      <carousel/>
    </div>
  </div>

</template>


<script>

import Carousel from '../components/Carousel.vue';
import Header from '../components/Header.vue';
// import DashboardTest from '../components/DashboardTest.vue';

export default {
  name: 'home',
  components: {
    Header,
    Carousel,
 },

};

</script>


<style>

.home{
  background-color: #1B1B3A;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  max-height: auto;
  width: 100%;
}

</style>
