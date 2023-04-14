-- CAMPGROUND TABLE
-----------------------------------------------

-- select name and daily fee of all campgrounds (expected: 7 rows)
Select name, daily_fee
From campground;


-- select name and daily fee of all campgrounds ordered by campground name (expected: 7 rows, starting with "Blackwoods")
Select name, daily_fee
From campground
Order By name Asc;

-- select name, open from month, open to month, and daily fee of the campgrounds where daily fee is less than $100 (expected: 5 rows)
Select name, open_from_mm, open_to_mm, daily_fee
From campground
Where daily_fee < '100';

-- select name and daily fee of the campgrounds where the campground is open all year long (expected: 4 rows)
Select name, daily_fee
From campground
Where open_from_mm = 1 And open_to_mm = 12;

-- PARK TABLE
-----------------------------------------------

-- select name and description of all parks order by established date in descending order (expected: 3 rows, startng with "Cuyahoga Valley")
Select name, description
From park
Order By establish_date Desc;

-- select name and description of all parks in Ohio (expected: 1 row)
Select name, description
From park
Where location = 'Ohio';

-- select name and description of all parks NOT in Ohio (expected: 2 rows)
Select name, description
From park
Where location != 'Ohio';

-- select the total number of visitors for all parks (expected: around 6 million)
Select Sum(visitors) as sum_of_all_visitors
From park;

-- select the average number of visitors for all parks (expected: around 2 million)
Select Avg(visitors) as avg_of_visitors
From park;

-- SITE TABLE
-----------------------------------------------

-- select all columns from site where utilities is true and order by max RV length with the largest coming first
-- (expected: 26 rows, starting with 35-foot max_rv_length)
Select *
From site
Where utilities = 'true'
Order By max_rv_length desc;

-- select total number of sites that have utilities hook up (expected: around 25)
 Select count(site_id)
 From site
 Where utilities = 'true';

-- RESERVATION TABLE
-----------------------------------------------

-- select reservation id, site id, name, from date, to date of the reservations where the checkin date 
--	is between the first and last day of the current month (hard coded month is ok) 
-- (expected row count may vary, should be no more than 44)
Select reservation_id, site_id, name, from_date, to_date
From reservation
Where from_date Between'2023-04-01' and '2023-04-30';

-- select all columns from reservation where name includes 'Reservation' (expected: 23 rows)
Select *
From reservation
Where name Like '%Reservation%';

-- select the total number of reservations in the reservation table (expected: around 40)
Select *
From reservation;

-- select reservation id, site id, name of the reservations where site id is in the list 9, 20, 24, 45, 46 (expected: 16 rows)
Select reservation_id, site_id, name
From reservation
Where site_id IN (9, 20, 24, 45, 46);

-- select the date and number of reservations for each date ordered by from_date in ascending order (expected: 24 rows, starting from the earliest date)
Select from_date, Count(*)
From reservation
Group By from_date
Order by from_date Asc;

