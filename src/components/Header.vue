<template>
  
  <div id="header">

      <header>
<!-- v-bind:to="{ name: 'home', params: {movieGenre: 'action' }  -->
          <router-link id='two' v-bind:to="{ name: 'home' }">
              <img id="home_logo" src=logo.svg />
          </router-link>
 
          <nav id="links" v-if="showMenu">
            <!-- <router-link id='two' v-bind:to="{ name: 'home' }">Home</router-link> -->
            <router-link id='three' v-bind:to="{ name: 'profile' }">My Movies</router-link>
            <router-link id='one' v-bind:to="{ name: 'preferences' }">Genres</router-link>
            <router-link id='one' v-bind:to="{ name: 'settings2' }">Settings</router-link>
          </nav>

          <div>
              <input type="checkbox" id="checkbox" @click="showMenu =!showMenu" :class="{ 'open': showMenu }">
              <label for="checkbox" class="toggle">
                <div class="bar bar--top"></div>
                <div class="bar bar--middle"></div>
                <div class="bar bar--bottom"></div>
              </label>
          </div>

      </header>

  </div>

</template>

<script>

export default {
  data() {
    return {
      logo: 'logo',
      showMenu: false // Controls whether or not the navigation is visible
    };
  },
  methods: {
    doClickity() {
      alert('Greetings Human!');
    },
    returnHome() {
      this.$router.push({name: 'home'});
    },
  },
};

</script>

<style scoped>

  button {
    background: none;
    border: solid 1px;
    border-radius: 2em;
    font: inherit;
    padding: 0.75em 2em;
  }

  #one:hover {
  font-weight: bolder;
  text-shadow: -3px 0px 50px rgb(245, 245, 245, .2);
}

  #two:hover {
  font-weight: bolder;
  text-shadow: -3px 0px 50px rgb(245, 245, 245, .2);
}

  #three:hover {
  font-weight: bolder;
  text-shadow: -3px 0px 50px rgb(245, 245, 245, .2);
}


  header{
    display: flex;
    justify-content:space-between;
    align-items: center;
    box-shadow:0px 0px 10px 2px #F84AA7;
    padding: 15px;
    width: 85vw;
    margin-left: auto;
    margin-right: auto;
    border-radius: 10px;
  }
  
  #Logo {
      max-width: 80px;
      height: auto;
      margin-left: 20px;
  }

  #links {
      display: flex;
      justify-content:space-evenly;
      flex-basis: 75%;
      font-size: larger;    
  }

  #one, #two, #three {
      color: whitesmoke;
      text-decoration: none;
      font-family: 'Kodchasan', sans-serif;
  }


 /* Below is for the hamburger menu */
 #checkbox {
  display: none;
}

.toggle {
  position: relative;
  width: 30px;
  cursor: pointer;
  display: block;
  padding: 15px;
  margin-right: 20px;
}

.toggle:hover {
    filter: drop-shadow( 0px 0px 3px rgb(245,245,245, 0.7));
}

.bar {
  position: absolute;
  left: 0;
  right: 0;
  height: 4px;
  border-radius: calc(4px / 2);
  background: #F84AA7;
  color: inherit;
  opacity: 1;
  transition: none 0.35s cubic-bezier(.5,-0.35,.35,1.5) 0s;
}

/***** Spin Animation *****/

.bar--top {
  bottom: calc(50% + 11px + 4px/ 2);
  transition-property: bottom,transform;
  transition-delay: calc(0s + 0.35s),0s;
}

.bar--middle {
  top: calc(50% - 4px/ 2);
  transition-property: opacity;
  transition-delay: calc(0s + 0.35s);
}

.bar--bottom {
  top: calc(50% + 11px + 4px/ 2);
  transition-property: top,transform;
  transition-delay: calc(0s + 0.35s),0s;
}

#checkbox:checked + .toggle .bar--top {
  bottom: calc(50% - 4px/ 2);
  transform: rotate(135deg);
  transition-delay: 0s,calc(0s + 0.35s);
}

#checkbox:checked + .toggle .bar--middle {
  opacity: 0;
  transition-duration: 0s;
  transition-delay: calc(0s + 0.35s);
}

#checkbox:checked + .toggle .bar--bottom {
  top: calc(50% - 4px/ 2);
  transform: rotate(225deg);
  transition-delay: 0s,calc(0s + 0.35s);
}

#home_logo:hover {
  filter: drop-shadow( 0px 0px 5px rgb(245,245,245, 0.5));
}

</style>