-- select the park name, campground name, open_from_mm, open_to_mm & daily_fee ordered by park name and then campground name
-- (expected: 7 rows, starting with "Blackwoods")
Select park.name as park_name, campground.name as campground_name, open_from_mm, open_to_mm, daily_fee
From campground
Join park Using (park_id)
Order By park.name, campground.name;

-- select the park name and the total number of campgrounds for each park ordered by park name
-- (expected: 3 rows, starting with "Acadia")
Select park.name as park_name, Count(*) as num_campgrnds
From campground
Join park Using (park_id)
Group By park.name
Order By park.name;

-- select the park name, campground name, site number, max occupancy, accessible, max rv length, utilities where the campground name is 'Blackwoods'
-- (expected: 12 rows)
Select park.name as park_name, campground.name as campground_name, site_number, max_occupancy, accessible, max_rv_length, utilities
From site
Join campground Using(campground_id)
Join park Using (park_id)
Where campground.name = 'Blackwoods';


-- select site number, reservation name, reservation from and to date ordered by reservation from date
-- (expected: 44 rows, starting with the earliest date)
Select site_number, reservation.name as reservation_name, from_date, to_date
From reservation
Join site Using (site_id)
Order by from_date;

