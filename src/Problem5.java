
/**
* 2520 is the smallest number that can be divided by each of the numbers 
* from 1 to 10 without any remainder.
* What is the smallest positive number that is evenly divisible by all of
* the numbers from 1 to 20?
 */
public class Problem5 {
	public static void main(String[] args) {
		// 1 2 3   4   5   6   7    8      9     10
		// 1 2 3 (2*2) 5 (3*2) 7 (2*2*2) (3*3) (5*2)
		// 1 2     4   5       7           9
		System.out.println(1*2*4*5*7*9);
		// 1 2 3   4   5   6   7    8      9     10  11   12    13  14   15        16    17  18     19   20
		// 1 2 3 (2*2) 5 (3*2) 7 (2*2*2) (3*3) (5*2) 11 (3*2*2) 13 (7*2) (3*5) (2*2*2*2) 17 (3*3*2) 19 (5*2*2) 
		// 1           5       7           9         11         13                 16    17         19
		System.out.println(1*5*7*9*11*13*16*17*19);
	}
}
