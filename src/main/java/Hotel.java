import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {

    private ArrayList<Bedroom> bedroomsList;
    private ArrayList<ConferenceRoom> conferenceRoomsList;

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public ArrayList<Booking> bookings;
    public Hotel(){
        this.bedroomsList = new ArrayList<>();
        this.conferenceRoomsList = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }


    public void addBedroom(Bedroom bedroom) {
        this.bedroomsList.add(bedroom);
    }

    public void addConferenceRoom(ConferenceRoom conferenceRoom) {
        this.conferenceRoomsList.add(conferenceRoom);
    }

    public void addGuestToBedroom(GuestGroup guestGroup, Bedroom bedroom) {
        ArrayList<Bedroom> vacantRooms = this.returnVacantRooms();
        if (vacantRooms.contains(bedroom) && guestGroup.sizeOfGroup() <= bedroom.getCapacity()) {
            for (Guest guest: guestGroup.getGroup()) {
                bedroom.addGuest(guest);
            }
        }
    }

    public void addGuestToConferenceRoom(Guest guest, ConferenceRoom conferenceRoom) {
        if (conferenceRoom.getCurrentCapacity() < conferenceRoom.getCapacity()) {
            conferenceRoom.addGuest(guest);
        }
    }

    public void clearBedroom(Bedroom bedroom) {
        bedroom.clearGuests();
    }

    public void removeGuestToConferenceRoom(Guest guest, ConferenceRoom conferenceRoom) {
        conferenceRoom.removeGuest(guest);
    }

    public double bookRoom (int days, Bedroom bedroom) {
        this.bookings.add(new Booking(bedroom, days));
        return days * bedroom.getRate();
    }

    public HashMap<String, Integer> countRooms() {
        HashMap<String, Integer> rooms = new HashMap<>();
        for (Bedroom bedroom: this.bedroomsList) {
            int count = rooms.getOrDefault(bedroom.getType(), 0);
            rooms.put(bedroom.getType(), count + 1);
        }
        return rooms;
    }

    public ArrayList<Bedroom> returnVacantRooms() {
        ArrayList<Bedroom> vacantRooms = new ArrayList<>();
        for (Bedroom bedroom: this.bedroomsList) {
            if (bedroom.getCurrentCapacity() == 0){
                vacantRooms.add(bedroom);
            }
        }
        return vacantRooms;
    }
}


