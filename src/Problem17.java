
/**
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.


 * @author zachc
 *
 */
public class Problem17 {
	public static void main(String[] args) {
		int answer = 0;
		for(int i = 1; i <= 1000; i++) {
			answer += lengthOfStringInt(i);
		}
		
		System.out.println(answer);
	}
	
	public static int lengthOfStringInt(int n) {
		return String.valueOf(integerToString(n)).replaceAll(" ", "").length();
	}
	
	public static String integerToString(int n) {
		String stringValue = "";
		String[] values = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
				"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
		String[] tensPlaces = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		
		if(n == 1000) {
			return "one thousand";
		}
		
		int hundredsPlace = (n - (n % 100)) / 100;
		if(hundredsPlace != 0) {
			stringValue += values[hundredsPlace] + " hundred ";
		}
		
		n = n % 100;
		
		//If there is a hundreds place and a 0 does not follow
		if(n != 0 && hundredsPlace != 0) {
			stringValue += "and ";
		}
		
		if(n < 20) {
			stringValue += values[n];
		}else {
			int tensPlace = (n - (n % 10)) / 10;
			stringValue += tensPlaces[tensPlace-2];
			if(n % 10 != 0) {
				stringValue += " ";
			}
			stringValue += values[n%10];
		}
		
		return stringValue;
	}
}
