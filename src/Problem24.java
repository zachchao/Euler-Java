import java.util.ArrayList;

/**
 A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

@author zachc
 *
 */
public class Problem24 {
	public static ArrayList<String> list = new ArrayList<String>();
	public static void main(String[] args) {
		final long startTime = System.currentTimeMillis();
		
		String s = "0123456789";
		System.out.println(genPandigitals(s).get(999999));
		
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
}
