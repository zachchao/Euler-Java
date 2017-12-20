import java.util.ArrayList;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, 
 * we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 */
public class Problem7 {
	public static void main(String[] args) {
		ArrayList<Double> primes = new ArrayList<Double>();
		int limit = 10001;
		double i = 1;
		
		while(primes.size() <= limit) {
			if(shittyIsPrime(i)) {
				primes.add(i);
			}
			i++;
		}
		
		System.out.println(primes.get(limit));
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
