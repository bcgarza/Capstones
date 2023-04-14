-- 13. The directors of the movies in the "Harry Potter Collection", sorted alphabetically.
-- (4 rows)
Select Distinct(person_name)
From person
Join movie on movie.director_id = person.person_id
Join collection On collection.collection_id = movie.collection_id
Where collection_name Like 'Harry Potter Collection'
Order By person_name asc;
