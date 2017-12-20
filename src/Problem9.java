
/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 52.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Problem9 {
	public static void main(String[] args) {
		int sum = 1000;
		for(int a = 1; a <= sum / 2; a++) {
			for(int b = a + 1; b <= sum / 2; b++) {
				double c = Math.pow((a*a + b*b), 0.5);
				if(a + b + c == sum) {
					System.out.println(a + " " + b + " " + c);
					System.out.println(a * b * c);
				}
			}
		}
		System.out.println("Done");
	}
}
