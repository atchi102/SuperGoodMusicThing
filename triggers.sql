

CREATE TRIGGER ArtistInsertTrigger BEFORE INSERT ON Songs
FOR EACH ROW
BEGIN
IF (NEW.artist NOT IN (SELECT name FROM Artists)) THEN
INSERT INTO Artists (name) VALUES(NEW.artist);
END IF;
END;//

CREATE TRIGGER AlbumInsertTrigger BEFORE INSERT ON Songs
FOR EACH ROW
BEGIN
IF(NOT NEW.album = NULL) THEN
IF (NEW.album NOT IN (SELECT name FROM Albums)) THEN
INSERT INTO Albums (name,artist) VALUES(NEW.album,NEW.artist);
END IF;
END IF;
END;//

CREATE TRIGGER GenreInsertTriggerArtists BEFORE INSERT ON Artists
FOR EACH ROW
BEGIN
IF(NOT NEW.genre = NULL) THEN
IF (NEW.genre NOT IN (SELECT genre FROM Genres)) THEN
INSERT INTO Genres (genre) VALUES(NEW.genre);
END IF;
END IF;
END;//

CREATE TRIGGER SongDuplicate BEFORE INSERT ON Songs
FOR EACH ROW
BEGIN
IF(NEW.name IN (SELECT name FROM Songs WHERE name = NEW.name AND artist = NEW.artist)) THEN
DELETE FROM Songs WHERE name = NEW.name AND artist = NEW.artist;
END IF;
END;//

INSERT INTO Songs (name,artist,album) VALUES ("Every Single Thing", "HOMESHAKE","Fresh Air")//
