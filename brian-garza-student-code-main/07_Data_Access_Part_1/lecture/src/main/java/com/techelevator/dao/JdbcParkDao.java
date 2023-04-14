package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getParkCount() {
        int parkCount = 0;
        String sql = "Select Count(*) As count From park;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        if(result.next()){
            parkCount = result.getInt("count");
        }
        return parkCount;
    }
    
    @Override
    public LocalDate getOldestParkDate() {
        LocalDate dateEstablished = null;
        String sql = "Select Min(date_established) as date_established From park;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        if(result.next()){
            try {
                dateEstablished = result.getDate("date_established").toLocalDate();
            }
            catch(NullPointerException e){
                System.out.println("Null pointer in get oldest park date");
            }
        }
        return dateEstablished;
    }
    
    @Override
    public double getAvgParkArea() {
        double avgArea = 0.0;
        String sql =  "Select Round(Avg(area),2) as avg_area From Park;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        if(result.next()){
            avgArea = result.getDouble("avg_area");
        }
        return avgArea;
    }
    
    @Override
    public List<String> getParkNames() {
        List<String> parkNames = new ArrayList<>();
        String sql = "Select park_name From park Order By park_name Asc;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
            while(result.next()){
                parkNames.add(result.getString("park_name"));
            }
        return parkNames;
    }
    
    @Override
    public Park getRandomPark() {
        Park park = null;
        String sql = "Select park_id, park_name, date_established, area, has_camping\n" +
                "From park\n" +
                "Order By Random()\n" +
                "Limit 1;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        if(result.next()){
            park = mapRowToPark(result);
        }
        return park;
    }

    @Override
    public List<Park> getParksWithCamping() {
        return new ArrayList<>();
    }

    @Override
    public Park getParkById(int parkId) {
        return new Park();
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        List<Park> park = new ArrayList<>();
        
        return park;
    }

    private Park mapRowToPark(SqlRowSet rowSet) {
        Park park = new Park();
        park.setParkId(rowSet.getInt("park_id"));
        park.setParkName(rowSet.getString("park_name"));
        park.setArea(rowSet.getDouble("area"));
        park.setDateEstablished(rowSet.getDate("date_established").toLocalDate());
        park.setHasCamping(rowSet.getBoolean("has_camping"));
        return park;
    }
}
