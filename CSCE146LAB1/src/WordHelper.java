//LILY DELLER 
import java.util.Arrays;
public class WordHelper{
	
	public static String[] sortByVowels(String[] word) {
    // makes a copy of the input array to prevent changing the original array
    String[] copyVowels = Arrays.copyOf(word, word.length);
		for (int i = 0; i < copyVowels.length; i++) {
			copyVowels[i] = word[i];
		}
		// bubble sorter
		boolean hasSwapped = true;
		while (hasSwapped) {
			hasSwapped = false;
			for (int i = 0; i < copyVowels.length - 1; i++) {
				//creates 2 integers that compare how many vowels each word has, 
				//and then sorts them by size
				int count1 = countVowels(copyVowels[i]);
				int count2 = countVowels(copyVowels[i + 1]);
				if (count1 > count2) {
					// swap
					String temp = copyVowels[i];
					copyVowels[i] = copyVowels[i + 1];
					copyVowels[i + 1] = temp;
					hasSwapped = true;
					}
				}
			}
			return copyVowels;
	}

	public static String[] sortByConsonants(String[] word) {
		// creating and populating the copied array
		String[] copyConstant = new String[word.length];
		for (int i = 0; i < copyConstant.length; i++) {
			copyConstant[i] = word[i];
		}
		// bubble sorter
		boolean hasSwapped = true;
		while (hasSwapped) {
			hasSwapped = false;
			for (int i = 0; i < copyConstant.length - 1; i++) {
				int count1 = countConsonants(copyConstant[i]);
				int count2 = countConsonants(copyConstant[i + 1]);
				if (count1 > count2) {
					// swap 
					String temp = copyConstant[i];
					copyConstant[i] = copyConstant[i + 1];
					copyConstant[i + 1] = temp;
					hasSwapped = true;
					}
				}
			}
			return copyConstant;
	}

	public static String[] sortByLength(String[] word) {
		//this will create a copy of the original word list
		String[] copy = word.clone();
		boolean hasSwapped = true;

		//Bubble sorter
		while (hasSwapped) {
			hasSwapped = false;
			for (int i = 0; i < copy.length - 1; i++) {
				String temp = copy[i];
				if (copy[i].length() > copy[i + 1].length()) {
					// Swap
					copy[i] = copy[i + 1];
					copy[i + 1] = temp;
					hasSwapped = true;
					}
				}
			}
			return copy;
	}

	//this will create a for loop with an if statement inside to search/count vowels
	public static int countVowels(String word) {
		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			//if letter is a vowel, count it
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y') {
				count++;
				}
			}
		return count;
	}

	public static int countConsonants(String word) {
		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			//if letter is not a vowel, count it
			if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'y') {
				count++;
				}
			}
		return count;
	}
}

