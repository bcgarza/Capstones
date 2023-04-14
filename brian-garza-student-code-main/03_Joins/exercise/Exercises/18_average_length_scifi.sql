-- 18. The average length of movies in the "Science Fiction" genre. Name the column 'average_length'.
-- (1 row, expected result between 110-120)
Select Avg(length_minutes) as average_length
From movie
Join movie_genre On movie_genre.movie_id = movie.movie_id
Join genre On genre.genre_id = movie_genre.genre_id
Where genre_name = 'Science Fiction'


