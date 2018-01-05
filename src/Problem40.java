

/**
An irrational decimal fraction is created by concatenating the positive integers:

0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.

If dn represents the nth digit of the fractional part, find the value of the following expression.

d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 * @author zachc
 *
 */

import java.lang.StringBuilder;

public class Problem40 {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		constructDecimal();
		String[] decimal = sb.toString().split("");
		int answer = 1;
		for(int i = 1; i <= 1000000; i*=10) {
			answer *= Integer.valueOf(decimal[i-1]);
		}
		System.out.println(answer);
	}
	
	public static void constructDecimal() {
		int counter = 1;
		while(sb.length() <= 1000000) {
			sb.append(String.valueOf(counter++));
		}
	}
}
