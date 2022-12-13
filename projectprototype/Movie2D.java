package projectprototype;

public class Movie2D extends Movie {

    private double price;
    private int seats;

    public Movie2D(String name, String time, String duration, int seats, double price) {
        super(name, time, duration);
        setPrice(price);
        setSeats(seats);
    }

    public double getPrice() {
        return price;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        if (seats < 1) {
            System.out.println("Invalid seats, seats set to 1");
            this.seats = 1;
        } else {
            this.seats = seats;
        }
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Invalid price, set to default price ($15)\n");
            this.price = 15;
        } else {
            this.price = price;
        }
    }

    //Random rand = new Random();

    @Override
    public String toString() {
        return super.toString() + "\n\tSeats: " + getSeats() + "\n\tTotal Price: $" + ((getPrice() * getSeats()) +
                (snacks.getPopcorn() * 8) + (snacks.getChips() * 7.5) + (snacks.getCola() * 5.75) + (snacks.getWater() * 5)) +
            "\n\tTYPE: 2D" + "\n\tSEAT NUMBER: " + SeatNum.getSeatNum();
    }


}