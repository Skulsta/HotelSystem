package no.hotel.knowit;

public class Client {

    private HotelSystem hotelSystem;
    private UserInput reader;


    public Client () {
        hotelSystem = HotelSystem.getHotelSystem();
        reader = new UserInput();
    }

    public void start () {
        printWelcome();
        printHelp();

        boolean finished = false;
        while(!finished) {
            String userInput = reader.getInput();

            if (userInput.equals("help")) {
                printHelp();
            }

            if (userInput.equals("bye")) {
                finished = true;
            }

            if (userInput.equals("register")) {
                createRoom();
            }

            if (userInput.equals("rooms"))
                hotelSystem.printRooms();
        }

    }


    public void printWelcome () {
        System.out.println("Welcome to the system!");
    }


    public void printHelp() {
        System.out.println("\nHere's what you can do:");
        System.out.println("1. Type 'rooms' to see all rooms in the system");
        System.out.println("2. Type 'register' to register a new room");
        System.out.println("3. Type 'help' to get these instructions again.");
        System.out.println("4. Type 'bye' to close the program");
        System.out.println();
    }


    public void createRoom () {
        int roomID = hotelSystem.getRooms().size() + 1;

        System.out.println("Number of beds: ");
        int numberOfBeds = reader.getIntegerInput();

        System.out.println("Price: ");
        int price = reader.getIntegerInput();

        String roomType = chooseRoomType();


        HotelRoom room = new HotelRoom(roomID, numberOfBeds, price, roomType);

        System.out.println(room);

        System.out.println("\nType 'y' to confirm, or 'n' to cancel");

        boolean confirmationScreen = true;
        while (confirmationScreen) {
            String confirmation = reader.getInput();
            if (confirmation.equals("n")) {
                System.out.println("The registration was canceled.");
                confirmationScreen = false;
            }
            else if (confirmation.equals("y")) {
                hotelSystem.registerRoom(room);
                System.out.println("The room has been added to the system.");
                confirmationScreen = false;
            }
        }
    }

    public String chooseRoomType() {
        System.out.println("Which kind of room? 1. Bryllupssuite 2. Businessuite 3. Kvalitetsrom 4. Lavprisrom");

        int roomType = reader.getIntegerInput();
        switch (roomType) {
            case 1: return "Bryllupssuite";

            case 2: return "Businessuite";

            case 3: return "Kvalitetsrom";

            case 4: return "Lavprisrom";

            default:
                System.out.println("Type the corresponding number");
                break;
        }
        return chooseRoomType();
    }


    public static void main (String[] args) {
        Client client = new Client();
        client.start();
    }
}
