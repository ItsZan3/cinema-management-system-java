package projectprototype;

import java.util.Scanner;

public class Movie {

    private String name;
    private String time;
    private String duration;
    private static int counter = 0;
    private int tprice;
    protected static Snacks snacks = new Snacks();

    public Movie(String name, String time, String duration, int tprice) {

        this.name = name;
        this.time = time;
        this.duration = duration;
        setTPrice(tprice);
        counter++;
    }

    public Movie(String name, String time, String duration) {
        this.name = name;
        this.time = time;
        this.duration = duration;

    }

    public int getTPrice() {
        return tprice;
    }

    public void setTPrice(int tprice) {
        if (tprice < 0) {
            System.out.println("Invalid price, set to default price ($15)\n");
            this.tprice = 15;
        } else {
            this.tprice = tprice;
        }
    }

    public static int getCounter() {
        return Movie.counter;
    }

    public static void setCounter(int counter) {
        Movie.counter = counter;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Movie: " + getName() + "\n\tTime: " + getTime() + "\n\tDuration: " + getDuration();
    }

    public String mToString() {
        return "Movie: " + getName() + "\n\tTime: " + getTime() + "\n\tDuration: " + getDuration() + "\n\tTicket Price: $" + getTPrice();
    }

    public static void buySnacks() {

        snacks.setPopcorn(0);
        snacks.setChips(0);
        snacks.setCola(0);
        snacks.setWater(0);

        Scanner input = new Scanner(System.in);

        System.out.println("\nWhat snacks do you need?");
        System.out.println("(1) Popcorn ($8)");
        System.out.println("(2) Chips ($7.5)");
        System.out.println("(3) Cola ($5.75)");
        System.out.println("(4) Water ($5)");
        System.out.println("(5) I don't need snacks.");

        while (true) {

            switch (input.nextInt()) {
                case 1:
                    snacks.setPopcorn(snacks.getPopcorn() + 1);
                    System.out.println("\nPopcorn added. Total: " + snacks.getPopcorn() + " ($" + snacks.getPopcorn()*8 + ")");
                    break;
                case 2:
                    snacks.setChips(snacks.getChips() + 1);
                    System.out.println("\nChips added. Total: " + snacks.getChips() + " ($" + snacks.getChips()*7.5 + ")");
                    break;
                case 3:
                    snacks.setCola(snacks.getCola() + 1);
                    System.out.println("\nCola added. Total: " + snacks.getCola() + " ($" + snacks.getCola()*5.75 + ")");
                    break;
                case 4:
                    snacks.setWater(snacks.getWater() + 1);
                    System.out.println("\nWater added. Total: " + snacks.getWater() + " ($" + snacks.getWater()*5 + ")");
                    break;
                case 5:
                    return;
            }

            System.out.println("\nDo you need more snacks?");
            System.out.println("(1) Popcorn ($8)");
            System.out.println("(2) Chips ($7.5)");
            System.out.println("(3) Cola ($5.75)");
            System.out.println("(4) Water ($5)");
            System.out.println("(5) I don't need anymore snacks.");
        }
    }

    public static String getTotalSnacks() {
        return snacks.toString();
    }

}