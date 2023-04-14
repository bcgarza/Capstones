-- 7. Remove the actor appearances in "Avengers: Infinity War" (14 rows)
-- Note: Don't remove the actors themeselves, just make it so it seems no one appeared in the movie.
Delete From movie_actor
Where movie_id = (Select movie_id From movie Where title = 'Avengers: Infinity War');
