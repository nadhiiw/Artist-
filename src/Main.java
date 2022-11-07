
import java.io.*;
import java.util.Scanner;

public class Main {
//    static ArtistManager artists = new ArtistManager();

    static ArtistManager artists = new ArtistManager();
    static Scanner scan = new Scanner(System.in);

    static String option = " ";
public static void present(){
    System.out.println("Type C to create your playlist\n" + "Type R to see all playlist\n" + "Type U to update playlist\n" + "Type D to Delete a playlist\n" + "Type Q to quiz");
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
        System.out.println("Would you like to save");
        String save = scan.nextLine();
        if(save.equalsIgnoreCase("yes")){
            artists.serializeArtist();
        } else if(save.equalsIgnoreCase("no")) {
            System.out.println();
        }

    }
}
    public static void main(String[] args) throws Exception{
        System.out.println("Welcome to Oromo Music");
//        ArtistManager artists = new ArtistManager();
//        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like the load");
        String load = scan.nextLine();
        if(load.equalsIgnoreCase("Yes")){
            artists.deserializeArtist();
            while(!option.equalsIgnoreCase("Q")) {
                present();
            }
        } else if(load.equalsIgnoreCase("no")){
            while(!option.equalsIgnoreCase("Q")) {
                present();
            }
        }



    }
}
