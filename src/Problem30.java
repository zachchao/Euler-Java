import java.util.ArrayList;

/**
 Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

1634 = 14 + 64 + 34 + 44
8208 = 84 + 24 + 04 + 84
9474 = 94 + 44 + 74 + 44
As 1 = 14 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 * @author zachc
 *
 */
public class Problem30 {
	public static void main(String[] args) {
		ArrayList<Integer> powerDigitSums = new ArrayList<Integer>();
		for(int i = 101; i < 1000000; i++) {
			if(powerDigitSum(i, 5) == i) {
				powerDigitSums.add(i);
			}
		}
		System.out.println(powerDigitSums);
		
		//Sum it
		int answer = 0;
		for(int i : powerDigitSums) {
			answer += i;
		}
		System.out.println(answer);
	}
	
	public static int powerDigitSum(int num, int power) {
		String stringNum = String.valueOf(num);
		int sum = 0;
		for(String s : stringNum.split("")) {
			sum += Math.pow(Integer.valueOf(s), power);
		}
		return sum;
	}
}
