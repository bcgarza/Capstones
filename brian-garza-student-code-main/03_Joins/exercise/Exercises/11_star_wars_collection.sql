-- 11. The titles of the movies in the "Star Wars Collection" ordered by release date, most recent first. 
-- (9 rows)
Select title
From movie
Join collection on collection.collection_id = movie.collection_id
Where collection_name like 'Star Wars Collection'
Order By release_date desc;
