
/**
 * 12/20/17
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Project3 {
	public static void main(String[] args) {
		Double val = 600851475143.0;
		Double max = 0.0;
		for(double i = 2; i * i < val; i++) {
			if(val % i == 0 && shittyIsPrime(i)) {
				if( i > max) {
					max = i;
				}
			}
		}
		System.out.println(max);
	}
	
	public static boolean shittyIsPrime(Double n) {
		for (double i = 2; i * i <= n; i++) {
			if(n % i == 0.0) {
				return false;
			}
		}
		return true;
	}
}
