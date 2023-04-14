-- 20. The state abbreviation, and population of the city with the largest population (name column 'city_population') for all states, territories, and districts.
-- Order the results from highest to lowest populations.
-- (56 rows)
Select state_abbreviation, Max(population) as city_population
From city
Group by state_abbreviation
Order By city_population Desc; 

