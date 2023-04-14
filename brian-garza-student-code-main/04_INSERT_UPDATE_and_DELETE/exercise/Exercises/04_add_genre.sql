-- 4. Add a "Sports" genre to the genre table. Add the movie "Coach Carter" to the newly created genre. (1 row each)
Insert Into genre(genre_name)
Values ('Sports');
Insert Into movie_genre (movie_id, genre_id)
Values ((Select movie_id From movie Where title = 'Coach Carter'), (Select genre_id From genre Where genre_name = 'Sports'));