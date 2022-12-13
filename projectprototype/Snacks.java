package projectprototype;

public class Snacks {

    private int popcorn;
    private int chips;
    private int cola;
    private int water;

    public Snacks(int popcorn, int chips, int cola, int water) {
        this.popcorn = popcorn;
        this.chips = chips;
        this.cola = cola;
        this.water = water;
    }

    public Snacks() {
        this.popcorn = 0;
        this.chips = 0;
        this.cola = 0;
        this.water = 0;
    }

    public int getPopcorn() {
        return popcorn;
    }

    public void setPopcorn(int popcorn) {
        this.popcorn = popcorn;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public int getCola() {
        return cola;
    }

    public void setCola(int cola) {
        this.cola = cola;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    @Override
    public String toString() {
        if (popcorn == 0 && chips == 0 && cola == 0 && water == 0) {
            return "";
        } else {
            return "\nSnacks:\n\t" + (popcorn == 0 ? "" : "Popcorn: " + popcorn + "\n\t") +
                (chips == 0 ? "" : "Chips: " + chips + "\n\t") +
                (cola == 0 ? "" : "Cola: " + cola + "\n\t") +
                (water == 0 ? "" : "Water: " + water);
        }
    }
}