import java.util.ArrayList;

public class Bedroom {

    private int roomNumber;
    private int capacity;
    private ArrayList<Guest> bedroomGuestList;
    private String type;
    private double rate;

    public Bedroom(int roomNumber, int capacity, String type, double rate){
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.bedroomGuestList = new ArrayList<>();
        this.type = type;
        this.rate = rate;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentCapacity() {
        return this.bedroomGuestList.size();
    }

    public void addGuest(Guest guest) {
        this.bedroomGuestList.add(guest);
    }

    public void clearGuests() {
        this.bedroomGuestList.clear();
    }

    public double getRate() {
        return rate;
    }

    public String getType() {
        return type;
    }
}
