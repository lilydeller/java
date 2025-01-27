import java.util.Scanner;
import java.util.Random;
//Lily Deller
//TODO prompt user to enter rock, paper, or scissors
//play three rounds & ask to play again
//error message for invalid user input (example: scissors instead of Scissors)
// else if statements for all possible inputs
// ending game or replaying game 
public class rockpaperscissors {

    public static void main(String[] args) {
        

        //Prompt user to enter rock, paper, or scissors
        //Compare random value
    		while(true){
        int wins = 0;
        int losses = 0;
        int rnd = 0;
        int USER = 0;

        System.out.print("Welcome to Rock Paper Scissors! We'll play best 2 out of 3! \n"
            + "Enter \"Rock\", \"Paper\" or \"Scissors\" \n");


        // Plays 3 rounds before terminating
        	while(rnd<3) {

            Random GAME = new Random();
            int PC = 1+GAME.nextInt(3);

            Scanner keyboard = new Scanner (System.in);
            int SCISSOR, ROCK, PAPER;
            ROCK = 1;
            PAPER = 2;
            SCISSOR= 3;

            String USER_Input =  keyboard.next();
            if(USER_Input.equals("Rock"))  {
                   USER = 1;
            }
            if(USER_Input.equals("Paper")) {
                   USER = 2;
            }
            if(USER_Input.equals("Scissors")) {
                   USER = 3;
            }



            //If the user enters a value greater then 3 or less than 1 it will terminate the program
            
            while (USER > 3 || USER < 1) {
                System.err.println("Incorrect value entered.");
                System.exit(0);
                break;
            }

            if(USER == PC){
                if(USER == SCISSOR){
                    System.out.println("Scissors v Scissors! Tie!");

            }
                if(USER == ROCK){
                    System.out.println("Rock v Rock! Tie!");
            }
                if(USER == PAPER){
                    System.out.println("Paper v Paper! Tie!");
            }
                System.out.println("Player has won " + wins + " times and the computer has won " + losses + " times");
                System.out.print("Enter \"Rock\", \"Paper\" or \"Scissors\" \n");
            }
            //starting if else statements 
            //player wins

            if(USER == SCISSOR)
                if(PC == PAPER){
                System.out.println("Scissors v Paper! Player Wins!");
                wins++;
                rnd++;
                System.out.println("Player has won " + wins + " times and the computer has won " + losses + " times");
                System.out.print("Enter \"Rock\", \"Paper\" or \"Scissors\" \n");
            }
            //computer wins
            else if(PC == ROCK){
                System.out.println("Scissors v Rock! Computer Wins!");
                losses++;
                rnd++;
                System.out.println("Player has won " + wins + " times and the computer has won " + losses + " times");
                System.out.print("Enter \"Rock\", \"Paper\" or \"Scissors\" \n");
            }
            //player wins

            if(USER == ROCK)
                if(PC == SCISSOR ){
                System.out.println("Rock v Scissor! Player Wins!");
                wins++;
                rnd++;
                System.out.println("Player has won " + wins + " times and the computer has won " + losses + " times");
                System.out.print("Enter \"Rock\", \"Paper\" or \"Scissors\" \n");
            }   
            //computer wins
            else if (PC == PAPER){
                System.out.println("Rock v Paper! Computer Wins!");
                losses++;
                rnd++;
                System.out.println("Player has won " + wins + " times and the computer has won " + losses + " times");
                System.out.print("Enter \"Rock\", \"Paper\" or \"Scissors\" \n");
            }

            //player Wins
            if(USER == PAPER)
                if(PC == ROCK){
                System.out.println("Paper v Rock! Player Wins!");
                wins++;
                rnd++;
                System.out.println("Player has won " + wins + " times and the computer has won " + losses + " times");
                System.out.print("Enter \"Rock\", \"Paper\" or \"Scissors\" \n");
                }
            //computer Wins 
            else if (PC == SCISSOR){
                System.out.println("Paper v Scissors! Computer Wins!");
                losses++;
                rnd++;
                System.out.println("Player has won " + wins + " times and the computer has won " + losses + " times");
                System.out.print("Enter \"Rock\", \"Paper\" or \"Scissors\" \n");
            }

            }

            if(wins>losses){
                System.out.println("The Player Wins!");
            }if(losses>wins){
                System.out.println("The Computer Wins haha!");
                //determining winner
            }
            System.out.println("Play again? \"Yes\" or \"No\"");
            Scanner YN = new Scanner(System.in);

            String YN_String = YN.next();
            if(YN_String.equals("Yes") || YN_String.equals("yes")){
            }if(YN_String.equals("No") || YN_String.equals("no")) {
                System.out.println ("Ok! Play again sometime!");
                break;
                //break to stop the game 
            }

        }
    }

}
