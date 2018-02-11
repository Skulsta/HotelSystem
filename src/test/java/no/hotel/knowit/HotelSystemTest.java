package no.hotel.knowit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HotelSystemTest {

    private HotelSystem hotel;

    @Before
    public void setUp() throws Exception {
        hotel = new HotelSystem();
    }

    @Test
    public void registerRoom() {
        HotelRoom room = new HotelRoom(1, 3, 699, "Businessuite");

        hotel.registerRoom(room);

        assertEquals(1, hotel.getRooms().size());
    }

    @Test
    public void correctIDTest() {
        hotel.createRoom(2, 999, "Bryllupssuite");
        hotel.createRoom(5, 700, "Lavprisrom");

        int numberOfBeds = 5;
        assertEquals(numberOfBeds, hotel.getRooms().get(2).getNumberOfBeds());
    }


    @Test (expected = NullPointerException.class)
    public void nonExistingIDTest () {
        hotel.createRoom(2, 999, "Bryllupssuite");
        assertEquals(5, hotel.getRooms().get(2).getNumberOfBeds());
    }
}