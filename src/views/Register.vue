<template>

    <body class="color">

          <div id="register">

            <form @submit.prevent="register">

                <h1>Sign Up</h1>

                <div role="alert" v-if="registrationErrors">
                    {{ registrationErrorMsg }}
                </div> 

                <div class="container">
                  
                    <img src=logo.svg height=200 width=200 />

                    <form id="second">
                        <input type="text" name="username" placeholder="Create Username" v-model="user.username" required autofocus>
                        <input type="password" name="password" placeholder="Create Password" v-model="user.password" required>
                        <input type="password" name="confirm-password" placeholder="Confirm Password" v-model="user.confirmPassword" required>
                        <input type="submit" value="Submit">
                    </form>
                
                </div>

                 <p class="container">
                 <router-link id="register" :to="{ name: 'login' }">Go back to Log In</router-link>
                 </p>
            
            </form>

          </div>

    </body>

</template>

<script>

import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};

</script>

<style scoped>

.form-input-group {
  margin-bottom: 1rem;
}

label {
  margin-right: 0.5rem;
}

body {
    background-color: #fafafa;
    font-family: Arial, sans-serif;
}


.container {
    margin-top: 50px;
    display: flex;
    flex-direction: column;
    align-items: center;
}

#register {
  color: rgb(212, 205, 205);
  font-family: 'Sulphur Point';
  font-size: 18px;
  text-decoration: none;
}

#register:hover {
  color: whitesmoke;
}

#second {
    box-shadow:0px 0px 10px 2px #F84AA7;
    padding: 20px;
    width: 300px;
    display: flex;
    flex-direction: column;
    align-items: center;
    border-radius: 10px;  
}

input[type="text"], input[type="password"] {
    width: 95%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #dbdbdb;
    border-radius: 3px;
    font-size: 14px;
}

input[type="submit"] {
    background-color: #d83256;
    color: whitesmoke;
    border: none;
    padding: 10px 20px;
    border-radius: 10px;
    font-size: 14px;
    font-family: 'Kodchasan';
    font-weight: 600;
    cursor: pointer;
    margin: 10px;
}

input[type="submit"]:hover {
    background-color: #ff3562;
    color: white;
}

#image{
    max-width: 150px;
    height: auto;
    margin-left: auto;
    margin-right: auto;
}

.color{
  background-color: #1B1B3A;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  align-content: center;
  height: 100vh;
}

.register {
  color: black;
}

h1 {
  font-size: 2.4rem;
  font-family: 'Kodchasan', sans-serif;;
  font-weight: 100;
  color: whitesmoke;
  text-align: center;
  margin-top: 5%;
}

</style>
