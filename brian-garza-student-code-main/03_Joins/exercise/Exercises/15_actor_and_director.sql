-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie.
-- Order the results by movie title (A-Z)
-- (73 rows)
Select title, person_name
From movie
Join movie_actor on movie_actor.movie_id = movie.movie_id
Join person On person.person_id = movie_actor.actor_id
Where director_id = actor_id
Order By title asc;
