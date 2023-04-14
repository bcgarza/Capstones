-- 8. The genres of movies that Robert De Niro has appeared in that were released in 2010 or later, sorted alphabetically.
-- (6 rows)
Select Distinct(genre_name)
From genre 
Join  movie_genre On movie_genre.genre_id = genre.genre_id
Join movie On movie.movie_id = movie_genre.movie_id
Join movie_actor On movie_actor.movie_id = movie.movie_id
Join person On person.person_id = movie_actor.actor_id
Where person_name Like 'Robert De Niro' and movie.release_date >= '2010-01-01'
Order by genre_name asc;
