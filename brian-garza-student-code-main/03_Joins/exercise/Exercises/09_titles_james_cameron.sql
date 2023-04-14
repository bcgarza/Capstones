-- 9. The titles of movies directed by James Cameron, sorted alphabetically.
-- (6 rows)
Select title
From movie
Join person on person.person_id = movie.director_id
Where person_name Like 'James Cameron'
Order By title asc;
