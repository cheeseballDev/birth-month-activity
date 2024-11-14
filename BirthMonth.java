
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class BirthMonth implements Runnable {
    private Set<String> group1;
    private Set<String> group2;
    private Set<String> self;
    private Set<String> union;
    private Set<String> inter;
    private Set<String> diff; 

    public BirthMonth() {
        clearScreen();
        group1 = new HashSet<String>();
        group2 = new HashSet<String>();
        self = new HashSet<String>();
    }

    void promptUser() {
        Scanner userInput = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter birth month " + i + ": ");
            String month = userInput.nextLine().toUpperCase();
            if (!isValidBirthMonth(month)) {
                i--;
                printErrorMessage("Invalid month! Please try again");
                continue;
            }
            Collections.addAll(group1, month);
        }
        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter birth month " + i + ": ");
            String month = userInput.nextLine().toUpperCase();
            if (!isValidBirthMonth(month)) {
                i--;
                printErrorMessage("Invalid month! Please try again");
                continue;
            }
            Collections.addAll(group2, month);
        }
        printSets();
        System.out.print("Enter your birth month: ");
        Collections.addAll(self, getBirthMonth());
        if (union.containsAll(self)) {
            System.out.println("You have the same birth month with one of your classmates.");
        }
        userInput.close();
    }


    private void printSets() {
        System.out.println("Group 1: " + group1);
        System.out.println("Group 2: "+ group2);
        union = new HashSet<String>(group1);
        union.addAll(group2);
        inter = new HashSet<String>(group1);
        inter.retainAll(group2);
        diff = new HashSet<String>(group1);
        diff.removeAll(group2);
        System.out.println("Union: "+ union);
        System.out.println("Intersection: " + inter);
        System.out.println("Difference: " + diff);
    }


    private String getBirthMonth() {
        Scanner userInput = new Scanner(System.in);
        while (true) {
            String userMonth = userInput.nextLine().toUpperCase();
            if (!isValidBirthMonth(userMonth)) {
                userInput.nextLine();
                printErrorMessage("Invalid month! Please try again");
                continue;
            }
            userInput.close();
            return userMonth;
        }
    }

    private boolean isValidBirthMonth(String userMonth) {
        for (ListOfBirthMonths month: ListOfBirthMonths.values()) {
            if (month.name().equals(userMonth)) {
                return true;
            }
        }
        return false;
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
