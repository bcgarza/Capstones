-- 6. The sum of the population of all states in the "South" census region. Name the column 'south_population'.
-- Expected answer is around 125,000,000
-- (1 row)
Select Sum(population) as south_population
From state
where census_region = 'South';
