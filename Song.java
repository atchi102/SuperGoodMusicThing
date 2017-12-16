

public class Song
{
  private int id;
  private String name;
  private String artist;
  private String album;
  private String genre;
  private String songKey;


  public Song(int id, String name, String artist, String album, String genre)
  {
    this.id = id;
    this.name = name;
    this.artist = artist;
    this.album = album;
    this.genre = genre;
  }

  public Song(int id, String name, String artist, String album, String genre, double valence, double dance, double access)
  {
    this.id = id;
    this.name = name;
    this.artist = artist;
    this.album = album;
    this.genre = genre;
    this.valence = valence;
    this.dance = dance;
    this.access = access;
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

  public double getValence()
  {
    return valence;
  }

  public double getDanceability()
  {
    return dance;
  }

  public double getAccessibility()
  {
    return access;
  }

  public boolean equals(Song s)
  {
    if id == s.getID() && name.equals(s.getName()) && album.equals(s.getAlbum())
      return true;

    return false;
  }

}
