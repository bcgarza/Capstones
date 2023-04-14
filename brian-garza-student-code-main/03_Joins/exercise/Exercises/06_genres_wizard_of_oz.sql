-- 6. The genres of "The Wizard of Oz" sorted in alphabetical order (A-Z).
-- (3 rows)
Select genre_name
From genre
Join movie_genre On movie_genre.genre_id = genre.genre_id
Join movie On movie.movie_id = movie_genre.movie_id
Where title = 'The Wizard of Oz'
Order By genre_name asc;
