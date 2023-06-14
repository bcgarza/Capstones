package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {

   @JsonProperty("user_id")
   private int id;

   private String username;

   @JsonIgnore
   private String password;

   @JsonIgnore
   private boolean activated;

   private Set<Authority> authorities = new HashSet<>();

   //genre variables
   @JsonProperty("wants_action")
   private boolean wantsAction;

   @JsonProperty("wants_adventure")
   private boolean wantsAdventure;

   @JsonProperty("wants_comedy")
   private boolean wantsComedy;

   @JsonProperty("wants_drama")
   private boolean wantsDrama;

   @JsonProperty("wants_horror")
   private boolean wantsHorror;

   @JsonProperty("wants_romance")
   private boolean wantsRomance;

   @JsonProperty("wants_scifi")
   private boolean wantsScifi;

   @JsonProperty("wants_thriller")
   private boolean wantsThriller;

   @JsonProperty("wants_family")
   private boolean wantsFamily;


   public User() { }

   public User(int id, String username, String password, String authorities) {
      this.id = id;
      this.username = username;
      this.password = password;
      if(authorities != null) this.setAuthorities(authorities);
      this.activated = true;
   }

   public User(int id, boolean wantsAction, boolean wantsAdventure, boolean wantsComedy,
               boolean wantsDrama, boolean wantsHorror, boolean wantsRomance, boolean wantsScifi,
               boolean wantsThriller, boolean wantsFamily) {
      this.id = id;
      this.wantsAction = wantsAction;
      this.wantsAdventure = wantsAdventure;
      this.wantsComedy = wantsComedy;
      this.wantsDrama = wantsDrama;
      this.wantsHorror = wantsHorror;
      this.wantsRomance = wantsRomance;
      this.wantsScifi = wantsScifi;
      this.wantsThriller = wantsThriller;
      this.wantsFamily = wantsFamily;
   }

   public User(int id, String username, String password, boolean activated, Set<Authority>
               authorities, boolean wantsAction, boolean wantsAdventure, boolean wantsComedy,
               boolean wantsDrama, boolean wantsHorror, boolean wantsRomance, boolean wantsScifi,
               boolean wantsThriller, boolean wantsFamily) {
      this.id = id;
      this.username = username;
      this.password = password;
      this.activated = activated;
      this.authorities = authorities;
      this.wantsAction = wantsAction;
      this.wantsAdventure = wantsAdventure;
      this.wantsComedy = wantsComedy;
      this.wantsDrama = wantsDrama;
      this.wantsHorror = wantsHorror;
      this.wantsRomance = wantsRomance;
      this.wantsScifi = wantsScifi;
      this.wantsThriller = wantsThriller;
      this.wantsFamily = wantsFamily;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public boolean isActivated() {
      return activated;
   }

   public void setActivated(boolean activated) {
      this.activated = activated;
   }

   public Set<Authority> getAuthorities() {
      return authorities;
   }

   public void setAuthorities(Set<Authority> authorities) {
      this.authorities = authorities;
   }

   public void setAuthorities(String authorities) {
      String[] roles = authorities.split(",");
      for(String role : roles) {
         String authority = role.contains("ROLE_") ? role : "ROLE_" + role;
         this.authorities.add(new Authority(authority));
      }
   }

   public boolean isWantsAction() {
      return wantsAction;
   }

   public void setWantsAction(boolean wantsAction) {
      this.wantsAction = wantsAction;
   }

   public boolean isWantsAdventure() {
      return wantsAdventure;
   }

   public void setWantsAdventure(boolean wantsAdventure) {
      this.wantsAdventure = wantsAdventure;
   }

   public boolean isWantsComedy() {
      return wantsComedy;
   }

   public void setWantsComedy(boolean wantsComedy) {
      this.wantsComedy = wantsComedy;
   }

   public boolean isWantsDrama() {
      return wantsDrama;
   }

   public void setWantsDrama(boolean wantsDrama) {
      this.wantsDrama = wantsDrama;
   }

   public boolean isWantsHorror() {
      return wantsHorror;
   }

   public void setWantsHorror(boolean wantsHorror) {
      this.wantsHorror = wantsHorror;
   }

   public boolean isWantsRomance() {
      return wantsRomance;
   }

   public void setWantsRomance(boolean wantsRomance) {
      this.wantsRomance = wantsRomance;
   }

   public boolean isWantsScifi() {
      return wantsScifi;
   }

   public void setWantsScifi(boolean wantsScifi) {
      this.wantsScifi = wantsScifi;
   }

   public boolean isWantsThriller() {
      return wantsThriller;
   }

   public void setWantsThriller(boolean wantsThriller) {
      this.wantsThriller = wantsThriller;
   }

   public boolean isWantsFamily() {
      return wantsFamily;
   }

   public void setWantsFamily(boolean wantsFamily) {
      this.wantsFamily = wantsFamily;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return id == user.id &&
              activated == user.activated &&
              Objects.equals(username, user.username) &&
              Objects.equals(password, user.password) &&
              Objects.equals(authorities, user.authorities);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, username, password, activated, authorities);
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", username='" + username + '\'' +
              ", activated=" + activated +
              ", authorities=" + authorities +
              '}';
   }

}
