-- 12. Create a "Bill Murray Collection" in the collection table. For the movies that have Bill Murray in them, set their collection ID to the "Bill Murray Collection". (1 row, 6 rows)
Insert Into collection(collection_name)
Values ('Bill Murray Collection');

Update movie
Set collection_id = (Select collection_id From collection Where collection_id = 'Bill Murray Collection')
Where movie_id In (Select movie_id From movie_actor where actor_id = (Select person_id From person Where person_name = 'Bill Murray'));					 
