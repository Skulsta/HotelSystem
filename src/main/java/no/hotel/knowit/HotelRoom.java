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
}
