-- 15. The name and date established of the newest national park.
-- (1 row)
Select park_name, date_established
From park
Order by date_established Desc
limit 1;