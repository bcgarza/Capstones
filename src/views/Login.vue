<template>

    <body class="color">

          <div id="login">

            <form @submit.prevent="login">

                <h1>Log In</h1>
            
                <div role="alert" v-if="invalidCredentials">Invalid username and password!</div>
                
                <div role="alert" v-if="this.$route.query.registration">hank you for registering, please sign in.</div>
                    
                <div class="container">
                  
                    <img src=logo.svg height=200 width=200 />

                    <form id="second">
                        <input type="text" name="username" placeholder="Username" v-model="user.username" required autofocus>
                        <input type="password" name="password" placeholder="Password" v-model="user.password" required>
                        <input type="submit" value="Log In">
                    </form>
                
                </div>

                 <p class="container">
                 <router-link id="register" :to="{ name: 'register' }">Need an account? Sign up.</router-link>
                 </p>
            
            </form>

          </div>

    </body>

</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
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