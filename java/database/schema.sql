BEGIN TRANSACTION;

DROP TABLE IF EXISTS movies, users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	wants_action boolean NULL,
	wants_adventure boolean NULL,
	wants_comedy boolean NULL,
	wants_drama boolean NULL,
	wants_horror boolean NULL,
	wants_romance boolean NULL,
	wants_scifi boolean NULL,
	wants_thriller boolean NULL,
	wants_family boolean NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);


CREATE TABLE movies (
	movie_id varchar(50) NOT NULL,
	movie_title varchar(50) NOT NULL,
	movie_genre int NULL,
	already_watched boolean NULL,
	movie_rating int NULL,
	want_to_watch boolean NULL,
	img_url varchar(200),
	CHECK (movie_rating BETWEEN 0 and 5),
	CONSTRAINT PK_movie PRIMARY KEY (movie_id)
);

COMMIT TRANSACTION;
