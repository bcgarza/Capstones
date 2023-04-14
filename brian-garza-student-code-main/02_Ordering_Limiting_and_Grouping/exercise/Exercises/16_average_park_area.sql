-- 16. The average area of national parks that have camping. Name the column 'average_park_area'.
-- Expected answer is around 3,900.
-- (1 row)
Select Avg(area) as average_park_area
From park
Where has_camping = true;
