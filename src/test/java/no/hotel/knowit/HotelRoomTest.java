package no.hotel.knowit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HotelRoomTest {

    private HotelRoom room;

    @Before
    public void setUp() throws Exception {
        room = new HotelRoom(11, 3, 599, "Businessuite");
    }

    @Test
    public void setRoomTypeTest() {
        assertEquals("Businessuite", room.getRoomType());
    }

    @Test (expected = IllegalArgumentException.class)
    public void IllegalRoomTypeTest () {
        room.setRoomType("NonExistingRoomType");

        assertEquals("Businessuite", room.getRoomType());
    }
}