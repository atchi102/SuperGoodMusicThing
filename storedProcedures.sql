
-- Procedure for user login
-- givenUsername : the username a user enters, is also what is displayed in the app
-- store the returned value (userID) to be used for future queries
CREATE PROCEDURE userLogin( IN givenUsername CHAR(20))
BEGIN
  IF EXISTS(SELECT * FROM Users WHERE username = givenUsername) THEN
  SELECT * FROM Users WHERE username = givenUsername;
  ELSE
  INSERT INTO Users (username) VALUES(givenUsername);
  END IF;
END//


CREATE PROCEDURE getRecentListens(IN user INT)
BEGIN
  IF EXISTS(SELECT * FROM RecentListens WHERE userID = user) THEN
  SELECT * FROM RecentListens WHERE userID = user;
  ELSE
  SELECT * FROM RecentListens WHERE userID = 0;
  END IF;
END//
-- Procedure for inserting a recent listen into the table
-- All input variables are IDs (if you do not have the id another stored procedure can be launced)
CREATE PROCEDURE insertRecentListen(IN user INT, IN song INT, IN album INT, IN artist INT, IN genre INT, IN label INT)
BEGIN
INSERT INTO RecentListens (userID,songID,albumID,artistID,genreID,labelID)
VALUES (user, song, album, artist, genre, label);
END//

CREATE PROCEDURE search(IN search CHAR(50))
BEGIN

SELECT * FROM Songs WHERE
name LIKE (SELECT CONCAT('%',search,'%'));

SELECT * FROM Albums WHERE
name LIKE (SELECT CONCAT('%',search,'%'));

SELECT * FROM Artists WHERE
name LIKE (SELECT CONCAT('%',search,'%'));

SELECT * FROM Genres WHERE genre LIKE (SELECT CONCAT('%',search,'%'));
END//

CREATE PROCEDURE getArtistID(IN given CHAR(50))
BEGIN
SELECT * FROM Artists WHERE name = given;
END//

CREATE PROCEDURE getGenreID(IN given CHAR(15))
BEGIN
SELECT * FROM Genres WHERE genre = given;
END//

CREATE PROCEDURE getSongID(IN given CHAR(50))
BEGIN
SELECT * FROM Songs WHERE name = given;
END//

CREATE PROCEDURE getAlbumID(IN given CHAR(50))
BEGIN
SELECT * FROM Album WHERE name = given;
END//

CREATE PROCEDURE populate()
BEGIN
SELECT * FROM Songs;
END//

CREATE PROCEDURE sortBy(IN given CHAR(15))
BEGIN
IF given = 'Song' then
SELECT * FROM Songs ORDER BY name;
ELSEIF given = 'Artist' then
SELECT * FROM Songs ORDER BY artist;
ELSEIF given = 'Album' then
SELECT * FROM Songs ORDER BY album;
ELSEIF given = 'Genre' then
SELECT * FROM Songs ORDER BY genre;
END IF;
END//
