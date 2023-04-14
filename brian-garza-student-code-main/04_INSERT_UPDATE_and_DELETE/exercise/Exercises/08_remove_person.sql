-- 8. Remove "Penn Jillette" from the person table 
-- You'll have to remove data from another table before you can make him "disappear" (Get it? Because he's a magician...) (1 row each)
Delete From movie_actor
Where actor_id = (Select person_id From person Where person_name = 'Penn Jillette');
Delete From person
Where person_name = 'Penn Jillette';
