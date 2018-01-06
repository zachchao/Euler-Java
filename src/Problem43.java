import java.util.ArrayList;

/**
The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.

Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

d2d3d4=406 is divisible by 2
d3d4d5=063 is divisible by 3
d4d5d6=635 is divisible by 5
d5d6d7=357 is divisible by 7
d6d7d8=572 is divisible by 11
d7d8d9=728 is divisible by 13
d8d9d10=289 is divisible by 17
Find the sum of all 0 to 9 pandigital numbers with this property.

 * @author zachc
 *
 *
 *Runtime should be somewhere around 10!
 */
public class Problem43 {
	public static ArrayList<String> list = new ArrayList<String>();
	public static void main(String[] args) {
		final long startTime = System.currentTimeMillis();
		
		String s = "0123456789";
		
		double answer = 0;
		ArrayList<String> pandigitals = genPandigitals(s);
		for(String pandigital : pandigitals) {
			if(subStringDivisibility(pandigital)) {
				answer += Double.valueOf(pandigital);
			}
		}
		System.out.printf("%.0f\n", answer);
		
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) );
	}
	
	public static ArrayList<String> genPandigitals(String set) {
		ArrayList<String> returnList = new ArrayList<String>();
		if(set.length() == 1) {
			returnList.add(set);
		}else{
			for(String s : set.split("")) {
				String remainingCharacters = set.replace(s, "");
				ArrayList<String> permutations = genPandigitals(remainingCharacters);
				for(String permutation : permutations) {
					returnList.add(s + permutation);
				}
			}
		}
		return returnList;
	}
	
	public static boolean subStringDivisibility(String n) {
		String[] digits = n.split("");
		int[] primes = {2,3,5,7,11,13,17};
		for(int i = 1; i < 8; i++) {
			int subNum = Integer.valueOf(digits[i] + digits[i+1] + digits[i+2]);
			if(subNum % primes[i-1] != 0) {
				return false;
			}
		}
		return true;
	}
}
