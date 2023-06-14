<template>
  
  <div class="selectors">

      <div>
      <label for="action">Action</label>
      <input type="checkbox" name="action" id="action" v-model="isActionChecked"/>
      </div>

      <div>
      <label for="adventure">Adventure</label>
      <input type="checkbox" name="adventure" id="adventure" v-model="isAdventureChecked"/>
      </div>

      <div>
      <label for="comedy">Comedy</label>
      <input type="checkbox" name="comedy" id="comedy" v-model="isComedyChecked"/>
      </div>

      <div>
      <label for="drama">Drama</label>
      <input type="checkbox" name="drama" id="drama" v-model="isDramaChecked"/>
      </div>

      <div>
      <label for="family">Family</label>
      <input type="checkbox" name="family" id="family" v-model="isFamilyChecked"/>
      </div>

      <div>
      <label for="horror">Horror</label>
      <input type="checkbox" name="horror" id="horror" v-model="isHorrorChecked"/>
      </div>

      <div>
      <label for="romance">Romance</label>
      <input type="checkbox" name="romance" id="romance" v-model="isRomanceChecked"/>
      </div>

      <div>
      <label for="sci-fi">Sci-Fi</label>
      <input type="checkbox" name="sci-fi" id="sci-fi" v-model="isScifiChecked"/>
      </div>

      <div>
      <label for="thriller">Thriller</label>
      <input type="checkbox" name="thriller" id="thriller" v-model="isThrillerChecked"/>
      </div>

  </div>

</template>

<script>
export default {
    name: "preferences-selectors",
    props: {
      genrePreferences: Object,
    },
    computed: {
      isActionChecked: {
        get() {
          return this.genrePreferences.wants_action;
        },
        set(value) {
          this.$emit("update:genrePreferences", {
            ...this.genrePreferences,
            wants_action: value
          });
        }
      },
      isAdventureChecked: {
        get() {
          return this.genrePreferences.wants_adventure;
        },
        set(value) {
          this.$emit("update:genrePreferences", {
            ...this.genrePreferences,
            wants_adventure: value
          });
        }
      },
      isComedyChecked: {
        get() {
          return this.genrePreferences.wants_comedy;
        },
        set(value) {
          this.$emit("update:genrePreferences", {
            ...this.genrePreferences,
            wants_comedy: value
          });
        }
      },
      isDramaChecked: {
        get() {
          return this.genrePreferences.wants_drama;
        },
        set(value) {
          this.$emit("update:genrePreferences", {
            ...this.genrePreferences,
            wants_drama: value
          });
        }
      },
      isFamilyChecked: {
        get() {
          return this.genrePreferences.wants_family;
        },
        set(value) {
          this.$emit("update:genrePreferences", {
            ...this.genrePreferences,
            wants_family: value
          });
        }
      },
      isHorrorChecked: {
        get() {
          return this.genrePreferences.wants_horror;
        },
        set(value) {
          this.$emit("update:genrePreferences", {
            ...this.genrePreferences,
            wants_horror: value
          });
        }
      },
      isRomanceChecked: {
        get() {
          return this.genrePreferences.wants_romance;
        },
        set(value) {
          this.$emit("update:genrePreferences", {
            ...this.genrePreferences,
            wants_romance: value
          });
        }
      },
      isScifiChecked: {
        get() {
          return this.genrePreferences.wants_scifi;
        },
        set(value) {
          this.$emit("update:genrePreferences", {
            ...this.genrePreferences,
            wants_scifi: value
          });
        }
      },
      isThrillerChecked: {
        get() {
          return this.genrePreferences.wants_thriller;
        },
        set(value) {
          this.$emit("update:genrePreferences", {
            ...this.genrePreferences,
            wants_thriller: value
          });
        }
      }
    }
};

</script>

<style>

.selectors{

  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  width: 75%;
  font-family: 'Kodchasan', sans-serif;
  font-size: 1.5rem;
  color: whitesmoke;
  gap: 80px;
  margin: 5% auto;
  height: 40%;
}

.selectors > div {

  display: flex;
  align-items: center;
  justify-content: flex-end; /* Changed from "right" to "flex-end" */
  gap: 20px;
  margin: auto;
  width: 190px;
}

input[type="checkbox"] {

  appearance: none;
  margin: 0;
  font: inherit;
  color: currentColor;
  width: 1.15em;
  height: 1.15em;
  border: 0.10em solid currentColor;
  border-radius: 0.3em;
  transform: translateY(-0.075em);

  display: grid;
  place-content: center;

  position: relative;

}

input[type="checkbox"]::before {
  content: "";
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%); 
  width: 0.6em; 
  height: 0.6em; 
  background-color: whitesmoke; 
  border-radius: 0.1em; 
  display: none; 
}

input[type="checkbox"]:checked::before {
  display: block; 
}

</style>