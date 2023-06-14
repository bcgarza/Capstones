package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password, String role);

    int getUserId();

    boolean updateUser(int userId, boolean wantsAction, boolean wantsAdventure, boolean wantsComedy, boolean wantsDrama, boolean wantsHorror, boolean wantsRomance, boolean wantsScifi, boolean wantsThriller, boolean wantsFamily);

    String[] getPreferredGenres(User user);

}
