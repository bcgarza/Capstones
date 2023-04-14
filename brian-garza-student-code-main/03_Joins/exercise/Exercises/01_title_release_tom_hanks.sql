-- 1. The titles and release dates of movies that Tom Hanks has appeared in. 
-- Order the results by release date, newest to oldest.
-- (47 rows)
Select title, release_date
From movie
Join movie_actor On movie.movie_id = movie_actor.movie_id
Join person on person.person_id = movie_actor.actor_id 
Where person.person_name = 'Tom Hanks'
Order By release_date Desc;