import java.math.BigInteger;

/**
215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
What is the sum of the digits of the number 21000?

Easy with Python....
 */
public class Problem16 {
	public static void main(String[] args) {
		BigInteger val = BigInteger.ONE;
		for(int i = 0; i < 1000; i++) {
			val = val.multiply(BigInteger.valueOf(Long.valueOf("2")));
		}
		String num = val.toString();
		int powerDigitSum = 0;
		for(String s : num.split("")) {
			powerDigitSum += Integer.valueOf(s);
		}
		System.out.println(powerDigitSum);
	}
}
