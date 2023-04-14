-- 17. The titles and taglines of movies that are in the "Family" genre that Samuel L. Jackson has acted in.
-- Order the results alphabetically by movie title.
-- (4 rows)
Select title, tagline
From movie
Join movie_actor On movie_actor.movie_id = movie.movie_Id
Join person On person.person_id = movie_actor.actor_Id
Join movie_genre On movie_genre.movie_id = movie.movie_id
Join genre On genre.genre_id = movie_genre.genre_id
Where person_name = 'Samuel L. Jackson' And genre_name = 'Family'
Order By title Asc;
