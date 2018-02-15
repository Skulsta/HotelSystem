package no.hotel.knowit;

public class HotelRoom {

    private int roomID;
    private int numberOfBeds;
    private int price;
    private String roomType;



    public HotelRoom (int roomID, int numberOfBeds, int price, String roomType) {
       setRoomID(roomID);
       this.numberOfBeds = numberOfBeds;
       this.price = price;
       setRoomType(roomType);
    }


    public HotelRoom(String encodedRoom) {
        String[] parts = encodedRoom.split("\t");

        this.roomID = Integer.parseInt(parts[0]);
        this.numberOfBeds = Integer.parseInt(parts[1]);
        this.price = Integer.parseInt(parts[2]);
        this.roomType = parts[3];
    }


    public void setRoomType (String roomType) {
        String[] roomTypes = {"Bryllupssuite", "Businessuite", "Kvalitetsrom", "Lavprisrom"};

        for (String typeOfRoom : roomTypes) {
            if (roomType.equals(typeOfRoom)) {
                this.roomType = roomType;
                return;
            }
        }
        throw new IllegalArgumentException("Room type has to be one of the followeing:\n" +
                "'Bryllupssuite', 'Businessuite', 'Kvalitetsrom' or 'Lavprisrom'");
    }



    public String getRoomType () {
        return roomType;
    }


    public void setRoomID (int roomID) {
        this.roomID = roomID;
    }


    public int getRoomID () {
        return roomID;
    }


    public int getNumberOfBeds () {
        return numberOfBeds;
    }


    @Override
    public String toString() {
        return "Room ID: " + roomID + ", Beds: " + numberOfBeds + ", Price: " + price + "\nRoom Type: " + roomType;
    }

    public String encode() {
        String encoded = "";

        encoded += roomID + "\t";
        encoded += numberOfBeds + "\t";
        encoded += price + "\t";
        encoded += roomType;

        return encoded;
    }
}
