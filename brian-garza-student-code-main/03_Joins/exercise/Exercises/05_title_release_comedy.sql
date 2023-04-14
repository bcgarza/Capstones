-- 5. The titles and release dates of all the movies that are in the Comedy genre. 
-- Order the results by release date, earliest to latest. 
-- (220 rows)
Select title, release_date
From movie
Join movie_genre on movie_genre.movie_id = movie.movie_id
Join genre on genre.genre_id = movie_genre.genre_id
Where genre_name Like 'Comedy'
Order By release_date Asc;
