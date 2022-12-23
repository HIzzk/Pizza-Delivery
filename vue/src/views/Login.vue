
<template>
  <div class="content">
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal" align="center">Please Sign In</h1>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >
        Thank you for registering, please sign in.
      </div>
      <label for="username" class="sr-only" align="center">Username:</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password:</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      <button type="submit">Sign in</button>
    </form>
  </div>
  </div>
</template>

<style scoped>
.content {
  margin-top: 20px;
  display: flex;
  justify-content: center;
}

#login {

  font-size: 14px;
  background-color: #f3ebf6;
  font-family: "Ubuntu", sans-serif;
  border-radius: 10px;
  width: 35%;
}


button {
  
  align-content: space-around;
  
  width: 50%;
  cursor: pointer;
  border-radius: 5em;
  color: #fff;
  background: linear-gradient(to right, #27b055, #064d15);
  border: 0;
  padding-left: 40px;
  padding-right: 40px;
  padding-bottom: 10px;
  padding-top: 10px;
  font-family: "Ubuntu", sans-serif;
  font-size: 13px;
  box-shadow: 0 0 20px 1px rgba(0, 0, 0, 0.04);
  align-items: center;
  align-self: center;
  margin-top: 10px;
  margin-bottom: 24px;
}

.form-signin {
  display: flex;
  flex-direction: column; 
  justify-content: space-between;
  align-items: center;
  align-self: center;
}

.form-signin input {
  width: 50%;
  display: flex;
  margin-top: 6px;
  margin-bottom: 10px;
  padding: 4px;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  align-self: center;
}

/* .sr-only {
  display: flex;
  justify-content: center;
} */
</style>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>
