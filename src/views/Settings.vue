<template>

  <div class="settings-container">
        <Header />

        <h1 class="scheme" >Settings</h1>
        <div class="form-container">
          <h2 class="scheme">Change Password</h2>
          <form @submit.prevent="changePassword">
            <input type="password" v-model="password" placeholder="New Password" required>
            <input type="password" v-model="confirmPassword" placeholder="Confirm Password" required>
            <button class="button" type="submit">Change Password</button>
          </form>
        </div>
        <div class="form-container">
          <h2 class="scheme">Change Username</h2>
          <form @submit.prevent="changeUsername">
            <input type="text" v-model="username" placeholder="New Username" required>
            <button class="button" type="submit">Change Username</button>
          </form>
        </div>
        <div class="form-container">
          <h2 class="scheme">Change Profile Picture</h2>
          <form @submit.prevent="changeProfilePicture">
            <input type="file" accept="image/*" @change="handleFileChange" required>
            <button class="button" type="submit">Change Profile Picture</button>
          </form>
        </div>

  </div>

</template>

<script>
import Header from '../components/Header.vue'

export default {
  name: 'settings',
  components: {
    Header
  }

}

</script>

<style scoped>

.settings-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
}

.form-container {
  margin: 20px 0;
}

h1 {
  font-size: 24px;
  margin-bottom: 20px;
}

h2 {
  font-size: 18px;
  margin-bottom: 10px;
}

input {
  margin-bottom: 10px;
  padding: 5px;
}

button {
  padding: 8px 16px;
}
button {
 position: relative;
 display: flex;
 justify-content: center;
 align-items: center;
 border-radius: 5px;
 background: #f84aa7;
 font-family: "Montserrat", sans-serif;
 box-shadow: 0px 6px 24px 0px rgba(0, 0, 0, 0.2);
 overflow: hidden;
 border: none;
}

button:after {
 content: " ";
 width: 0%;
 height: 100%;
 background: #FFD401;
 position: absolute;
 transition: all 0.4s ease-in-out;
 right: 0;
}

button:hover::after {
 right: auto;
 left: 0;
 width: 100%;
}

button span {
 text-align: center;
 text-decoration: none;
 width: 100%;
 padding: 18px 25px;
 color: #fff;
 font-size: 1.125em;
 font-weight: 700;
 letter-spacing: 0.3em;
 z-index: 20;
 transition: all 0.3s ease-in-out;
}

button:hover span {
 color: #183153;
 animation: scaleUp 0.3s ease-in-out;
}

@keyframes scaleUp {
 0% {
  transform: scale(1);
 }

 50% {
  transform: scale(0.95);
 }

 100% {
  transform: scale(1);
 }
}
.scheme{
    font-family: 'Kodchasan', sans-serif;
color:#ff3568;
}
h1,h2{
     font-family: 'Kodchasan', sans-serif;
    color: #ff3568;
}

</style>