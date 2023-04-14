-- 18. The count of the number of cities (name column 'num_cities') and the state abbreviation for each state and territory (exclude state abbreviation DC).
-- Order the results by state abbreviation.
-- (55 rows)
Select Count(*) as num_cities, state_abbreviation
From city
Where state_abbreviation != 'DC'
Group By state_abbreviation
Order By state_abbreviation;
