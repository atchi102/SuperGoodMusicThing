# SuperGoodMusicThing
Database Final Project
Abigail Atchison and Daniel Cole

In order to use the program run the sql files in this order:
tables.SQL
triggers.SQL
storedProcedures.SQL
insertValues.sql

Run this command in mysql:

GRANT ALL PRIVILEGES ON AtchisonColeFinal.* TO 'cpsc408'@'localhost' IDENTIFIED BY 'FY17cpsc408' WITH GRANT OPTION;

Compile these files:
Song.java
DBHandler.java

Then Compile and run:
GuiApp.java

Features:
The app populates with all songs in the database.

- Clicking a song will launch the recommendation system, giving you a recommedation of another song in the database based on
  - Valence (How happy or sad the song is)
  - Danceability
  - Accessibility (How well known the artist is, determined by # of active listeners on Spotify)
- Clicking on the column labels will sort the songs by that attribute
- Entering a term into the search bar and clicking the search button will search for songs, albums, artists, and genres with that term
