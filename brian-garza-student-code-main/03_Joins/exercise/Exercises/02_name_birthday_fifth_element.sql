-- 2. The names and birthdays of actors in "The Fifth Element"
-- Order the results alphabetically (A-Z) by name.
-- (15 rows)
Select person_name, birthday
From person
Join movie_actor on movie_actor.actor_id = person.person_id
Join movie on movie.movie_id = movie_actor.movie_id
Where movie.title= 'The Fifth Element'
Order By person_name asc;