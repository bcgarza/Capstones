<template>
  <div class="star">
    <!-- Rating form -->
    <form @submit.prevent="" action="">
      
      <!-- Stars container -->
      <div
        v-for="(star, index) in stars"
        :key="index"
        class="stars"
      >
        <!-- Star icon -->
        <i
          v-if="star <= currentRating"
          class="fas fa-star fa-2x checked"
          @click="updateCurrentRating(index)"
        ></i>
        <!-- Empty star icons -->
        <i
          v-else
          class="far fa-star fa-2x"
          @click="updateCurrentRating(index + 1)"
        ></i>
      </div>
       <!-- Current rating textbox -->
      <!-- <label for="current-rating">Your rating:</label>
      <input type="text" id="current-rating" readonly v-model=" currentRating " /> -->
    </form>
    
  </div>
</template>
<script>
export default {
  name: "star",
  data() {
    return {
      // Array to store the ratings (out of 5)
      stars: [1, 2, 3, 4, 5],
      // Variable to hold the currently selected rating
      currentRating: 0,

    };
  },
  mounted() {
    // this.$refs.modal.style.display = "block";
  },
  methods: {
    updateCurrentRating(newRating) {
      this.currentRating = newRating;
    },
  },
};
</script>

<style scoped>

form{
display: flex;
justify-content: center;
}

i{
  color: whitesmoke;

}


i.fas.fa-star.fa-2x.checked{
color: whitesmoke;
}
label{
  color: whitesmoke;
}
</style>
 


// ★