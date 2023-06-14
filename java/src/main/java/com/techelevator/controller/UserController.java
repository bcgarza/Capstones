package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

//    @RequestMapping(value = "/preferences", method = RequestMethod.GET)
//    public User getCurrentUserInfo () {
//
//        int userId = userDao.getUserId();
//        User user = userDao.getUserById(userId);
//
//        if(user == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
//        } else {
//            return user;
//        }
//    }

    //temporary controller method used to get details from user "user" (the standard test user in database)
    @RequestMapping(path = "/preferences/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("userId") int userId) {
        User user = userDao.getUserById(userId);
        return user;
    }

    //temporary controller method to set preference details for "user"
    @RequestMapping(path = "/preferences/update", method = RequestMethod.PUT)
    public void updatePreferences(@RequestBody User user) {

        boolean wantsAction = user.isWantsAction();
        boolean wantsAdventure = user.isWantsAdventure();
        boolean wantsComedy = user.isWantsComedy();
        boolean wantsDrama = user.isWantsDrama();
        boolean wantsHorror = user.isWantsHorror();
        boolean wantsRomance = user.isWantsRomance();
        boolean wantsScifi = user.isWantsScifi();
        boolean wantsThriller = user.isWantsThriller();
        boolean wantsFamily = user.isWantsFamily();

        userDao.updateUser(user.getId(), wantsAction, wantsAdventure, wantsComedy, wantsDrama, wantsHorror, wantsRomance, wantsScifi, wantsThriller, wantsFamily);
    }

}

