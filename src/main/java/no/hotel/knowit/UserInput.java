package no.hotel.knowit;

import java.util.Scanner;

public class UserInput {

    private Scanner reader;


    public UserInput() {
        reader = new Scanner(System.in);
    }

    public String getInput () {
        return getInput("> ");
    }


    public String getInput (String prompt) {
        System.out.println(prompt);
        String inputLine = reader.nextLine();
        return inputLine;
    }

    public int getIntegerInput () {
        return reader.nextInt();
    }
}
