
/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */
public class Problem10 {
	public static void main(String[] args) {
		boolean[] isPrime = sieveE(2000000);
		long sum = 0;
		
		for(int i = 2; i < isPrime.length; i++) {
			if(isPrime[i]) {
				sum += i;
			}
		}
		
		System.out.println(sum);
	}
	
	public static boolean[] sieveE(int n){
		boolean[] isPrime = new boolean[n+1];
		for (int i = 2; i <= n; i++) {
		    isPrime[i] = true;
		}
		
		for (int factor = 2; factor*factor <= n; factor++) {
		    if (isPrime[factor]) {
		        for (int j = factor; factor*j <= n; j++) {
		            isPrime[factor*j] = false;
		        }
		    }
		}
		return isPrime;
	}
}
