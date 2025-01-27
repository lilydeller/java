//LILY DELLER
import java.io.*;
import java.util.Scanner;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList<T> {
    private Node<T> head;

    LinkedList() {
        this.setHead(null); //initialize linked list
    }

    //add new node to end of list
    void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (getHead() == null) {
            setHead(newNode);
        } else {
            Node<T> current = getHead();
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    //clear the list by setting to null
    void clear() {
        setHead(null);
    }

    // Method to search for games based on name or console
    LinkedList<T> search(String keyword, boolean byName) {
        LinkedList<T> results = new LinkedList<>();
        Node<T> current = getHead();
        while (current != null) {
            String gameInfo = (String) current.data;
            String[] parts = gameInfo.split("\t");
            String name = parts[0];
            String console = parts[1];

            //check if the keyword matches the name or console
            if ((byName && name.toLowerCase().contains(keyword.toLowerCase())) ||
                    (!byName && console.toLowerCase().contains(keyword.toLowerCase())) ||
                    keyword.equals("*")) {
                results.add(current.data);
            }
            current = current.next;
        }
        return results;
    }
    

    //print elements of list to console
    void printToConsole() {
        Node<T> current = getHead();
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    //print elements of list to file 
    void printToFile(String fileName, boolean append) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, append))) {
            Node<T> current = getHead();
            while (current != null) {
                writer.println(current.data);
                current = current.next;
            }
            System.out.println("Results printed to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}
}

public class VideoGameDataBase {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String FILE_FORMAT = "src/Collection.txt";
    private static final String FILE_FORMAT2 = "src/SuperGames.txt";


    public static void main(String[] args) {
        System.out.println("Welcome to the Video Game Database!\n");

        LinkedList<String> gameCollection = new LinkedList<>();
        String fileName = "";

        int choice;
        do {
        	//display menu option to user
            System.out.println("Enter 1 to load the video game database");
            System.out.println("Enter 2 to search the database");
            System.out.println("Enter 3 to print current results to the console");
            System.out.println("Enter 4 to print current results to file");
            System.out.println("Enter 0 to quit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    fileName = loadGameDatabase(gameCollection);
                    break;
                case 2:
                    searchDatabase(gameCollection);
                    break;
                case 3:
                    gameCollection.printToConsole();
                    break;
                case 4:
                    printResultsToFile(gameCollection, fileName);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 0);
    }

    //load the video game database from a file
    private static String loadGameDatabase(LinkedList<String> gameCollection) {
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();
        readFileAndPopulateList(gameCollection, fileName);
        return fileName;
    }

    private static void readFileAndPopulateList(LinkedList<String> gameCollection, String fileName) {
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            gameCollection.clear();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\t");
                if (parts.length == 2) {
                    gameCollection.add(line);
                }
            }
            System.out.println("File loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
    

    //search the database for user input
    private static void searchDatabase(LinkedList<String> gameCollection) {
        System.out.print("Enter the name of the game or '*' for all: ");
        String gameName = scanner.nextLine();
        System.out.print("Enter the name of the console or '*' for all: ");
        String consoleName = scanner.nextLine();

        LinkedList<String> searchResults = new LinkedList<>();
        LinkedList<String> nameResults = gameCollection.search(gameName, true);
        LinkedList<String> consoleResults = gameCollection.search(consoleName, false);

        Node<String> current = nameResults.getHead();
        while (current != null) {
            searchResults.add(current.data);
            current = current.next;
        }

        current = consoleResults.getHead();
        while (current != null) {
            searchResults.add(current.data);
            current = current.next;
        }

        searchResults.printToConsole();
    }

    private static void printResultsToFile(LinkedList<String> gameCollection, String fileName) {
        System.out.print("Enter the output file name: ");
        String outputFileName = scanner.nextLine();
        System.out.print("Would you like to append? True or false? ");
        boolean append = scanner.nextBoolean();
        scanner.nextLine();

        LinkedList<String> results = new LinkedList<>();
        Node<String> current = gameCollection.getHead();
        while (current != null) {
            results.add(current.data);
            current = current.next;
        }

        results.printToFile(outputFileName, append);
    }
}
