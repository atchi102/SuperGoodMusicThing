CREATE DATABASE AtchisonColeFinal;

USE AtchisonColeFinal;

CREATE TABLE Artists
(
	id INT PRIMARY KEY,
  name CHAR(50) NOT NULL UNIQUE,
	label CHAR(20),
	hometown CHAR(15),
	genre CHAR(10)
);

CREATE TABLE Genres
(
  id INT PRIMARY KEY,
	genre CHAR(15) UNIQUE
);

CREATE TABLE Labels
(
  id INT PRIMARY KEY,
	name CHAR(20) UNIQUE,
	location CHAR(25)
);

CREATE TABLE Albums
(
	id INT PRIMARY KEY,
	name CHAR(50) UNIQUE,
	year INT,
month INT,
day INT,
genre CHAR(15),
label CHAR(20),
artist CHAR(50),
FOREIGN KEY (genre) REFERENCES Genres(genre)
ON DELETE SET NULL
	ON UPDATE CASCADE,
FOREIGN KEY (label) REFERENCES Labels(name)
ON DELETE SET NULL
	ON UPDATE CASCADE,
FOREIGN KEY (artist) REFERENCES Artists(name)
ON DELETE CASCADE
ON UPDATE CASCADE
);


CREATE TABLE Songs
(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	name CHAR(25),
	artist CHAR(50),
	album CHAR(50),
	genre CHAR(15),
	songKey CHAR(15),
  FOREIGN KEY (artist) REFERENCES Artists(name)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  FOREIGN KEY (album) REFERENCES Albums(name)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
	FOREIGN KEY (genre) REFERENCES Genres(genre)
	ON DELETE SET NULL
	ON UPDATE CASCADE
);

CREATE TABLE Users(
  id INT PRIMARY KEY,
  userName CHAR(20) UNIQUE
);

CREATE TABLE UserLikes
(
	userID INT,
	likeID INT,
	FOREIGN KEY (userID) REFERENCES Users(id)
	ON DELETE CASCADE
	ON UPDATE CASCADE
)

-- likeID will be the id of whatever the user liked (artist, album, song, playlist, user etc.)

CREATE TABLE RecentListens
(
	userID INT,
	songID INT,
	albumID INT,
	artistID INT,
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
	ON UPDATE CASCADE,
FOREIGN KEY (albumID) REFERENCES Albums(id)
ON DELETE SET NULL
	ON UPDATE CASCADE,
	FOREIGN KEY (genreID) REFERENCES Genres(id)
ON DELETE SET NULL
	ON UPDATE CASCADE,
	FOREIGN KEY (labelID) REFERENCES Labels(id)
	ON DELETE SET NULL
	ON UPDATE CASCADE
)

CREATE TABLE Recommendations
(
	id INT,
	similarToID INT
)

-- Note:  The recommendation is a general id so that it can refer to an artist, album, or song and, if usability permits, a playlist
