<template>

  <section class="button-directive">

    <div >

      <div id="seen">
        <button type="button" onclick="alert('You pressed the seen button!')">Saw it Already</button>
      </div>

      <div id="decide">
        <button id="nah" type="button" onclick="alert('You pressed the nah button!')">Don't want to Watch</button>
        <button id="want" type="button" onclick="alert('You pressed the want button!')">Add to Watchlist</button>
      </div>
                             
      <!-- <label class="container">
        <input checked="checked" type="checkbox">
        <div class="checkmark">
          <svg viewBox="0 0 256 256">
          <rect fill="none" height="256" width="256"></rect>
          <path d="M224.6,51.9a59.5,59.5,0,0,0-43-19.9,60.5,60.5,0,0,0-44,17.6L128,59.1l-7.5-7.4C97.2,28.3,59.2,26.3,35.9,47.4a59.9,59.9,0,0,0-2.3,87l83.1,83.1a15.9,15.9,0,0,0,22.6,0l81-81C243.7,113.2,245.6,75.2,224.6,51.9Z" stroke-width="20px" stroke="#FFF" fill="none"></path></svg>
        </div>
      </label> -->

    </div>

  </section>
    
</template>

<script>

export default {
    name: "dashboard"
}

</script>

<style scoped>

/* .button-directive{
  justify-content: space-evenly;
  display: flex;
  font-family: Arial, Helvetica, sans-serif;
  flex-basis: 50%;
} */

/* #nah, #seen, #want {
    border-radius: 40%;
    font-weight: 600;
    padding: .5rem;
    font-size: 1rem;
    background: #80808078;
    width: 8rem;
    height: 5rem;
    margin: .75rem;

  
  
  
  position: relative;
  font-family: inherit;
  font-weight: 500;
  font-size: 18px;
  letter-spacing: 0.05em;
  border-radius: 0.8em;
  border: none;
  background: linear-gradient(to right, #693668, #FF3562);
  color: ghostwhite;
  overflow: hidden;
}

.cssbuttons-io svg {
  width: 1.2em;
  height: 1.2em;
  margin-right: 0.5em;
}

.cssbuttons-io span {
  position: relative;
  z-index: 10;
  transition: color 0.4s;
  display: inline-flex;
  align-items: center;
  padding: 0.8em 1.2em 0.8em 1.05em;
}

.cssbuttons-io::before,
.cssbuttons-io::after {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 0;
}

.cssbuttons-io::before {
  content: "";
  background: #000;
  width: 120%;
  left: -10%;
  transform: skew(30deg);
  transition: transform 0.4s cubic-bezier(0.3, 1, 0.8, 1);
}

.cssbuttons-io:hover::before {
  transform: translate3d(100%, 0, 0);
}

.cssbuttons-io:active {
  transform: scale(0.95);
} */


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

#seen {
  display: flex;
  justify-content: center;
  margin: 20px;
}

#decide {
  display: flex;
  justify-content: center;
  
}


.container input {
  position: absolute;
  opacity: 0;
  cursor: pointer;
  height: 0;
  width: 0;
}

.container {
  display: flex;
  justify-content: center;
  cursor: pointer;
  font-size: 20px;
  user-select: none;
  transition: 100ms;
  margin: 20px;
}

.checkmark {
  top: 0;
  left: 0;
  height: 3em;
  width: 3em;
  transition: 100ms;
  animation: dislike_effect 400ms ease;
}

.container input:checked ~ .checkmark path {
  fill: #FF5353;
  stroke-width: 0;
}

.container input:checked ~ .checkmark {
  animation: like_effect 400ms ease;
}

.container:hover {
  transform: scale(1.1);
}

@keyframes like_effect {
  0% {
    transform: scale(0);
  }

  50% {
    transform: scale(1.2);
  }

  100% {
    transform: scale(1);
  }
}

@keyframes dislike_effect {
  0% {
    transform: scale(0);
  }

  50% {
    transform: scale(1.2);
  }

  100% {
    transform: scale(1);
  }
}


/* border-radius: 40%;
    font-weight: 600;
    padding: .5rem;
    font-size: 1rem;
    background: #80808078;
    width: 8rem;
    height: 5rem;
    margin: .75rem; */


</style>