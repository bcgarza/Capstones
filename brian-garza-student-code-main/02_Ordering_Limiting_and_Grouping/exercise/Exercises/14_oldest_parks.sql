-- 14. The name and date established of the top 10 oldest national parks.
-- Order the results with the oldest park first.
-- (10 rows)
Select park_name, date_established
From park
Order By date_established Asc
Limit 10;
