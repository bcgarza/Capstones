-- 7. The genres of movies that Christopher Lloyd has appeared in, sorted alphabetically.
-- (8 rows) Hint: DISTINCT will prevent duplicate values in your query results.
Select Distinct(genre_name)
From genre
Join  movie_genre On movie_genre.genre_id = genre.genre_id
Join movie On movie.movie_id = movie_genre.movie_id
Join movie_actor On movie_actor.movie_id = movie.movie_id
Join person On person.person_id = movie_actor.actor_id
Where person_name Like 'Christopher Lloyd'
Order by genre_name Asc;

