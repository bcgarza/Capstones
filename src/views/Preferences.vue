<template>

  <div class="preferences">
    <Header />
    
    <h1>Genres</h1>
    
    <div class="selector-box">
      <preferences-selectors :genre-preferences.sync="genrePreferences"/>
      <button id="Save" type="button" @click="savePreferences">Save</button>
    </div>

  </div>
  
</template>

<script>
import UserService from '../services/UserService.js'
import Header from '../components/Header.vue'
import PreferencesSelectors from '../components/PreferencesSelectors.vue'

export default {
  name: 'preferences',
  components: { 
    Header,
    PreferencesSelectors 
  },
  data() {
    return {
      genrePreferences: {},
    }
  },
  created() {
    UserService.getUserPreferences(1)
    .then(
      (response) => {
        console.log(response.data);
        this.genrePreferences = response.data;
      }
    )
  },
  methods: {

  savePreferences() {

    const requestBody = {
    user_id: 1,
    wants_action: this.genrePreferences.wants_action || false,
    wants_adventure: this.genrePreferences.wants_adventure || false,
    wants_comedy: this.genrePreferences.wants_comedy || false,
    wants_drama: this.genrePreferences.wants_drama || false,
    wants_horror: this.genrePreferences.wants_horror || false,
    wants_romance: this.genrePreferences.wants_romance || false,
    wants_scifi: this.genrePreferences.wants_scifi || false,
    wants_thriller: this.genrePreferences.wants_thriller || false,
    wants_family: this.genrePreferences.wants_family || false
  };

        UserService.updatePreferences(requestBody)
        .then((response) => {
          console.log(response.data);
        });
      }
  },
  
};

</script>

<style scoped>

h1 {
  font-size: 2.4rem;
  font-family: 'Kodchasan', sans-serif;;
  font-weight: 100;
  color: whitesmoke;
  text-align: center;
  margin-top: 5%;
}

.preferences {

background-color: #1B1B3A;
display: flex;
flex-direction: column;
justify-content: center;
align-items: center;
margin: auto;
}

.selector-box {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100%;
  width: 100%;
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

</style>