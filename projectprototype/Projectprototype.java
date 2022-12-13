package projectprototype;

import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Projectprototype {

    static ArrayList < String > movies = new ArrayList < String > ();
    static ArrayList < String > cmovies = new ArrayList < String > ();
    static boolean isTicketAvailable = false;
    private static boolean isAdmin = false;
    public static void main(String[] args) {

        register();

    }

    public static void register(){
        Scanner input = new Scanner(System.in);
        String firstName = "";
        String lastName = "";
        String gender = "";
        String emailAddress = "";
        String password = "";
        String confirmPassword = "";
        System.out.println("\t\tCINEMA NAME\n\n");
        System.out.println("(1) Sign in \n");
        System.out.println("(2) Sign up \n");
        int reginput = input.nextInt();
        if(reginput == 1){
            System.out.println("Email Address : ");
            String email = input.next();
            System.out.println("Password : ");
            String pass = input.next();
            if(email.equals("Admin") && pass.equals("Admin")){
                isAdmin = true;
                System.out.println("Welcome Admin");
                printMenu();
            }
            
            else if(email.equals(emailAddress) && pass.equals(password)){
            System.out.println("Welcome " + firstName + " " + lastName +"\n\n" );

                printMenu();
            }
            else{
                System.out.println("Invalid Email or password, please try again \n");
                register();
            }
            
        }
        else if(reginput == 2){
            System.out.println("First Name : ");
            firstName = input.next();
            System.out.println("Last Name : ");
            lastName = input.next();
            System.out.println("Gender : ");
            gender = input.next();
            System.out.println("Email Address : ");
            emailAddress = input.next();
            System.out.println("Password : ");
            password = input.next();
            System.out.println("Confirm Password : ");
            confirmPassword = input.next();
            if(password.equals(confirmPassword)){
                System.out.println("Welcome " + firstName + " " + lastName  + "\n\n");
                printMenu();
            }
            else{
                System.out.println("Invalid Password, try again.");
                register();
            }
        }
        else{
            System.out.println("Invalid Input, try again.\n");
            register();
            
        }
    }
    public static void printMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("\t\tCINEMA NAME\n\n");
        System.out.println("Experience Movies here at CINEMA NAME\n\n");
        System.out.println("What would you like to do?\n");
        System.out.println("(1) Manage Movie\n");
        System.out.println("(2) Watch Movie\n");
        System.out.println("------------------------------------------\n");
        
        int menuinput = 0;
        
        do {
        try {
            
        menuinput = input.nextInt();
        
        if (menuinput == 1) {
            if(isAdmin == true){
                
            
            System.out.println("(1) Add Movie\n(2) Remove Movie\n");
            int m = input.nextInt();
            switch (m) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    if (Movie.getCounter() == 0) {
                        System.out.println("You have not added any movies to remove yet.\nWould you like to add one now?\n" +
                            "(1) Add Movie\n(2) Return to Menu\n");
                        if (input.nextInt() == 1) {
                            addMovie();
                        } else {
                            printMenu();
                        }
                    } else {
                        removeMovie();
                    }
                    break;
            }
            printMenu();
            }
            else{
                System.out.println("you are not an Admin ");
                printMenu();
            }
        } else if (menuinput == 2) {

            printMovies();

            System.out.println("\nSelect a movie by entering it's index number.");

            int i = input.nextInt();

            if (i <= movies.size()) {
                buyMovie(i);
            } else {
                System.out.println("\nInvalid input, going back...");
                printMenu();
            }
        } else {
            System.out.println("Invalid input, try again.");
        }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input, try again.");
            System.out.print("\033[H\033[2J");
            System.out.flush();
            
        }
        //menuinput = 0;
        } while (menuinput != 1 || menuinput != 2);
    }

    public static void addMovie() {

        Scanner input = new Scanner(System.in);

        System.out.println("\nWhat is the name of the movie?\n");

        String name = input.nextLine();

        System.out.println("\nHow long is the movie? ('x'h'y'm FORMAT)\n");

        String duration = input.next();

        System.out.println("\nWhat time does it start? (24-hour format)\n");

        String time = input.next();

        System.out.println("\nHow much is the ticket per person?\n");

        int price = input.nextInt();

        cmovies.add(name);
        cmovies.add(time);
        cmovies.add(duration);
        cmovies.add(String.valueOf(price));

        movies.add(new Movie(name, time, duration, price).mToString());

        System.out.println("\nMOVIE ADDED SUCCESSFULLY!\n\n");

        //ADD mToString TO A FILE
        
        saveFile(movies);
        
    }

    public static void removeMovie() {

        Scanner input = new Scanner(System.in);

        System.out.println("Here are the available movies:");

        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + "- " + movies.get(i) + "\n");
        }

        System.out.println("Enter the movie index to remove.\n");

        int r = input.nextInt();

        if (r <= movies.size()) {
            cmovies.remove((r * 4) - 4 + 3);
            cmovies.remove((r * 4) - 4 + 2);
            cmovies.remove((r * 4) - 4 + 1);
            cmovies.remove((r * 4) - 4);
            movies.remove(r - 1);
            Movie.setCounter(Movie.getCounter() - 1);
            System.out.println("MOVIE REMOVED SUCCESSFULLY!\n");
        } else {
            System.out.println("Invalid input, retrying...");
            removeMovie();
        }
        
        saveFile(movies);
        
    }

    public static void printMovies() {

        System.out.println("\nMOVIES SHOWING NOW\n\n");

        if (Movie.getCounter() == 0) {
            System.out.println("NO MOVIES SHOWING AT THIS TIME. CHECK AGAIN LATER.\n");
            System.out.println("\nGOING BACK TO THE MENU...\n\n");
            printMenu();
        } else {
            for (int i = 0; i < movies.size(); i++) {
                System.out.println((i + 1) + "- " + movies.get(i) + "\n");
            }
        }
    }

    public static void buyMovie(int index) {

        Scanner input = new Scanner(System.in);

        System.out.println("How many seats?\n");

        int s = input.nextInt();

        System.out.println("2D or 3D?\n");

        String d = input.next();

        SeatNum.clearSeatNum();

        if (d.startsWith("2")) {
            String m1 = cmovies.get((index * 4) - 4);
            String m2 = cmovies.get((index * 4) - 4 + 1);
            String m3 = cmovies.get((index * 4) - 4 + 2);
            int m4 = Integer.valueOf(cmovies.get((index * 4) - 4 + 3));
            selectSeats(s);
            Movie bmovie = new Movie2D(m1, m2, m3, s, m4);
            bmovie.buySnacks();
            fakeComm();
            System.out.println(bmovie.toString() + bmovie.getTotalSnacks());
            saveFile(bmovie.toString() + bmovie.getTotalSnacks());
        } else if (d.startsWith("3")) {
            String m1 = cmovies.get((index * 4) - 4);
            String m2 = cmovies.get((index * 4) - 4 + 1);
            String m3 = cmovies.get((index * 4) - 4 + 2);
            int m4 = Integer.valueOf(cmovies.get((index * 4) - 4 + 3));
            System.out.println("Do you need 3D Glasses for $10 each? (Y or N)\n");
            String answer = input.next();
            if (answer.startsWith("y") || answer.startsWith("Y")) {
                System.out.println("\nHow much do you need?");
                int amount = input.nextInt();
                selectSeats(s);
                Movie bmovie = new Movie3D(m1, m2, m3, s, m4, true, amount);
                bmovie.buySnacks();
                fakeComm();
                System.out.println(bmovie.toString() + bmovie.getTotalSnacks());
                saveFile(bmovie.toString() + bmovie.getTotalSnacks());
            } else if (answer.startsWith("n") || answer.startsWith("N")) {
                selectSeats(s);
                Movie bmovie = new Movie3D(m1, m2, m3, s, m4, false, 0);
                bmovie.buySnacks();
                fakeComm();
                System.out.println(bmovie.toString() + bmovie.getTotalSnacks());
                saveFile(bmovie.toString() + bmovie.getTotalSnacks());
            }
        }

        System.out.println("\nEnjoy your movie!\n");
        
        System.out.println("\nPress Enter to return to the menu");
        input.nextLine();
        input.nextLine();
        printMenu();
    }

    public static void selectSeats(int s) {

        ArrayList < Integer > a = new ArrayList < Integer > ();
        int seatsArray[] = new int[101];
        
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 100; i++) {
            int r = (new Random().nextInt(5));

            if (r != 2) {
                System.out.print(i + "  ");
                seatsArray[i] = i;
            } else {
                System.out.print("X  ");
                a.add(i);
                seatsArray[i] = 0;
            }
            if (i % 10 == 0) {
                System.out.print("\n");
            }
            
            
        }

        for (int j = 1; j <= s; j++) {
            System.out.println("\nPlease select a seat (" + j + "): ");
            int sinput = input.nextInt();

            if (sinput <= 100 && sinput >= 1) {
                while (a.contains(sinput)) {
                    System.out.println("This seat is already taken, choose another.\n");
                    sinput = input.nextInt();
                }

                SeatNum.addSeatNum(sinput);
                a.add(sinput);
                seatsArray[sinput] = 0;
                
                for (int i = 1; i <= 100; i++) {
                    System.out.print((seatsArray[i]==0 ? "X  ":i + "  "));
                    if (i%10==0) {
                        System.out.print("\n");
                    }
                }
            }

            SeatNum.sortSeatNum();
        }
    }

    private static void saveFile(ArrayList<String> a){
        File fileName = new File("Movies.txt"); 


        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter output = new BufferedWriter(fw);

            for (int i = 0; i < a.size(); i++){
                output.write(a.get(i).toString());
                output.newLine();
            }
            
            output.newLine();
            output.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "I cannot create that file");
        }
    }
    
    private static void saveFile(String a){
        
        if (isTicketAvailable) {
        
        File fileName = new File("Tickets.txt"); 

        try {
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter output = new BufferedWriter(fw);

            output.write(a);
            output.newLine();
            
            output.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "I cannot create that file");
        }
        } else {
            File fileName = new File("Tickets.txt"); 

        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter output = new BufferedWriter(fw);

            output.write(a);
            output.newLine();
            
            output.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "I cannot create that file");
        }
        
        isTicketAvailable = true;
        
        }
    }
    
    private static void fakeComm() {
        System.out.println("Communicating with server...");
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(2) + 3);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();;
        }
        System.out.println("Server reached! Creating ticket...");
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(2) + 3);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();;
        }
        System.out.println("Here is your ticket!\n");
    }
}

/* IDEAS:
LOGIN AND REGISTER SCREEN FOR MANAGING MOVIES

*/