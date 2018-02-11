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
        }

    }


    public void printWelcome () {
        System.out.println("Welcome to the system!");
    }


    public void printHelp() {
        System.out.println("\nHere's what you can do:");
        System.out.println("1. Type 'rooms' to see all rooms in the system");
        System.out.println("2. Type 'help' to get these instructions again.");
        System.out.println("3. Type 'bye' to close the program");
        System.out.println();
    }


    public static void main (String[] args) {
        Client client = new Client();
        client.start();
    }
}
