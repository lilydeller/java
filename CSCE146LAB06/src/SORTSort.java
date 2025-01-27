/*
 * LILY DELLER
 */
import java.util.Scanner; // need scanner class to read input from the user
public class SORTSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // creating a scanner object to read user input
        String[] strings = new String[50]; // creating an array to store up to 50 strings
        int count = 0; // variable to keep track of the number of strings entered

        System.out.println("Hello! please enter as many strings as you'd like and I will sort by SORT’s. Once you’re done entering please enter “quit”.");

        // input loop to accept strings until the user types "quit"
        while (true) {
            String input = scanner.nextLine().toLowerCase(); // reading user input and converting it to lowercase
            if (input.equals("quit")) { // checking if the user wants to stop entering strings
                break; // exiting the loop if the user types "quit"
            }
            strings[count++] = input; // storing the input string in the array and incrementing the count
        }

        // sorting the strings using a method called sortStrings
        sortStrings(strings, count);

        // printing the sorted strings to the console
        System.out.println("\nSorted Strings:");
        for (int i = 0; i < count; i++) {
            if (strings[i] != null) // checking if the element in the array is not null before printing
                System.out.println(strings[i]); // printing the sorted strings one by one
        }

        // prompting the user if they want to sort more strings
        System.out.println("\nWould you like to sort more strings?\nYes\nNo");

        // reading the user's response
        String response = scanner.nextLine().toLowerCase(); // reading user input and converting it to lowercase
        if (response.equals("yes")) {
            // if the user wants to sort more strings, call the main method again to restart the process
            main(args);
        } else {
            System.out.println("Goodbye, come back later to sort!"); // if the user doesn't want to sort more strings, print a goodbye message
        }

        scanner.close(); // closing the scanner to release resources
    }

    // method to sort strings using insertion sort algorithm
    private static void sortStrings(String[] strings, int count) {
        for (int i = 1; i < count; i++) {
            String current = strings[i]; // storing the current string
            int j = i - 1; // setting the index to compare with
            int sortCountCurrent = countSort(current); // counting occurrences of "sort" in the current string
            while (j >= 0 && countSort(strings[j]) > sortCountCurrent) { // comparing occurrences of "sort" for sorting
                strings[j + 1] = strings[j]; // shifting elements to make space for insertion
                j--; // moving to the previous index
            }
            strings[j + 1] = current; // inserting the current string at the correct position
        }
    }

    // method to count the number of occurrences of "sort" in a string
    private static int countSort(String str) {
        return str.split("sort", -1).length - 1; // splitting the string based on "sort" and counting segments
    }
}
