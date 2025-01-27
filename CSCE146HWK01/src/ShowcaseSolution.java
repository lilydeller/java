//LILY DELLER
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

	//this class represents the solution for the game 
	public class ShowcaseSolution {
		//relative path to the file containing prize info
	    private static final String PRIZE_FILE_PATH = "src/prizes.txt"; 

	    //main method where the game execution starts! 
	    public static void main(String[] args) {
	        System.out.println("Welcome to the showcase show down!");
	        Prize[] prizes = readPrizesFromFile(PRIZE_FILE_PATH);

	        while (true) {
	            Prize[] showcase = selectPrizes(prizes);
	            displayPrizes(showcase);

	            double userGuess = getUserGuess();
	            double actualCost = calculateTotalCost(showcase);

	            if (userGuess <= actualCost && userGuess >= actualCost - 1300) {
	                System.out.println("You win omg!!!");
	            } else {
	                System.out.println("Your guess was " + (userGuess > actualCost ? "over" : "under") + ". Better luck next time!");
	            }

	            if (askToQuit()) {
	                System.out.println("bye!");
	                break;
	            }
	        }
	    }

	  //method to read prize info from the file and store it in an array 
	    private static Prize[] readPrizesFromFile(String filePath) {
	        Prize[] prizes = new Prize[0];
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] parts = line.split("\t");
	                if (parts.length == 2) {
	                    String name = parts[0];
	                    double price = Double.parseDouble(parts[1]);
	                    Prize prize = new Prize(name, price);
	                    prizes = Arrays.copyOf(prizes, prizes.length + 1);
	                    prizes[prizes.length - 1] = prize;
	                }
	            }
	        } catch (IOException | NumberFormatException e) {
	            System.out.println("Error reading the prize file. Make sure the file is formatted correctly.");
	        }
	        return prizes;
	    }
	    
	    //method to randomly select prizes 
	    private static Prize[] selectPrizes(Prize[] allPrizes) {
	        Random random = new Random();
	        Prize[] showcase = new Prize[5];

	        for (int i = 0; i < 5; i++) {
	            Prize randomPrize;
	            //make sure every price is unique
	            do {
	                randomPrize = allPrizes[random.nextInt(allPrizes.length)];
	            } while (Arrays.asList(showcase).contains(randomPrize));

	            showcase[i] = randomPrize;
	        }

	        return showcase;
	    }

	    //method to display the prizes 
	    private static void displayPrizes(Prize[] showcase) {
	        System.out.println("Available prizes are:");
	        for (Prize prize : showcase) {
	            System.out.println(prize.getName());
	        }
	    }
	    //method to get user's guess 
	    private static double getUserGuess() {
	        System.out.println("You must guess the total cost of the prizes without going over and within $1,300 of its actual price");
	        System.out.print("Please enter your BEST guess: ");
	        return new java.util.Scanner(System.in).nextDouble();
	    }

	    //method to calculate the total cost of the prizes 
	    private static double calculateTotalCost(Prize[] showcase) {
	        double totalCost = 0;
	        for (Prize prize : showcase) {
	            totalCost += prize.getPrice();
	        }
	        return totalCost;
	    }

	    //method to ask if they want to sadly leave the game 
	    private static boolean askToQuit() {
	        System.out.print("Are you done playing? Enter \"yes\" to quit: ");
	        String userInput = new java.util.Scanner(System.in).nextLine();
	        return "yes".equalsIgnoreCase(userInput);
	    }
	}
	
	class Prize {
	    private final String name;
	    private final double price;

	    //constructor to initialize name and price
	    public Prize(String name, double price) {
	        this.name = name;
	        this.price = price;
	    }

	    //getter for name
	    public String getName() {
	        return name;
	    }
	    
	    //getter for price
	    public double getPrice() {
	        return price;
	    }
	}
	
