import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.image.*;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPasswordField;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.CallableStatement;
import java.util.ArrayList;

public class DBHandler	
{
	public Connection conn = null;
    public CallableStatement stmt = null;
    public ResultSet rs = null;

	public DBHandler()
	{
		try 
                {
                    System.out.println("Trying to connect to database");
                        // Establish the connection to the database.
                        conn = DriverManager.getConnection("jdbc:mysql://localhost/AtchisonColeFinal?" +
                            "user=cpsc408&password=FY17cpsc408&autoReconnect=true&useSSL=false&noAccessToProcedureBodies=true");

                        System.out.println("Well it didn't completely break?");
                } 
                catch (SQLException ex)
                {
                    // Handle any SQL errors.
                    System.out.println("SQLException: "+ ex.getMessage());
                    System.out.println("SQLState: "+ ex.getSQLState());
                    System.out.println("VendorError: " + ex.getErrorCode());
                } 
                System.out.println("idk whats happening");
	}

    public void deconstruct()
    {
                         // Close the result set handle.
                        if (rs != null) 
                        {
                                try 
                                {
                                    rs.close();
                                } 
                                catch (SQLException ex) 
                                { /* Ignore. */ 
                                }
                                rs = null;
                        }
                        // Close the statement handle.
                        if (stmt != null)
                        {
                                try {
                                    stmt.close();
                                } 
                                catch (SQLException ex) 
                                { /* Ignore. */ 
                                }
                                stmt = null;
                        }
                        // Close the connection handle.
                        if (conn != null)
                        {
                                try 
                                {
                                        conn.close();
                                } 
                                catch (SQLException ex) 
                                { /* Ignore. */ 
                                }
                                 conn = null;
                        }
    }

	public ArrayList<Song> search(String s)
	{
        ArrayList<Song> results = new ArrayList<Song>();
        try
        {
    		CallableStatement cStmt = conn.prepareCall("{call search("+s+")}");

            rs = cStmt.executeQuery();
            while (rs.next())
            {
                results.add(new Song(rs.getInt("id"),rs.getString("name"),rs.getString("artist"),rs.getString("album"),rs.getString("genre"),rs.getFloat("valence"),rs.getFloat("danceabilty"),rs.getFloat("accessibilty")));
            }
        }
        catch (SQLException ex)
        {
            // Handle any SQL errors.
            System.out.println("SQLException: "+ ex.getMessage());
            System.out.println("SQLState: "+ ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } 
        return results;
	}

    public ArrayList<Song> sortBy(String s)
    {
        ArrayList<Song> results = new ArrayList<Song>();
        try
        {
            CallableStatement cStmt = conn.prepareCall("{call sortBy("+s+")}");

            rs = cStmt.executeQuery();
            while (rs.next())
            {
                results.add(new Song(rs.getInt("id"),rs.getString("name"),rs.getString("artist"),rs.getString("album"),rs.getString("genre"),rs.getFloat("valence"),rs.getFloat("danceabilty"),rs.getFloat("accessibilty")));
            }
        }
        catch (SQLException ex)
        {
            // Handle any SQL errors.
            System.out.println("SQLException: "+ ex.getMessage());
            System.out.println("SQLState: "+ ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } 
        return results;
    }

    public static Song getRecommendation(ArrayList<Song> Songs, String compareToName)
  {
    Song compareTo = null;
    for(Song s : Songs)
    {
      if(s.getName().equals(compareToName))
      {
        compareTo = s;
        break;
      }
    }

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

    public ArrayList<Song> populate()
    {
        ArrayList<Song> results = new ArrayList<Song>();
        try
        {
            stmt = conn.prepareCall("{call populate()}");

            rs = stmt.executeQuery();

            while (rs.next())
            {
                results.add(new Song(rs.getInt("id"),rs.getString("name"),rs.getString("artist"),rs.getString("album"),rs.getString("genre"),rs.getFloat("valence"),rs.getFloat("danceabilty"),rs.getFloat("accessibilty")));
            }
        }
        catch (SQLException ex)
        {
            // Handle any SQL errors.
            System.out.println("SQLException: "+ ex.getMessage());
            System.out.println("SQLState: "+ ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } 
        return results;
    }
}