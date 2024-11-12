package BirthMonth;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class BirthMonth implements Runnable {
    private Set<String> group1;
    private Set<String> group2;
    private Set<String> self;

    public BirthMonth() {
        group1 = new HashSet<String>();
        group2 = new HashSet<String>();
        self = new HashSet<String>();
    }

    void promptUser() {
        
        for (int i = 1; i <= 4; i++) {
            System.out.print("Enter birth month number " + i + ": ");
            
        }
    }

    String getBirthMonth() {
        Scanner userInput = new Scanner(System.in);
        String BirthMonth = userInput.nextLine();
        for (ListOfBirthMonths month : ListOfBirthMonths.values()) {
            if (BirthMonth == month.toString().toUpperCase()) {
                return BirthMonth;
            }
        }
        return "Invalid month! Please try again";
    }

    private void printErrorMessage(String errorMessage) {
        clearScreen();
        System.out.print(errorMessage);
        char[] characters = {'.', ' ', '.', ' ', '.', ' ', '.'};

        for(int i = 0; i < characters.length; i++) {
            System.out.print(characters[i]);
            run();
        }
        clearScreen();
    }

    public void run() {
        try {
            Thread.sleep(350);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
