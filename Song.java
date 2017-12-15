

public class Song
{
  private static int id;
  private static String name;
  private static String artist;
  private static String album;
  private static String genre;
  private static String songKey;


  public Song(int id, String name, String artist, String album, String genre, String songKey)
  {
    this.id = id;
    this.name = name;
    this.artist = artist;
    this.album = album;
    this.genre = genre;
    this.songKey = genre;
  }

  public getID()
  {
    return id;
  }

  public getName()
  {
    return name;
  }

  public getArtist()
  {
    return artist;
  }

  public getAlbum()
  {
    return album;
  }

  public getGenre()
  {
    return genre;
  }

  public getSongkey()
  {
    return songKey;
  }
}
