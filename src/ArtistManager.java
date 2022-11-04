import java.util.HashMap;
import java.util.Scanner;

public class ArtistManager {
        HashMap<Integer,Artist> artists;
        Scanner scan = new Scanner(System.in);
    public ArtistManager() {
        this.artists = new HashMap<Integer,Artist>();
    }

    public void present(){
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
    }

    public void read(){
        print();
    }

    public void print(){
        for (Integer key:artists.keySet()) {
            System.out.println("Id is: " + key +" " + artists.keySet());
        }
    }
}
