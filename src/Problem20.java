import java.math.BigInteger;

/**
n! means n x (n - 1) x ... x 3 x 2 x 1

For example, 10! = 10 x 9 x ... x 3 x 2 x 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!
 */

public class Problem20 {
	public static void main(String args[]) {
		String num = factorial(BigInteger.valueOf(100)).toString();
		int sum = 0;
		for(String s : num.split("")) {
			sum += Integer.valueOf(s);
		}
		System.out.println(sum);
	}
	
	public static BigInteger factorial(BigInteger n) {
		if(n.equals(BigInteger.ONE)) {
			return BigInteger.ONE;
		}
		return n.multiply(factorial(n.subtract(BigInteger.ONE)));
	}
}
