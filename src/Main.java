
import java.io.*;
import java.util.Scanner;

public class Main {
//    static ArtistManager artists = new ArtistManager();

    static ArtistManager artists = new ArtistManager();
    static Scanner scan = new Scanner(System.in);

    static String option = " ";
public static void present(){
    System.out.println("Type C to create your playlist\n" + "Type R to see all playlist" + "Type U to update playlist\n" + "Type D to Delete a playlist\n" + "Type Q to quiz");
    option = scan.nextLine();
    if (option.equalsIgnoreCase("C")) {
        artists.create();
    } else if (option.equalsIgnoreCase("R")) {
        artists.read();
    } else if (option.equalsIgnoreCase("U")) {
        artists.update();
    } else if (option.equalsIgnoreCase("D")) {
        artists.remove();
    } else if (option.equalsIgnoreCase("Q")) {
        System.out.println("Goodbye");
    }
}
    public static void main(String[] args) throws Exception{

//        ArtistManager artists = new ArtistManager();
//        Scanner scan = new Scanner(System.in);


        System.out.println("Welcome to Oromo Music");
        while(!option.equalsIgnoreCase("Q")) {
            present();
        }

    }
}
