-- INNER JOIN

-- Write a query to retrieve the name and state abbreviation for the 2 cities named "Columbus" in the database
Select city_name, state_abbreviation
From city
where city_name = 'Columbus';

-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).
Select state_name, city_name
From city
Join state On city.state_abbreviation = state.state_abbreviation
Where city_name = 'Columbus';

-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)
Select park_name, state_abbreviation
From park
Join park_state On park.park_id = park_state.park_id;

-- The park_state table is an associative table that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names of the states rather than their abbreviations.
select park_name, state_name
from park
Join park_state on park.park_id = park_state.park_id
Join state on park_state.state_abbreviation = state.state_abbreviation;

-- Modify the previous query to include the name of the state's capital city.
select park_name, state_name, city_name As capital
from park
Join park_state on park.park_id = park_state.park_id
Join state on park_state.state_abbreviation = state.state_abbreviation
Join city on state.capital = city.city_id;

-- Modify the previous query to include the area of each park.
select park_name, state_name, city_name as capital, park.area
from park
Join park_state on park.park_id = park_state.park_id
Join state on park_state.state_abbreviation = state.state_abbreviation
Join city on state.capital = city.city_id;

-- Write a query to retrieve the names and populations of all the cities in the Midwest census region.
Select city_name, city.population
from city
Join state Using (state_abbreviation)
Where census_region = 'Midwest';


-- Write a query to retrieve the number of cities in the city table for each state in the Midwest census region.
Select state_name, Count(*)
From city
Join state Using(state_abbreviation)
Where census_region = 'Midwest'
Group By state_name;

-- Modify the previous query to sort the results by the number of cities in descending order.
Select state_name, Count(*)
From city
Join state Using(state_abbreviation)
Where census_region = 'Midwest'
Group By state_name
Order By Count(*)Desc;


-- LEFT JOIN

-- Write a query to retrieve the state name and the earliest date a park was established in that state (or territory) for every record in the state table that has park records associated with it.
Select state_name, Min(date_established)
From state
Join park_state Using(state_abbreviation)
Join park Using(park_id)
Group By state_name;

-- Modify the previous query so the results include entries for all the records in the state table, even if they have no park records associated with them.
Select state_name, Min(date_established)
From state
Left Join park_state Using(state_abbreviation)
Left Join park Using(park_id)
Group By state_name;


-- UNION

-- Write a query to retrieve all the place names in the city and state tables that begin with "W" sorted alphabetically. (Washington is the name of a city and a state--how many times does it appear in the results?)
Select city_name as place_name
From city
Where city_name Like 'W%'

Union

Select state_name
From state
Where state_name Like 'W%';
-- Modify the previous query to include a column that indicates whether the place is a city or state.
Select city_name as place_name, 'City' as city_state_ind
From city
Where city_name Like 'W%'

Union

Select state_name, 'State'
From state
Where state_name Like 'W%';


-- MovieDB
-- After creating the MovieDB database and running the setup script, make sure it is selected in pgAdmin and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres


-- The titles of all the Comedy movies

