<template>

  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'login' }" class="nav-link">Login</router-link>&nbsp;
      <router-link v-bind:to="{ name: 'home' }" class="nav-link">Home</router-link>&nbsp;
      <router-link v-bind:to="{ name: 'profile' }" class="nav-link">Profile</router-link>&nbsp;
      <router-link v-bind:to="{ name: 'settings2' }" class="nav-link">Settings</router-link>&nbsp;
      
      <!-- <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp; -->
    </div>
    <router-view />
  </div>
  
</template>

<style scoped>

#app{
  background-color: #1B1B3A;
  justify-content: center;
  height: 100vh;
  width: auto;
}

.nav-link {
  color: #1B1B3A;
  text-decoration: none;
  transition: color 0.3s;
}

.nav-link:hover {
  color: #999999;
}

@import url('https://fonts.googleapis.com/css2?family=Antonio&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Julius+Sans+One&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Sulphur+Point&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Kodchasan&display=swap');

</style>
