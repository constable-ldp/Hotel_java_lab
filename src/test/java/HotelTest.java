import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel;
    private Guest guest01;
    private Guest guest02;
    private Guest guest03;
    private Guest guest04;
    private Bedroom bedroom01;
    private Bedroom bedroom02;
    private Bedroom bedroom03;
    private ConferenceRoom conferenceRoom01;
    private GuestGroup guestGroup01;
    private GuestGroup guestGroup02;

    @Before
    public void setUp(){
        guestGroup01 = new GuestGroup();
        guestGroup02 = new GuestGroup();
        hotel = new Hotel();
        guest01 = new Guest("Jamie");
        guest02 = new Guest("Jack");
        guest03 = new Guest("Jordan");
        guest04 = new Guest("John");
        bedroom01 = new Bedroom(1, 2, "Double", 50);
        bedroom02 = new Bedroom(2, 2, "Double", 50);
        bedroom03 = new Bedroom(3, 1, "Single", 30);
        conferenceRoom01 = new ConferenceRoom(2, "Room 01");
        hotel.addBedroom(bedroom01);
        hotel.addConferenceRoom(conferenceRoom01);
        guestGroup01.addToGroup(guest01);
        guestGroup01.addToGroup(guest02);
        guestGroup02.addToGroup(guest03);
        guestGroup02.addToGroup(guest04);

    }

    @Test
    public void canAddGuestToBedroom(){
        hotel.addGuestToBedroom(guestGroup01, bedroom01);
        assertEquals(2, bedroom01.getCurrentCapacity());
    }

    @Test
    public void canAddGuestToConferenceRoom() {
        hotel.addGuestToConferenceRoom(guest01, conferenceRoom01);
        hotel.addGuestToConferenceRoom(guest02, conferenceRoom01);
        hotel.addGuestToConferenceRoom(guest03, conferenceRoom01);
        assertEquals(2, conferenceRoom01.getCurrentCapacity());
    }

    @Test
    public void canRemoveGuestToBedroom(){
        hotel.addGuestToBedroom(guestGroup02, bedroom01);
        hotel.clearBedroom(bedroom01);
        assertEquals(0, bedroom01.getCurrentCapacity());
    }

    @Test
    public void canRemoveGuestToConferenceRoom() {
        hotel.addGuestToConferenceRoom(guest01, conferenceRoom01);
        hotel.addGuestToConferenceRoom(guest02, conferenceRoom01);
        hotel.removeGuestToConferenceRoom(guest02, conferenceRoom01);
        assertEquals(1, conferenceRoom01.getCurrentCapacity());
    }

    @Test
    public void canBookRoom(){
        hotel.bookRoom(5, bedroom01);
        assertEquals(1, hotel.bookings.size());
    }

    @Test
    public void canReturnBill(){
        assertEquals(250, hotel.bookRoom(5, bedroom01), 0.01);
    }

    @Test
    public void canCountRooms() {
        HashMap<String, Integer> testRooms = new HashMap<>();
        testRooms.put("Double", 2);
        testRooms.put("Single", 1);
        hotel.addBedroom(bedroom02);
        hotel.addBedroom(bedroom03);
        assertEquals(testRooms, hotel.countRooms());
    }

    @Test
    public void canCheckIfVacant() {
        hotel.addBedroom(bedroom02);
        ArrayList<Bedroom> testRooms = new ArrayList<>(Arrays.asList(bedroom02));
        hotel.addGuestToBedroom(guestGroup02, bedroom01);
        assertEquals(testRooms, hotel.returnVacantRooms());
    }

}
