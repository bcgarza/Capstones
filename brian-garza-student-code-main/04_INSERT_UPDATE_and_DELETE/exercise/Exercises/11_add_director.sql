-- 11. Hollywood is remaking the classic movie "The Blob" and doesn't have a director yet. 
--Add yourself to the person table, and assign yourself as the director of "The Blob" (the movie is already in the movie table). (1 record each)
Insert Into person (person_name)
Values ('Brian Garza');

Update movie Set director_id = (Select person_id From movie Where person_name = 'Brian Garza')
Where title = 'The Blob';
