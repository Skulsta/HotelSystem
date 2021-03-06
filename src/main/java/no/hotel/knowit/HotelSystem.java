package no.hotel.knowit;

import java.io.IOException;
import java.util.HashMap;

public class HotelSystem {

    private static HotelSystem hotelSystemSingleton;

    private HashMap<Integer, HotelRoom> rooms;


    public static HotelSystem getHotelSystem() {
        if (hotelSystemSingleton == null) {
            hotelSystemSingleton = new HotelSystem();
        }
        return hotelSystemSingleton;
    }

    public HotelSystem () {
        rooms = new HashMap<>();
    }


    public void registerRoom (HotelRoom room) {

        if (rooms.containsKey(room.getRoomID()))
            throw new IllegalArgumentException("Room ID is already registered");

        rooms.put(room.getRoomID(), room);
    }


    public void createRoom (int numberOfBeds, int price, String roomType) {
        HotelRoom room = new HotelRoom(rooms.size()+1, numberOfBeds, price, roomType);

        registerRoom(room);
    }


    public HashMap<Integer, HotelRoom> getRooms() {
        return rooms;
    }


    public void printRooms () {
        if (rooms.size() == 0)
            System.out.println("There are no rooms in the system");
        for (int i = 1; i <= rooms.size(); i++) {
            System.out.println(i + ".");
            System.out.println(rooms.get(i) + "\n");
        }
    }
}
