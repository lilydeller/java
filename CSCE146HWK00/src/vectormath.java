//LILY DELLER
//the goal of this program is to perform some basic operations on vectors 
import java.util.Scanner;
public class vectormath{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // this will display a menu for the user to choose what math operation they'd like to complete
            System.out.println("Hi lets do some math!:");
            System.out.println("1. Vector Addition");
            System.out.println("2. Vector Subtraction");
            System.out.println("3. Find the Magnitude of a Vector");
            System.out.println("9. Exit");

            // this will prompt user to pick/choose 
            System.out.print("Please enter (1/2/3/9): ");
            int choice = scanner.nextInt();
            
            //will perform the operation chosen from user
            switch (choice) {
                case 1:
                    addition();
                    break;
                case 2:
                    subtraction();
                    break;
                case 3:
                    magnitude();
                    break;
                case 9:
                    System.out.println("Thats ok math is hard. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Please enter a valid number!!!.");
            }
        }
    }

    // Function for addition
    private static void addition() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the vectors please: ");
        int size = scanner.nextInt();

        //this will read the two vectors given from user
        double[] vector1 = readVector(size, 1);
        double[] vector2 = readVector(size, 2);

        double[] result = new double[size];

        for (int i = 0; i < size; i++) {
            result[i] = vector1[i] + vector2[i];
        }
        
        //this will display our result to user
        System.out.println("Result: " + arrayToString(result));
    }

    // Function for subtraction
    private static void subtraction() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the vectors please: ");
        int size = scanner.nextInt();

        //read vectors given from user
        double[] vector1 = readVector(size, 1);
        double[] vector2 = readVector(size, 2);

        //perform the subtraction
        double[] result = new double[size];

        for (int i = 0; i < size; i++) {
            result[i] = vector1[i] - vector2[i];
        }

        System.out.println("Result: " + arrayToString(result));
    }

    // Function for magnitude 
    private static void magnitude() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the vector please: ");
        int size = scanner.nextInt();

        double[] vector = readVector(size, 1);
        
        //will calculate the magnitude 
        double magnitude = 0;

        for (int i = 0; i < size; i++) {
            magnitude += Math.pow(vector[i], 2);
        }

        magnitude = Math.sqrt(magnitude);

        System.out.println("Magnitude of the Vector: " + magnitude);
    }

    // need to read vector values from user
    private static double[] readVector(int size, int vectorNumber) {
        Scanner scanner = new Scanner(System.in);

        double[] vector = new double[size];

        System.out.print("Enter values for Vector " + vectorNumber + ": ");
        for (int i = 0; i < size; i++) {
            vector[i] = scanner.nextDouble();
        }

        return vector;
    }

    // need to convert an array to string for display
    private static String arrayToString(double[] array) {
        StringBuilder result = new StringBuilder("[ ");
        for (double value : array) {
            result.append(value).append(" ");
        }
        result.append("]");
        return result.toString();
    }
}
