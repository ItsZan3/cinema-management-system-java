package projectprototype;

public class Movie3D extends Movie {

    private double price;
    private boolean needGlasses;
    private int seats;
    private int glassesAmount;

    public Movie3D(String name, String time, String duration, int seats, double price, boolean needGlasses, int glassesAmount) {
        super(name, time, duration);
        setPrice(price);
        this.needGlasses = needGlasses;
        this.glassesAmount = glassesAmount;
        setSeats(seats);
    }

    public int getGlassesAmount() {
        return glassesAmount;
    }

    public void setGlassesAmount(int glassesAmount) {
        this.glassesAmount = glassesAmount;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Invalid price, set to default price ($15)\n");
            this.price = 15;
        } else {
            this.price = price;
        }
    }

    public boolean isNeedGlasses() {
        return needGlasses;
    }

    public void setNeedGlasses(boolean needGlasses) {
        this.needGlasses = needGlasses;
    }

    //Random rand = new Random();

    @Override
    public String toString() {
        return super.toString() + "\n\tSeats: " + getSeats() + "\n\tTotal Price: $" +
            ((getPrice() * getSeats()) + (10 * getGlassesAmount()) + (snacks.getPopcorn() * 8) +
                (snacks.getChips() * 7.5) + (snacks.getCola() * 5.75) + (snacks.getWater() * 5)) +
            "\n\tTYPE: 3D" + "\n\tSEAT NUMBER: " + SeatNum.getSeatNum();
    }
}