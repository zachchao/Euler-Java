import java.math.BigInteger;

/**
Starting in the top left corner of a 2×2 grid, and only being able to move to the 
right and down, there are exactly 6 routes to the bottom right corner.
How many such routes are there through a 20×20 grid?
 */

public class Problem15 {
	public static void main(String[] args) {
		BigInteger sizeOfGrid = BigInteger.valueOf(20);
		System.out.println(factorial(sizeOfGrid.multiply(BigInteger.valueOf(Long.valueOf("2"))))
				.divide((factorial(sizeOfGrid).multiply(factorial(sizeOfGrid)))));
	}
	
	public static BigInteger factorial(BigInteger n) {
		if(n.equals(BigInteger.ONE)) {
			return BigInteger.ONE;
		}
		return n.multiply(factorial(n.subtract(BigInteger.ONE)));
	}
}
