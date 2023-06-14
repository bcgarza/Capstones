BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


INSERT INTO movies (movie_id, movie_title, movie_genre, already_watched, movie_rating, want_to_watch, img_url)
	VALUES ('765810', 'Spectre', 35, NULL, NULL, false, 'https://image.tmdb.org/t/p/original/672kUEMtTHcaVYSVY4eiHEliHFa.jpg');

INSERT INTO movies (movie_id, movie_title, movie_genre, already_watched, movie_rating, want_to_watch, img_url)
	VALUES ('519182', 'Top Gun', 35, true, 2, NULL, 'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xUuHj3CgmZQ9P2cMaqQs4J0d4Zc.jpg');


COMMIT TRANSACTION;
