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
        print();
        serializeArtist(artists);
        deserializeArtist();
    }

    public void read(){
        print();
    }
    public void update(){
        System.out.println("Here is your playlist");
        print();
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
        print();
    }

    public void remove(){
        System.out.println("Here is your playlist");
        print();
        System.out.println("Which song you want to delete?");
        Integer delete = Integer.parseInt(scan.nextLine());
        artists.remove(delete);
        print();
    }

    public static void serializeArtist(HashMap<Integer,Artist> artist){
        try{
            FileOutputStream fileOut = new FileOutputStream("employees.ser");
            // ^ opening a connect to a new file and allowing to connect
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            // ^ streaming data from an object into a file
            out.writeObject(artist);
            // take this object and i'm lobbing it
            out.close();
            // close it once we are done with the file
            fileOut.close();
            // close it once we are done with the file
            System.out.println("Serialized data is saved!");


        }catch (IOException i) {
            i.printStackTrace();
            // history of all the methods that were called - allows us to see where the code went wrong.
            //principle of a stack is similar to pringles - last in, first out
        }

    }

    public static void deserializeArtist() {
// we need to read from the file object.ser the data for our employee
// and if possible create a new employee otherwise return null

        HashMap<Integer,Artist> artist = new HashMap<Integer,Artist>(); // this create an object of type employee to receive data from file or return

        try {
            // read object from a file
            FileInputStream file = new FileInputStream("employees.ser");
            // create a connect to a file
            ObjectInputStream in = new ObjectInputStream(file);

            // method for deserialization for an object
            artist = (HashMap<Integer, Artist>) in.readObject();
            // ^ read object and convert data to type Employee

            in.close();
            file.close();

            System.out.println("Object has been deserialized");
            System.out.println(artist.size());

        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }
    public void print(){
        for (Integer key:artists.keySet()) {
            System.out.println("Id is: " + key +" " + artists.get(key));
        }
    }
}
