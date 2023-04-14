-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
Select state_name, population
From state
Order By population Desc;

-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
Select state_name, census_region
From state
Order By census_region Desc, state_name Asc;

-- The biggest park by area
Select park_name
From park
Order By area Desc;



-- LIMITING RESULTS

-- The 10 largest cities by populations
Select city_name
From city
Order By population Limit 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
Select park_name, (Current_Date - date_established)/365 As age
From park
Order By age Desc, park_name Asc
Limit 20;


-- CONCATENATING OUTPUTS
      
-- All city names and their state abbreviation.
Select city_name || ' (' || state_abbreviation || ')'
From city;

-- The all parks by name and date established.
Select Format('Name: %s Date: %s', park_name, date_established) 
From park;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
Select (census_region || ' : ' || state_name) As region_and_state
From state
Where census_region Ilike '%west'
Order By region_and_state;


-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
Select Round(Avg(population),2) as average_population
From State;

-- Total population in the West and South census regions
Select Sum(population) As west_south_population
From state
Where census_region In ('West', 'South');

-- The number of cities with populations greater than 1 million
Select Count(population)
From city
Where population > 1000000;

-- The number of state nicknames.
Select Count(state_nickname)
from state;


-- The area of the smallest and largest parks.
Select Min(area) as smallest_area, Max(area) as largest_are
From park;


-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
Select Count(city_name) as cities, state_abbreviation
From city
Group By state_abbreviation
order by cities Desc;

-- Determine the average park area depending upon whether parks allow camping or not.
Select Round(Avg(area), 2) as avg_area, has_camping
From park
group by has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
select state_abbreviation, Sum(population) as sum_city_pop
From city
Group By state_abbreviation
Order By state_abbreviation;

-- The smallest city population in each state ordered by city population.
Select Min(population) as smallest_city_pop, state_abbreviation
From city
Group by state_abbreviation
Order By smallest_city_pop
Offset 20 Rows Fetch Next 10 rows Only;


-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)



-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,


-- Include the names of the smallest and largest parks


-- List the capital cities for the states in the Northeast census region.
Select state_abbreviation, city_name
from city
Where city_id IN(Select capital From state Where census_region = 'Northeast');
