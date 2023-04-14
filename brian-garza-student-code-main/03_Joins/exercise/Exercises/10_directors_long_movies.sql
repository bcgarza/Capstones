-- 10. The names of directors who have directed a movie over 3 hours [180 minutes], sorted alphabetically.
-- (15 rows)
Select Distinct(person_name)
From person
Join movie ON person.person_id = movie.director_id 
Where length_minutes > 180
Order By person_name asc;
