import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ArtistManager {

        HashMap<Integer,Artist> artists;
        Scanner scan = new Scanner(System.in);
    public ArtistManager() {
        this.artists = new HashMap<Integer,Artist>();
    }

//
    public void create(){
        System.out.println("What is the name of the artist?");
        String name = scan.nextLine();
        System.out.println("What your favorite song?");
        String song = scan.nextLine();
        System.out.println("What year did song came out?");
        Integer year = Integer.parseInt(scan.nextLine());
        System.out.println("What is the id?");
        Integer id = Integer.parseInt(scan.nextLine());

        Artist songs = new Artist(name,song,year);
        artists.put(id,songs);
        serializeArtist();
        deserializeArtist();
    }

    public void read(){
        System.out.println("Here are your playlist");
        deserializeArtist();
    }
    public void update(){
        System.out.println("Here is your playlist");
        deserializeArtist();
        System.out.println("Which song you want to update?");
        Integer songUpdate = Integer.parseInt(scan.nextLine());
        artists.get(songUpdate);

        System.out.println("What is the name of the new artist?");
        String name = scan.nextLine();
        System.out.println("What your new favorite song?");
        String song = scan.nextLine();
        System.out.println("What year did song came out?");
        Integer year = Integer.parseInt(scan.nextLine());

        Artist updateSong = new Artist(name,song,year);
        artists.put(songUpdate,updateSong);
        serializeArtist();
        deserializeArtist();
    }

    public void remove(){
        System.out.println("Here is your playlist");
        deserializeArtist();
        System.out.println("Which song you want to delete?");
        Integer delete = Integer.parseInt(scan.nextLine());
        artists.remove(delete);
        serializeArtist();
        deserializeArtist();
    }

    public void serializeArtist(){
        try{
            FileOutputStream fileOut = new FileOutputStream("artist.ser");
            // ^ opening connect to a new file and allowing to connect

            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            // ^ streaming data from an object into a file
            out.writeObject(artists);
            // take this object

            out.close();
            // close it once we are done with the file
            fileOut.close();
            // close it once we are done with the file


        }catch (IOException i) {
            i.printStackTrace();
            // history of all the methods that were called - allows us to see where the code went wrong.
            //principle of a stack is similar to pringles - last in, first out
        }

    }

    public void deserializeArtist() {

        try {
            // read object from a file
            FileInputStream file = new FileInputStream("artist.ser");

            // create connect to a file
            ObjectInputStream in = new ObjectInputStream(file);

            // method for deserialization for an object
            artists = (HashMap<Integer, Artist>) in.readObject();
            // ^ read object and convert data to type artist

            in.close();
            file.close();

//            System.out.println("Object has been deserialized");
            System.out.println(artists);;

        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }
//    public void print(){
//        for (Integer key:artists.keySet()) {
//            System.out.println("Id is: " + key +" " + artists.get(key));
//        }
//    }
}
