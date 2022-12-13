package projectprototype;

import java.util.ArrayList;
import java.util.Collections;

public class SeatNum {

    private static ArrayList < Integer > seatNum = new ArrayList < Integer > ();

    public static void addSeatNum(int s) {
        seatNum.add(s);
    }

    public static void clearSeatNum() {
        seatNum.clear();
    }

    public static String getSeatNum() {
        String s = "";
        for (int i = 0; i < seatNum.size() - 1; i++) {
            s += seatNum.get(i) + ", ";
        }
        s += seatNum.get(seatNum.size() - 1);
        return s;
    }

    public static void sortSeatNum() {
        Collections.sort(seatNum);
    }
}