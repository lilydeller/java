//LILY DELLER 
import java.io.File; //so we can work with files 
import java.io.FileNotFoundException; //in-case we can't find file
import java.io.FileWriter; //write data to a file
import java.io.IOException; //handle errors 
import java.util.Scanner; //read input from user or files

public class FileIOSolutions {

    // method to change "is" to "was" in a file
    public static void pastTense(String inputFileName, String outputFileName) {
        try {
        	//creating an object to represent the input file
            File inputFile = new File(inputFileName);
            //creating a tool to read from the input file
            Scanner scanner = new Scanner(inputFile);
            //creating an object to represent the output file
            FileWriter outputFileWriter = new FileWriter(outputFileName);

            //looping through each word in the input file
            while (scanner.hasNext()) {
            	//reading the next word
                String word = scanner.next();
                //checking if the word is "is" 
                if (word.equalsIgnoreCase("is")) {
                	//if it is, we change it to "was"
                    word = "was";
                }
                //printing to console
                System.out.println(word);
                outputFileWriter.write(word + "\n");
            }
            //closing the scanner and output file writer 
            scanner.close();
            outputFileWriter.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // method to calculate total combined volumes of tubes
    public static double totalTubeVolume(String fileName) {
        double totalVolume = 0.0;
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\t");
                if (parts.length == 3) {
                    try {
                        double radius = Double.parseDouble(parts[1]);
                        double height = Double.parseDouble(parts[2]);
                        double volume = Math.PI * radius * radius * height;
                        totalVolume += volume;
                    } catch (NumberFormatException e) {
                        
                    }
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        return totalVolume;
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("Welcome to the File I/O Problem's Solutions!");

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Enter 1. For Test 1\nEnter 2. For Test 2\nEnter 9. To Quit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("-----------------------\nTest01\n-----------------------");
                    System.out.println("Testing method \"pastTense\" with the file \"ItIs.txt\" and outputting to \"ItWas.txt\"");
                    pastTense("ItIs.txt", "ItWas.txt");
                    break;
                case 2:
                    System.out.println("-----------------------\nTest02\n-----------------------");
                    System.out.println("Testing method \"totalTubeVolume\" with the file \"Tubes.txt\"");
                    double totalVolume = totalTubeVolume("Tubes.txt");
                    System.out.println("The total combined volume is: " + totalVolume);
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 9);

        scanner.close();
    }
}