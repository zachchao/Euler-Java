
/**
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly 
into n).
If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and each of a and b are 
called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore 
d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
 */
public class Problem21 {

	public static void main(String[] args) {
		System.out.println(amicable());
		//System.out.println(sumOfDivisors(25));
		//System.out.println(sumOfDivisors(220));
	}
	
	
	//Returns the sum of the two amicable numbers, if they are not returns -1
	public static int amicable() {
		int sum = 0;
		
		for(int i = 1; i < 10000; i++) {
			for(int j = 1; j < 10000; j++) {
				if(i != j) {
					int sumI = sumOfDivisors(i);
					int sumJ = sumOfDivisors(j);
					if(sumI == j && sumI != -1) {
						if(sumJ == i && sumJ != -1) {
						System.out.println(i + " " + j);
						sum += i;
						sum += j;
						}
					}
				}
			}
		}
		return sum / 2;
	}
	
	public static int sumOfDivisors(int n) {
		int sum = 0;
		
		for(int i = 2; i * i < n; i++) {
			if(n % i == 0) {
				//smaller divisor
				sum += i;
				//larger divisor
				sum += n / i;
				//System.out.println(n + " " + i + " " + n/i);
			}
		}
		if(Math.pow(n, 0.5) % 1 == 0) {
			sum = (int) (sum + Math.pow(n, 0.5));
		}
		if(sum == 0) {
			return -1;
		}
		return sum + 1;
	}
}
