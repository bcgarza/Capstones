-- 14. The names of actors who've appeared in the movies in the "Back to the Future Collection", sorted alphabetically.
-- (28 rows)
Select Distinct(person_name)
From person 
Join movie_actor On movie_actor.actor_id = person.person_id 
Join movie On movie.movie_id = movie_actor.movie_id
Join collection On collection.collection_id = movie.collection_id
Where collection_name Like 'Back to the Future Collection'
Order By person_name Asc;