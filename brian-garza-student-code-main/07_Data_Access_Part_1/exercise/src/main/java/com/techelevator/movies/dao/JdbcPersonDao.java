package com.techelevator.movies.dao;

import com.techelevator.movies.model.Movie;
import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Get a list of all persons from the datastore.
     * The list is never null. It is empty if there are no persons in the datastore.
     *
     * @return all persons as a list of Person objects
     */
    @Override
    public List<Person> getPersons() {
        List<Person> personList = new ArrayList<>();
        String sql = "Select * From person;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()){
            Person person = mapRowToPerson(result);
            personList.add(person);
        }
        return personList;
    }

    @Override
    public Person getPersonById(int id) {
        Person person = new Person();
        String sql = "Select * From person Where person_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if (result.next()) {
           person = mapRowToPerson(result);
        }else{
            return null;
        }
        return person;
    }

    @Override
    public List<Person> getPersonsByName(String name, boolean useWildCard) {
        List<Person> personList = new ArrayList<>();
        String sql = "Select * From person Where person_name ILike ?;";
        if(useWildCard){
            name = "%"+name+"%";
        }
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, name);
        while(result.next()){
            Person person = mapRowToPerson(result);
            personList.add(person);
        }
        return personList;

    }

    @Override
    public List<Person> getPersonsByCollectionName(String collectionName, boolean useWildCard) {
        List<Person> personList = new ArrayList<>();
        String sql = "Select Distinct person_id, person_name, birthday, deathday, biography, profile_path, person.home_page From person Join movie_actor On movie_actor.actor_id = person.person_id Join movie On movie.movie_id = movie_actor.movie_id Join collection On collection.collection_id = movie.collection_id Where collection_name ILike ?;";
        if(useWildCard){
            collectionName = "%"+collectionName+"%";
        }
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, collectionName);
        while(result.next()){
            Person person = mapRowToPerson(result);
            personList.add(person);
        }
        return personList;
    }

    private Person mapRowToPerson(SqlRowSet rowSet) {
        Person person = new Person();
        person.setId(rowSet.getInt("person_id"));
        person.setName(rowSet.getString("person_name"));
        try {
            person.setBirthday(rowSet.getDate("birthday").toLocalDate());
            person.setDeathDate(rowSet.getDate("deathday").toLocalDate());
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        person.setBiography(rowSet.getString("biography"));
        person.setProfilePath(rowSet.getString("profile_path"));
        person.setHomePage(rowSet.getString("home_page"));
        return person;
    }
}
