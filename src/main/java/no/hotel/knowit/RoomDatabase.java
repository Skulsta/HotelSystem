package no.hotel.knowit;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RoomDatabase {

    private static RoomDatabase instance;
    private List<HotelRoom> rooms;
    public static final String DATABASE_FILENAME = "hoteldatabase.tsv";
    public static final Path DATABASE_PATH = Paths.get(DATABASE_FILENAME);


    private RoomDatabase() throws IOException {
        rooms = new ArrayList<HotelRoom>();
        // loadRooms();
        saveDatabase();
        listRooms();
    }


    public static RoomDatabase getInstance() throws IOException {
        if (instance == null) {
            instance = new RoomDatabase();
        }
        return instance;
    }


    public void addRoom(HotelRoom room) {
        rooms.add(room);
    }


    public void listRooms() {
        for (HotelRoom room : rooms)
            System.out.println(room.toString());
    }


    public boolean saveDatabase() throws IOException {
        FileWriter writer = new FileWriter(DATABASE_FILENAME);
        int i = 0;
        try {
            while (i < rooms.size()) {
                writer.write(rooms.get(i).encode());
                i++;
            }
            writer.close();
            return true;
        } catch (Exception e) {
            System.out.println("One entry failed");
            return false;
        }
    }


    public boolean loadDatabase() throws IOException {
        BufferedReader reader = Files.newBufferedReader(DATABASE_PATH);
        if (reader == null) {
            throw new IOException("File not found");
        }
        String encodedRoom = reader.readLine();
        while (encodedRoom != null) {
            HotelRoom room = new HotelRoom(encodedRoom);
            addRoom(room);
            encodedRoom = reader.readLine();
        }

        reader.close();
        return true;
    }
}
