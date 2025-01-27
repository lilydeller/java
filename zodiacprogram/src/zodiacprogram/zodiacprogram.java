package zodiacprogram;
//lily deller
import java.util.Scanner;

class  zodiacprogram{
	public static void main (String[]args) {
    Scanner myObj = new Scanner(System.in);
    System.out.println("hi please enter birth month 1-12:");
    // asking first user input for birthday to calculate zodiac sign
    	int month = myObj.nextInt();
    System.out.println("please enter birth day as numbers:");
    //without birth day as an integer an error will pop up
    	int day = myObj.nextInt();
    String astro_sign = "";
    
    		//start of my if statements - to calculator your zodiac sign based on your date
    		if (month == 11 && day >= 22 && day <=30
            	|| month == 12 && day >= 1 && day <= 21) {
    			astro_sign = "Sagittarius";
    			System.out.println("Your zodiac sign is: " + astro_sign);
    			}
            //going month by month for each day requirements for different signs
            else if (month == 12 && day >= 22 && day <=30
                	|| month == 1 && day >= 1 && day <= 19) {
                astro_sign = "Capricorn";
                System.out.println("Your zodiac sign is: " + astro_sign);
                }
              
            else if (month == 1 && day >= 20 && day <=31
                	|| month == 2 && day >= 1 && day <= 18) {
                astro_sign = "Aquarius";
                System.out.println("Your zodiac sign is: " + astro_sign);
                }
            
            else if (month == 2 && day >= 19 && day <=29
                	|| month == 3 && day >= 1 && day <= 20) {
                astro_sign = "Pisces";
                System.out.println("Your zodiac sign is: " + astro_sign);
                }
          
            else if (month == 3 && day >= 21 && day <=31
                	|| month == 4 && day >= 1 && day <= 19) {
                astro_sign = "Aries";
                System.out.println("Your zodiac sign is: " + astro_sign);
                }
            
            else if (month == 4 && day >= 20 && day <=30
                	|| month == 5 && day >= 1 && day <= 20) {
                astro_sign = "Taurus";
                System.out.println("Your zodiac sign is: " + astro_sign);
                }
            
            else if (month == 5 && day >= 21 && day <=31
                	|| month == 6 && day >= 1 && day <= 20) {
                astro_sign = "Gemini";
                System.out.println("Your zodiac sign is: " + astro_sign);
                }
            
            else if (month == 6 && day >= 21 && day <=30
                	|| month == 7 && day >= 1 && day <= 22) {
                astro_sign = "Cancer";
                System.out.println("Your zodiac sign is: " + astro_sign);
                }
            
            else if (month == 7 && day >= 23 && day <=31
                	|| month == 8 && day >= 1 && day <= 22) {
                astro_sign = "Leo";
                System.out.println("Your zodiac sign is: " + astro_sign);
                }
            //leo's are the best
            else if (month == 8 && day >= 23 && day <=31
                	|| month == 9 && day >= 1 && day <= 22) {
                astro_sign = "Virgo";
                System.out.println("Your zodiac sign is: " + astro_sign);
            }
            
            else if (month == 9 && day >= 23 && day <=30
                	|| month == 10 && day >= 1 && day <= 22) {
                astro_sign = "Libra";
                System.out.println("Your zodiac sign is: " + astro_sign);
                }
            
            else if (month == 10 && day >= 23 && day <=31
                	|| month == 11 && day >= 1 && day <= 21) {
                astro_sign = "Scorpio";
                System.out.println("Your zodiac sign is: " + astro_sign);}
    		
            else if (month<1 || day <1) {
    			System.out.println("Error, please try again");
    			//error print out for invalidate dates or integers like a negative number 
    		}
    		
            
		}
	}
          
    
    
