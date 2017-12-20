import java.util.Stack;

/**
 * A palindromic number reads the same both ways. The largest palindrome 
 * made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4 {
	public static void main(String[] args) {
		int max = 0;
		for(int i = 999; i > 2; i--) {
			for(int j = 999; j > 2; j--) {
				if(isPalindrome(i * j) && (i * j) > max) {
					max = i * j;
					break;
				}
			}
		}
		System.out.println(max);
	}
	
	public static boolean isPalindrome(int i) {
		String[] ray = String.valueOf(i).split("");
		Stack<String> stack = new Stack<String>();
		//Put into stack
		for(String s : ray) {
			stack.push(s);
		}
		//Unload out
		for(String s : ray) {
			if(!stack.pop().equals(s)) {
				return false;
			}
		}
		return true;
	}
}
