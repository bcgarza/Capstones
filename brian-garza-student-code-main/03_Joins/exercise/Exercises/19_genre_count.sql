-- 19. The genre name and the number of movies in each genre. Name the count column 'num_of_movies'.
-- Order the results from the highest movie count to the lowest.
-- (19 rows, the highest expected count is around 400).
Select genre_name, Count(*) As num_of_movies
From genre 
Join movie_genre On movie_genre.genre_id = genre.genre_id
Join movie On movie.movie_id = movie_genre.movie_id
Group by genre_name
Order by count(*) desc;