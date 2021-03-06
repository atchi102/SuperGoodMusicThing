delimiter ;

CREATE DATABASE AtchisonColeFinal;

USE AtchisonColeFinal;

DROP TABLE Recommendations;
DROP TABLE RecentListens;
DROP TABLE UserLikes;
DROP TABLE Users;
DROP TABLE Songs;
DROP TABLE Albums;
DROP TABLE Labels;
DROP TABLE Genres;
DROP TABLE Artists;

CREATE TABLE Artists
(
	id INT AUTO_INCREMENT PRIMARY KEY,
  name CHAR(50) NOT NULL UNIQUE,
	label CHAR(20),
	hometown CHAR(15),
	genre CHAR(10)
);

ALTER TABLE Artists AUTO_INCREMENT=1000000;

CREATE TABLE Genres
(
  id INT AUTO_INCREMENT PRIMARY KEY,
	genre CHAR(15) UNIQUE
);

ALTER TABLE Genres AUTO_INCREMENT=2000000;

CREATE TABLE Labels
(
  id INT AUTO_INCREMENT PRIMARY KEY,
	name CHAR(20) UNIQUE,
	location CHAR(25)
);

ALTER TABLE Labels AUTO_INCREMENT=3000000;

CREATE TABLE Albums
(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name CHAR(50) UNIQUE NOT NULL,
	year INT,
month INT,
day INT,
genre CHAR(15),
label CHAR(20),
artist CHAR(50) NOT NULL,
FOREIGN KEY (artist) REFERENCES Artists(name)
ON DELETE CASCADE
ON UPDATE CASCADE
);

ALTER TABLE Albums AUTO_INCREMENT=4000000;


CREATE TABLE Songs
(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	name CHAR(50) NOT NULL,
	artist CHAR(50) NOT NULL,
	album CHAR(50),
	genre CHAR(15),
	valence FLOAT,
	danceabilty FLOAT,
	accessibilty FLOAT,
  FOREIGN KEY (artist) REFERENCES Artists(name)
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

ALTER TABLE Songs AUTO_INCREMENT=5000000;

CREATE TABLE Users(
  id INT AUTO_INCREMENT PRIMARY KEY,
  userName CHAR(20) UNIQUE
);

ALTER TABLE Users AUTO_INCREMENT=6000000;

CREATE TABLE UserLikes
(
	userID INT,
	likeID INT,
	FOREIGN KEY (userID) REFERENCES Users(id)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);

-- likeID will be the id of whatever the user liked (artist, album, song, playlist, user etc.)

CREATE TABLE RecentListens
(
	userID INT NOT NULL,
	songID INT NOT NULL,
	albumID INT,
	artistID INT NOT NULL,
	genreID INT,
	labelID INT,
	FOREIGN KEY (userID) REFERENCES Users(id)
	ON DELETE CASCADE
	ON UPDATE CASCADE,
	FOREIGN KEY (artistID) REFERENCES Artists(id)
ON DELETE CASCADE
ON UPDATE CASCADE,
	FOREIGN KEY (songID) REFERENCES Songs(id)
ON DELETE CASCADE
	ON UPDATE CASCADE
);

CREATE TABLE Recommendations
(
	id INT AUTO_INCREMENT PRIMARY KEY,
	similarToID INT
);

ALTER TABLE Recommendations AUTO_INCREMENT=7000000;

-- Note:  The recommendation is a general id so that it can refer to an artist, album, or song and, if usability permits, a playlist
