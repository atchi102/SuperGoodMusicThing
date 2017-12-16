

public class Song
{
  private static int id;
  private static String name;
  private static String artist;
  private static String album;
  private static String genre;
  private static String songKey;


  public Song(int id, String name, String artist, String album, String genre)
  {
    this.id = id;
    this.name = name;
    this.artist = artist;
    this.album = album;
    this.genre = genre;
  }

  public int getID()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public String getArtist()
  {
    return artist;
  }

  public String getAlbum()
  {
    return album;
  }

  public String getGenre()
  {
    return genre;
  }

  public boolean equals(Song s)
  {
    if id == s.getID() && name.equals(s.getName()) && album.equals(s.getAlbum())
      return true;

    return false;
  }

}
