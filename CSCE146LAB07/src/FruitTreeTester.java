/*
 * LILY DELLER
 */

// these imports are necessary classes to work with our files and scanners
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// defining a class named FruitTreeTester via assignment guidelines
public class FruitTreeTester {
    // declaring a static variable 'fruitTree' of type LinkedBST<Fruit>
    private static LinkedBST<Fruit> fruitTree = new LinkedBST<>();

    // defining the main method, the starting point of our program
    public static void main(String[] args) {
        // we want to print a welcoming message to the user so they know what we're doing!
        System.out.println("Hello, welcome to the fruit tree!");

        // creating a scanner object to read input from the user / what their responses are
        Scanner scanner = new Scanner(System.in);

        // prompting the user to enter a filename containing fruit data
        System.out.print("Kindly enter a fruit file name (e.g., src/Fruit): ");

        // we need to read from the filename entered by the user
        String fileName = scanner.nextLine();

        // calling the populateTree method passing the filename as an argument
        populateTree(fileName);

        // calling the testTree method to show the functionalities of the fruit tree
        testTree();

        // closing the scanner to release system resources
        scanner.close();
    }

    // we need to define a method named populateTree responsible for populating the fruit tree
    private static void populateTree(String fileName) {
        try {
            // creating a file object representing the file specified by the filename
            File file = new File(fileName);

            // creating a scanner object to read from the file
            Scanner scanner = new Scanner(file);

            // reading data from the file line by line until there is no more data
            while (scanner.hasNextLine()) {
                // reading a line from the file
                String line = scanner.nextLine();

                // splitting the line into parts based on the tab character
                String[] parts = line.split("\t");

                // checking if there are exactly two parts (type and weight) on the line
                if (parts.length == 2) {
                    // extracting type and weight from the parts
                    String type = parts[0];
                    double weight = Double.parseDouble(parts[1]);

                    // creating a Fruit object with the extracted data
                    Fruit fruit = new Fruit(type, weight);

                    // adding the fruit to the fruit tree
                    fruitTree.add(fruit);
                }
            }

            // closing the scanner to release system resources
            scanner.close();
        } catch (FileNotFoundException e) {
            // handling the case where the specified file is not found
            System.out.println("File not found.");
        }
    }

    // we need to define a method named testTree to show the functionalities of the fruit tree
    private static void testTree() {
        // printing the fruits in the fruit tree in in-order traversal
        System.out.println("Printing in-order traversal");
        fruitTree.printInOrder();

        // printing the fruits in the fruit tree in pre-order traversal
        System.out.println("\nPrinting pre-order traversal");
        fruitTree.printPreOrder();

        // printing the fruits in the fruit tree in post-order traversal
        System.out.println("\nPrinting post-order traversal");
        fruitTree.printPostOrder();

        // creating a Fruit object to delete from the fruit tree
        Fruit fruitToDelete = new Fruit("Apple", 0.4859853412170728);

        // printing the fruit to be deleted
        System.out.println("\nDeleting " + fruitToDelete);

        // removing the specified fruit from the fruit tree
        fruitTree.remove(fruitToDelete);

        // printing the fruits in the fruit tree after deletion in in-order traversal
        System.out.println("\nPrinting in-order traversal after deletion");
        fruitTree.printInOrder();
    }
}
