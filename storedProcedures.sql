CREATE PROCEDURE userLogin( IN givenUsername CHAR(20))
BEGIN
  IF EXISTS(SELECT * FROM Users WHERE username = givenUsername) THEN
  SELECT * FROM Users WHERE username = givenUsername;
  ELSE
  INSERT INTO Users (username) VALUES(givenUsername);
  END IF;
END//
