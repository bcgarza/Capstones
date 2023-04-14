-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas, sorted alphabetically.
-- (5 rows)
Select title
From movie
Join collection On collection.collection_id = movie.collection_id
Join person on person.person_id = movie.director_id
Where collection_name Like 'Star Wars Collection' and person_name Not Like 'George Lucas'
Order By title asc;
