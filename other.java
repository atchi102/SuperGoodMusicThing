

import java.util.*;

public class other{

  public static void main(String[] args)
  {
  }

  public static Song getRecommendation(ArrayList<Song> Songs, Song compareTo)
  {
    double result = 100;
    double temp;
    Song song = null;

    for(Song s : Songs)
    {
      if(compareTo.equals(s))
        continue;
      temp = distance(compareTo.getValence(), compareTo.getDanceability(), compareTo.getAccessibility(), s.getValence(),s.getDanceability(),s.getAccessibility());
      if(result > temp){
        result = temp;
        song = s;
      }
    }

    return song;
  }

  public static double distance(double x1, double y1, double z1, double x2, double y2, double z2)
  {
      double zcoord = Math.abs(z1 - z2);
      double ycoord = Math.abs(y1 - y2);
      double xcoord = Math.abs(x1 - x2);
      double distance = Math.sqrt((ycoord)*(ycoord) +(xcoord)*(xcoord) + (zcoord)*(zcoord));
      System.out.println(distance);
      return distance;
  }
}
