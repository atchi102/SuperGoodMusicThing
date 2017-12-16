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
import javax.swing.JViewport;
import java.awt.CardLayout;

public class GuiApp1 {
 

 //Note: Typically the main method will be in a
 //separate class. As this is a simple one class
 //example it's all in the one class.
	 public static void main(String[] args) 
	 {
	 	new GuiApp1();
	 }

	 public GuiApp1()
	 {
                DBHandler database = new DBHandler();
                ArrayList<Song> results = database.populate();
                ArrayList<Song> songSort = database.sortBy("'Song'");
                ArrayList<Song> artistSort = database.sortBy("'Artist'");
                ArrayList<Song> albumSort = database.sortBy("'Album'");
                ArrayList<Song> genreSort = database.sortBy("'Genre'");

                JPanel data = new JPanel();
                JPanel songData = new JPanel();
                JPanel artistData = new JPanel();
                JPanel albumData = new JPanel();
                JPanel genreData = new JPanel();

                for(int i = 0; i < results.size(); i++)
                {
                    JPanel singleData = new JPanel(new FlowLayout());
                    singleData.setPreferredSize(new Dimension(800,25));
                    Song s = results.get(i);

                    JButton name = new JButton(s.getName());
                    JLabel artist = new JLabel(s.getArtist());
                    JLabel album = new JLabel(s.getAlbum());
                    JLabel genre = new JLabel(s.getGenre());

                    name.setPreferredSize(new Dimension(250,20));
                    artist.setPreferredSize(new Dimension(100,20));
                    album.setPreferredSize(new Dimension(100,20));
                    genre.setPreferredSize(new Dimension(50,20));


                    name.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {   
                                Song s = database.getRecommendation(results,name.getText());
    
                                JOptionPane.showMessageDialog(new JFrame(), "Because you like "+name.getText()+ ", we recommend "+ s.getName()+" by "+ s.getArtist());
                                
                            }
                        });

                    singleData.add(name);
                    singleData.add(artist);
                    singleData.add(album);
                    singleData.add(genre);
                    data.add(singleData);

                }

                for(int i=0; i < songSort.size(); i++)
                {
                    JPanel singleSong = new JPanel(new FlowLayout());
                    singleSong.setPreferredSize(new Dimension(800,25));
                    Song s = songSort.get(i);
                    
                    JButton name = new JButton(s.getName());
                    JLabel artist = new JLabel(s.getArtist());
                    JLabel album = new JLabel(s.getAlbum());
                    JLabel genre = new JLabel(s.getGenre());

                    name.setPreferredSize(new Dimension(250,20));
                    artist.setPreferredSize(new Dimension(100,20));
                    album.setPreferredSize(new Dimension(100,20));
                    genre.setPreferredSize(new Dimension(50,20));

                    name.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {   
                                Song s = database.getRecommendation(results,name.getText());
    
                                JOptionPane.showMessageDialog(new JFrame(), "Because you like "+name.getText()+ ", we recommend "+ s.getName()+" by "+ s.getArtist());
                                
                            }
                        });


                    singleSong.add(name);
                    singleSong.add(artist);
                    singleSong.add(album);
                    singleSong.add(genre);
                    songData.add(singleSong);
                }

                for(int i=0; i < artistSort.size(); i++)
                {
                    JPanel singleArtist = new JPanel(new FlowLayout());
                    singleArtist.setPreferredSize(new Dimension(800,25));
                    Song s = artistSort.get(i);
                    
                    JButton name = new JButton(s.getName());
                    JLabel artist = new JLabel(s.getArtist());
                    JLabel album = new JLabel(s.getAlbum());
                    JLabel genre = new JLabel(s.getGenre());

                    name.setPreferredSize(new Dimension(250,20));
                    artist.setPreferredSize(new Dimension(100,20));
                    album.setPreferredSize(new Dimension(100,20));
                    genre.setPreferredSize(new Dimension(50,20));

                    name.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {   
                                Song s = database.getRecommendation(results,name.getText());
    
                                JOptionPane.showMessageDialog(new JFrame(), "Because you like "+name.getText()+ ", we recommend "+ s.getName()+" by "+ s.getArtist());
                                
                            }
                        });


                    singleArtist.add(name);
                    singleArtist.add(artist);
                    singleArtist.add(album);
                    singleArtist.add(genre);
                    artistData.add(singleArtist);
                }

                for(int i=0; i < albumSort.size(); i++)
                {
                    JPanel singleAlbum = new JPanel(new FlowLayout());
                    singleAlbum.setPreferredSize(new Dimension(800,25));
                    Song s = albumSort.get(i);

                    JButton name = new JButton(s.getName());
                    JLabel artist = new JLabel(s.getArtist());
                    JLabel album = new JLabel(s.getAlbum());
                    JLabel genre = new JLabel(s.getGenre());

                    name.setPreferredSize(new Dimension(250,20));
                    artist.setPreferredSize(new Dimension(100,20));
                    album.setPreferredSize(new Dimension(100,20));
                    genre.setPreferredSize(new Dimension(50,20));

                    name.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {   
                                Song s = database.getRecommendation(results,name.getText());
    
                                JOptionPane.showMessageDialog(new JFrame(), "Because you like "+name.getText()+ ", we recommend "+ s.getName()+" by "+ s.getArtist());
                                
                            }
                        });


                    singleAlbum.add(name);
                    singleAlbum.add(artist);
                    singleAlbum.add(album);
                    singleAlbum.add(genre);
                    albumData.add(singleAlbum);                    
                }

                for(int i=0; i < genreSort.size(); i++)
                {
                    JPanel singleGenre = new JPanel(new FlowLayout());
                    singleGenre.setPreferredSize(new Dimension(800,25));
                    Song s = genreSort.get(i);
                    
                    JButton name = new JButton(s.getName());
                    JLabel artist = new JLabel(s.getArtist());
                    JLabel album = new JLabel(s.getAlbum());
                    JLabel genre = new JLabel(s.getGenre());

                    name.setPreferredSize(new Dimension(250,20));
                    artist.setPreferredSize(new Dimension(100,20));
                    album.setPreferredSize(new Dimension(100,20));
                    genre.setPreferredSize(new Dimension(50,20));

                    name.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {   
                                Song s = database.getRecommendation(results,name.getText());
    
                                JOptionPane.showMessageDialog(new JFrame(), "Because you like "+name.getText()+ ", we recommend "+ s.getName()+" by "+ s.getArtist());
                                
                            }
                        });


                    singleGenre.add(name);
                    singleGenre.add(artist);
                    singleGenre.add(album);
                    singleGenre.add(genre);
                    genreData.add(singleGenre);
                }

                JPanel dataHolder = new JPanel(new CardLayout());
                dataHolder.setPreferredSize(new Dimension(600,1500));
                dataHolder.add("dataCard", data);
                dataHolder.add("songCard", songData);
                dataHolder.add("artistCard", artistData);
                dataHolder.add("albumCard", albumData);
                dataHolder.add("genreCard", genreData);


                JFrame frame = new JFrame("Moozik");
                frame.setResizable(false);
                JPanel panel = new JPanel();

                panel.setLayout(new FlowLayout());

                JLabel userLabel = new JLabel("Username:");
                JTextField userNameTextBox = new JTextField(15);
                JButton button = new JButton();

                button.setText("Login");
                button.addActionListener(new ActionListener()
                {
        	public void actionPerformed(ActionEvent e)
        	{
        		//Check Login Credentials
        		userLabel.setText(userNameTextBox.getText());
        		panel.add(new JLabel("Invalid Credentials"));
        		panel.setVisible(false);
        		        JPanel panel2 = new JPanel();
        		//add username to database

                        JPanel gui = new JPanel(new BorderLayout());
                        gui.setBorder(new TitledBorder("Moozik"));

                        JPanel labels = new JPanel();
                        labels.setBorder(new TitledBorder(userLabel.getText()+ "'s Songs"));

                        JButton song = new JButton("Song");
                        song.setPreferredSize(new Dimension(200, 25));
                        labels.add(song);
                        song.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {   
                                CardLayout cl = (CardLayout)(dataHolder.getLayout());
                                cl.show(dataHolder,"songCard");
                            }
                        });
                
                        JButton artist = new JButton("Artist");
                        artist.setPreferredSize(new Dimension(100, 25));
                        labels.add(artist);
                        artist.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {   
                                CardLayout cl = (CardLayout)(dataHolder.getLayout());
                                cl.show(dataHolder,"artistCard");
                            }
                        });

                        JButton album = new JButton("Album");
                        artist.setPreferredSize(new Dimension(100, 25));
                        labels.add(album);
                        album.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {   
                                CardLayout cl = (CardLayout)(dataHolder.getLayout());
                                cl.show(dataHolder,"albumCard");
                            }
                        });
                       
                        JButton genre = new JButton("Genre");
                        genre.setPreferredSize(new Dimension(100, 25));
                        labels.add(genre);
                        genre.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {   
                                CardLayout cl = (CardLayout)(dataHolder.getLayout());
                                cl.show(dataHolder,"genreCard");
                            }
                        });

                        
                        
                        JScrollPane scroll = new JScrollPane(dataHolder);
                        scroll.setViewportView(dataHolder);

                        gui.add(labels, BorderLayout.NORTH);

                        gui.add(scroll,BorderLayout.CENTER);
                       
                        JPanel search = new JPanel(new FlowLayout());
                        JTextField searchBar = new JTextField("Search Here...");
                        searchBar.setPreferredSize(new Dimension(600,20));

                        JButton searchButton = new JButton("Search");
                        searchButton.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {   
                                DBHandler database2 = new DBHandler();
                                ArrayList<Song> results2 = database2.search("'"+searchBar.getText()+"'");

                                JPanel searchData = new JPanel();

                                for(int i=0; i < results2.size(); i++)
                                {
                                    JPanel single = new JPanel(new FlowLayout());
                                    Song s = results2.get(i);


                                    JButton name = new JButton(s.getName());
                                    single.add(name);
                                    single.add(new JLabel(s.getName()));
                                    single.add(new JLabel(s.getArtist()));
                                    single.add(new JLabel(s.getAlbum()));
                                    single.add(new JLabel(s.getGenre()));
                                    searchData.add(single);
                                }    
                                dataHolder.add("searchCard", searchData);

                                CardLayout cl = (CardLayout)(dataHolder.getLayout());
                                cl.show(dataHolder,"searchCard");
                                
                            }
                        });

                        search.add(searchBar);
                        search.add(searchButton);
                        gui.add(search,BorderLayout.SOUTH);
                        frame.add(gui);

                        frame.setSize(800,600);
        	}
        });
 
        panel.add(new JLabel(new ImageIcon("spotify.png")));
        panel.add(userLabel);
        panel.add(userNameTextBox);
        panel.add(button);
        
        database.deconstruct();

        frame.add(panel);

        frame.setSize(200, 350);

        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);




	 	/*
		 JFrame guiFrame = new JFrame();
		 

		 //make sure the program exits when the frame closes
		 guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 guiFrame.setTitle("Example GUI");
		 guiFrame.setSize(500,400);
		 
		 JButton button = new JButton("Click here!");
		 guiFrame.add(button);
		 //This will center the JFrame in the middle of the screen
		 guiFrame.setLocationRelativeTo(null);
		 button.setPreferredSize(new Dimension(100,100));
		 
		 
		 //make sure the JFrame is visible
		 guiFrame.setVisible(true);*/
		 }
	 
	}