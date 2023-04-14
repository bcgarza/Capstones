-- 3. For all actors with the last name of "Jones", display the actor's name and movie titles they appeared in. 
-- Order the results by the actor names (A-Z) and then by movie title (A-Z). 
-- (48 rows)
Select person_name, movie.title
From person
Join movie_actor on person.person_id = movie_actor.actor_id
Join movie on movie_actor.movie_id = movie.movie_id
Where person_name Like '% Jones'
Order By person_name, movie.title;
