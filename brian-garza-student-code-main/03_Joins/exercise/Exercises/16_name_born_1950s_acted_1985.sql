-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985.
-- Order the results by actor from oldest to youngest.
-- (20 rows)
Select Distinct(person_name), birthday
From person
Join movie_actor On movie_actor.actor_id = person.person_id
Join movie On movie.movie_id = movie_actor.movie_id
Where (release_date Between '1985-01-01' and '1985-12-31') AND (birthday Between '1950-01-01' and '1959-12-31')
Order By birthday asc;
