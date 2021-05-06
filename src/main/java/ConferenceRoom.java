import java.util.ArrayList;

public class ConferenceRoom {

    private int capacity;
    private ArrayList<Guest> conferenceGuestList;
    private String name;

    public ConferenceRoom(int capacity, String name) {
        this.capacity = capacity;
        this.conferenceGuestList = new ArrayList<>();
        this.name = name;
    }
    public int getCapacity() {
        return capacity;
    }

    public int getCurrentCapacity() {
        return this.conferenceGuestList.size();
    }

    public void addGuest(Guest guest) {
        this.conferenceGuestList.add(guest);
    }

    public void removeGuest(Guest guest) {
        this.conferenceGuestList.remove(guest);
    }
}
