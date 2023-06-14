<template>

    <body class="color">

          <Header />

          <div id="login">

            <form>

                <h1>Settings</h1>
                    
                <div class="container">
                    
                    <form id="second">
                        <h2>User Info</h2>
                        <div id="username_and_email">
                            <div id="username">
                                <h3>Username</h3>
                                <input type="text" name="username" placeholder="SkittyCameron_99">
                            </div>               
                            <div id="email">
                                <h3>Email</h3>
                                <input type="text" name="email" placeholder="catchemall@gmail.com">
                            </div>
                        </div>
                        <div id="password_and_confirm">          
                            <div id="password">
                                <h3>Password</h3>
                                <input type="password" name="password" placeholder="********">
                            </div>
                            <div id="confirmpassword">
                                <h3>Confirm Password</h3>
                                <input type="password" name="confirmpassword" placeholder="********">
                            </div>
                        </div>
                        <input type="submit" value="Save Changes">
                    </form>

                    <form id="third">
                        <h2>Profile Image</h2>
                        <div id="img-box">
                            <div id="img-circle">
                                  <img id="image" src="https://images.pexels.com/photos/207992/pexels-photo-207992.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" alt="profile-image">
                            </div>
                        </div>

                        <p class="img-edit">
                        <router-link id="change-img" :to="{ name: 'register' }">Edit Image</router-link>
                        </p>
                    </form>
                
                </div>
            
            </form>

          </div>

    </body>

</template>

<script>
import Header from '../components/Header.vue'

export default {
  name: "settings2",
  components: {
    Header
  },
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
};

</script>

<style scoped>

/* .form-input-group {
  margin-bottom: 1rem;
    border: 3px solid yellow;
} */

/* label {
  margin-right: 0.5rem;
} */

body {
    background-color: whitesmoke;
    font-family: Arial, sans-serif;
}


.container {
    display: flex;
    flex-direction: row-reverse;
    justify-content: flex-start;
    align-items: flex-start;
    height: 100%;
    width: 100%;
    margin: auto;
    padding: auto;
    gap: 5%;
}

/* #register {
  color: rgb(212, 205, 205);
  font-family: 'Sulphur Point';
  font-size: 18px;
  text-decoration: none;
}

#register:hover {
  color: whitesmoke;
} */

#second {
    box-shadow:0px 0px 10px 2px #F84AA7;
    padding: 20px 40px 40px 40px;
    margin: 0 auto 0 auto;
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: flex-start;
    border-radius: 10px;
    align-self: flex-start;  
}

#third {
    box-shadow:0px 0px 10px 2px #F84AA7;
    padding: 20px 40px 40px 40px;
    margin: 0 auto 0 auto;
    width: 30%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    border-radius: 10px;  
    align-self: flex-start;
}

input[type="text"], input[type="password"] {
    width: 100%;
    height: 35px;
    padding: auto;
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
    margin: 20px 0 0 0;
}

input[type="submit"]:hover {
    background-color: #ff3562;
    color: whitesmoke;
}

#image{

  width: 100%;
  height: 100%;
  object-fit: cover;

}

.color{
  background-color: #1B1B3A;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  height: 100vh;
  width: auto;
  }

/* .register {
  color: black;
} */

h1 {
  font-size: 2.4rem;
  font-family: 'Kodchasan', sans-serif;;
  font-weight: 100;
  color: whitesmoke;
  text-align: center;
  margin-top: 5%;
  margin-bottom: 5%;
}

h2 {
  font-size: 2.0rem;
  font-family: 'Kodchasan', sans-serif;;
  font-weight: 100;
  color: whitesmoke;
  text-align: center;
}

h3 {
  font-size: 1.0rem;
  font-family: 'Kodchasan', sans-serif;;
  font-weight: 100;
  color: whitesmoke;
  text-align: center;
  margin-top: auto;
  padding-bottom: 0;
}

#username_and_email, #password_and_confirm{
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  gap: 5%;
  width: 100%;
}

#username, #email, #password, #confirmpassword {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: flex-start;
  width: 100%;
  min-height: 120px;
}

#username > input, #email > input, #password > input, #confirmpassword > input {

width: 98%;
min-width: 130px;

}

#login {
width: 85vw;
}

#img-box {
height: auto;
width: auto;
display: flex;
flex-direction: column;
justify-content: center;
align-items: center;
}

#img-circle {

  width: 200px;
  height: 200px;
  border-radius: 50%;
  border: 5px solid whitesmoke;
  overflow: hidden;
}

.img-edit {
  color: rgb(212, 205, 205);
  font-family: 'Sulphur Point';
  font-size: 18px;
  text-decoration: none;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin: 12%;
}

#change-img {
  color: rgb(212, 205, 205);
  font-family: 'Sulphur Point';
  font-size: 18px;
  text-decoration: none;
  text-align: center;
  margin: auto;
}

#change-img:hover {
  color: whitesmoke;
}

</style>