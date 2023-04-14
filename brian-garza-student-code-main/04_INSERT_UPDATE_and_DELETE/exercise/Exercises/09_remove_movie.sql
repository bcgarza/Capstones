-- 9. Remove "Memento" from the movie table
-- You'll have to remove data from two other tables before you can remove it (13 rows, 2 rows, 1 row)
Delete From movie_genre 
Where movie_id = (Select movie_id From movie Where title = 'Memento');

Delete From movie_actor
Where movie_id = (Select movie_id From movie Where title = 'Memento'); 
 
Delete From movie
Where title = 'Memento';
