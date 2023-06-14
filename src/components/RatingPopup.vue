<template>
  <div class="rating-popup">
    <!-- Rating form -->
    <form @submit.prevent="rateProduct" action="">
      <h3>{{ productName }}</h3>
      <!-- Stars container -->
      <div
        v-for="(star, index) in stars"
        :key="index"
        class="stars"
      >
        <!-- Star icon -->
        <i
          v-if="star <= currentRating"
          class="fas fa-star checked"
          @click="updateCurrentRating(index + 1)"
        ></i>
        <!-- Empty star icons -->
        <i
          v-else
          class="far fa-star"
          @click="updateCurrentRating(index + 1)"
        ></i>
      </div>
      <!-- Current rating textbox -->
      <label for="current-rating">Your rating:</label>
      <input type="text" id="current-rating" readonly v-model=" currentRating " />
      <!-- Submit button -->
      <button type="submit">Submit</button>
    </form>
    <!-- Success message -->
    <p v-show="successMessage" class="message success">{{ successMessage }}</p>
    <!-- Error message -->
    <p v-show="errorMessage" class="message error">{{ errorMessage }}</p>
  </div>
</template>
<script>
export default {
  name: "RatingPopup",
  props: ["productID"],
  data() {
    return {
      // Array to store the ratings (out of 5)
      stars: [1, 2, 3, 4, 5],
      // Variable to hold the currently selected rating
      currentRating: null,
      // Flag to indicate if request was successful or not
      successMessage: false,
      errorMessage: false,
    };
  },
  mounted() {
    this.$refs.modal.style.display = "block";
  },
  methods: {
    updateCurrentRating(newRating) {
      this.currentRating = newRating;
    },
    async rateProduct() {
      try {
        const response = await fetch("/api/products/" + this.productID, {
          method: "PUT",
          headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            rating: this.currentRating,
          }),
        });
        if (!response.ok) {
          throw new Error("Network response was not ok");
        } else {
          console.log(`Success! Product ${this.productID} rated successfully.`);
          this.successMessage = `Thank you for your feedback on our products.`;
          setTimeout(() => {
            this.$emit("closeModal");
          }, 2000);
        }
      } catch (error) {
        console.error(`Error while rating product ${this.productID}:`, error);
        this.errorMessage = `${error}`;
      } finally {
        setTimeout(() => {
          this.successMessage = "";
          this.errorMessage = "";
        }, 3000);
      }
    },
  },
};
</script>

<style scoped>

</style>