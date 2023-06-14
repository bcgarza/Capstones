import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import Profile from '@/views/Profile.vue'
import Preferences from '../views/Preferences.vue'
import store from '../store/index.js';
import Settings from '../views/Settings.vue'
import Settings2 from '../views/Settings2.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      redirect: '/home'
    },
    {
      path: '/home', // switched to this, prev was the one below. now it automatically takes you here when app starts up
      name: 'home',
      component: Home,
      meta: {
         requiresAuth: false
      }
    },
    // {
    //   path: '/genre/',
    //   name: 'home',
    //   component: Home,
    //   meta: {
    //     requiresAuth: false //needs to be reset to true at the finish of this project
    //   }
    // },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    //added this path for profile page
    {
      path: "/profile",
      name: "profile",
      component: Profile,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/preferences",
      name: "preferences",
      component: Preferences,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/settings",
      name: "settings",
      component: Settings,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/settings2",
      name: "settings2",
      component: Settings2,
      meta: {
        requiresAuth: false
      }
    }
  ]
})

// Commented out the default Authenication in order to bypass the login requirement

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
