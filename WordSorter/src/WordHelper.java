import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordHelper {
    public static String[] sortByVowels(String[] input) {
        input = Arrays.copyOf(input, input.length);
        String[] sorted = new String[input.length];

        for (int i = 0; i < sorted.length; i++) {
            int greatestvalue = 0;
            int location = 0;

            for (int j = 0; j < input.length; j++) {
                int currentvalue = countbyVowels(input[j]);

                if (currentvalue > greatestvalue) {
                    greatestvalue = currentvalue;
                    location = j;
                }
            }
            sorted[i] = input[location];
            input[location] = "";
        }
        return sorted;
    }
    
	public static String[] sortByConsonants(String[] input) {
		String[] sorted = new String[input.length];
		
		for (int i = 0; i < sorted.length; i++) 		
		{
			//iterating through destination
			int greatestvalue = 0;
			int location = 0;
			//iterating through input
			for (int j = 0; j < input.length; j++){ 
				int currentvalue = countbyConsonants(input[j]);
				
				
				if (currentvalue>greatestvalue) {
					greatestvalue=currentvalue;
					location = j;
				}
				
			}
			sorted[i]=input[location];
			input[location]="";
		}
		return sorted;
}	 
	public static String[] sortByLength(String[] input) {
		String[] sorted = new String[input.length];
		
		for (int i = 0; i < sorted.length; i++) 		
		{
			//iterating through destination
			int greatestvalue = 0;
			int location = 0;
			//iterating through input
			for (int j = 0; j < input.length; j++){ 
				int currentvalue = input[j].length();
				
				
				if (currentvalue>greatestvalue) {
					greatestvalue=currentvalue;
					location = j;
				}
				
			}
			sorted[i]=input[location];
			input[location]="";
		}
		return sorted;
}	 
public static int countbyConsonants(String input){
    int total = 0;
        Pattern consonants = Pattern.compile("[b-df-hj-np-tv-z]");
        Matcher matchedInput = consonants.matcher(input.toLowerCase());
        while (matchedInput.find()){
            total++;
        }
    return total;
}
public static int countbyVowels(String input){
    int total = 0;
        Pattern vowels = Pattern.compile("[aeiouy]");
        Matcher matchedInput = vowels.matcher(input.toLowerCase());
        while (matchedInput.find()){
            total++;
        }
    return total;
	}
}
