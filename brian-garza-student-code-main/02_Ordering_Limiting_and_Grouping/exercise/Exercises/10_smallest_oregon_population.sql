-- 10. The population of the city with the smallest population in Oregon (OR). Name the column 'smallest_oregon_population'.
-- Expected answer is around 100,000
-- (1 row)
Select Min(population) as smallest_oregon_population
From city
Where state_abbreviation = 'OR';
