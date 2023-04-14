-- 4. The titles and taglines of all the movies that are in the Fantasy genre. 
-- Order the results by title (A-Z).
-- (81 rows)
Select title, tagline
From movie
Join movie_genre On movie_genre.movie_id = movie.movie_id
Join genre On genre.genre_id = movie_genre.genre_id
Where genre_name = 'Fantasy'
Order by title asc;