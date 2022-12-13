package projectprototype;


public class VipTicket extends Movie {
   
    private double vipTprice;
    private int vipSeats;
    
    public  VipTicket(String name, String time, String duration, double vipTprice, int vipSeats){
        super(name, time, duration);
        this.vipTprice=vipTprice;
        this.vipSeats=vipSeats;
    }

    public void setVipTprice(double vipTprice) {
    if (vipTprice < 0) {
            System.out.println("Invalid price, set to default price ($50)\n");
            this.vipTprice = 50;
        } else {
            this.vipTprice = vipTprice;
        }
    }

    public void setVipSeats(int vipSeats) {
        if (vipSeats < 1) {
            System.out.println("Invalid seats, seats set to 1");
            this.vipSeats = 1;
        } else {
            this.vipSeats = vipSeats;
        }
    }

    public double getVipTprice() {
        return vipTprice;
    }

    public int getVipSeats() {
        return vipSeats;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tVip Ticket price: " + getVipTprice() + "vipSeats: " + getVipSeats();
    }
    
}
