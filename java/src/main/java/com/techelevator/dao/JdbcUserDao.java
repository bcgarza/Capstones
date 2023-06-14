package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.techelevator.model.User;

@Component
public class JdbcUserDao implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int findIdByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");

        int userId;
        try {
            userId = jdbcTemplate.queryForObject("select user_id from users where username = ?", int.class, username);
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("User " + username + " was not found.");
        }

        return userId;
    }

	@Override
	public User getUserById(int userId) {
		String sql = "SELECT * FROM users WHERE user_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		if (results.next()) {
			return mapRowToUser(results);
		} else {
			return null;
		}
	}

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "select * from users";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }

        return users;
    }

    @Override
    public User findByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");

        for (User user : this.findAll()) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        throw new UsernameNotFoundException("User " + username + " was not found.");
    }

    @Override
    public boolean create(String username, String password, String role) {
        String insertUserSql = "insert into users (username,password_hash,role) values (?,?,?)";
        String password_hash = new BCryptPasswordEncoder().encode(password);
        String ssRole = role.toUpperCase().startsWith("ROLE_") ? role.toUpperCase() : "ROLE_" + role.toUpperCase();

        return jdbcTemplate.update(insertUserSql, username, password_hash, ssRole) == 1;
    }

    @Override
    public int getUserId() {

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//
//        String currentUser = userDetails.getUsername();

        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        System.out.println(username);

        String sql = "SELECT user_id FROM users WHERE username = ?";

//        int userId;

        try {
           int userId = jdbcTemplate.queryForObject(sql, int.class, username);
           return userId;
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("Unable to find matching Id number.");
        }
    }

    @Override
    public boolean updateUser(int userId, boolean wantsAction, boolean wantsAdventure,
                              boolean wantsComedy, boolean wantsDrama, boolean wantsHorror,
                              boolean wantsRomance, boolean wantsScifi, boolean wantsThriller,
                              boolean wantsFamily) {
        try {
            String sql = "UPDATE users SET wants_action = ?, wants_adventure = ?, wants_comedy = ?, " +
                    "wants_drama = ?, wants_horror = ?, wants_romance = ?, wants_scifi = ?, wants_thriller = ?, " +
                    "wants_family = ? WHERE user_id = ?";

            int rowsAffected = jdbcTemplate.update(sql, wantsAction, wantsAdventure, wantsComedy, wantsDrama,
                               wantsHorror, wantsRomance, wantsScifi, wantsThriller, wantsFamily, userId);
            return rowsAffected > 0;
        } catch (DataAccessException e) {
            System.out.println("Error updating user preferences: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String[] getPreferredGenres(User user) {
        List<String> preferredGenres = new ArrayList<>();

        if(user.isWantsAction()) {
            preferredGenres.add("action");
        }
        if(user.isWantsAdventure()) {
            preferredGenres.add("adventure");
        }
        if(user.isWantsComedy()) {
            preferredGenres.add("comedy");
        }
        if(user.isWantsDrama()) {
            preferredGenres.add("drama");
        }
        if(user.isWantsFamily()) {
            preferredGenres.add("family");
        }
        if(user.isWantsHorror()) {
            preferredGenres.add("horror");
        }
        if(user.isWantsRomance()) {
            preferredGenres.add("romance");
        }
        if(user.isWantsScifi()) {
            preferredGenres.add("scifi");
        }
        if(user.isWantsThriller()) {
            preferredGenres.add("thriller");
        }

        String[] genresArray = preferredGenres.toArray(new String[0]);

        return genresArray;

    }

    private User mapRowToUser(SqlRowSet results) {
        User user = new User();
        user.setId(results.getInt("user_id"));
        user.setUsername(results.getString("username"));
        user.setPassword(results.getString("password_hash"));

        user.setWantsAction(results.getBoolean("wants_action"));
        user.setWantsAdventure(results.getBoolean("wants_adventure"));
        user.setWantsComedy(results.getBoolean("wants_comedy"));
        user.setWantsDrama(results.getBoolean("wants_drama"));
        user.setWantsHorror(results.getBoolean("wants_horror"));
        user.setWantsRomance(results.getBoolean("wants_romance"));
        user.setWantsScifi(results.getBoolean("wants_scifi"));
        user.setWantsThriller(results.getBoolean("wants_thriller"));
        user.setWantsFamily(results.getBoolean("wants_family"));

        user.setAuthorities(Objects.requireNonNull(results.getString("role")));
        user.setActivated(true);
        return user;
    }

}
